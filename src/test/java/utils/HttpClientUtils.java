package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.jayway.jsonpath.JsonPath;

import baseFile.BaseFile;


public class HttpClientUtils extends BaseFile{
	
	public CloseableHttpResponse response;
    protected CloseableHttpClient mHttpClient;
    protected static JdbcTemplate JDBC_TEMPLATE;
    protected static TransactionTemplate TXN_TEMPLATE;
    protected static final String KEY_ENDPOINT = "endpoint";
    SeleniumBaseFile base = SeleniumBaseFile.getInstance();
    
    protected List<NameValuePair> parameters = new ArrayList<NameValuePair>();


    public CloseableHttpClient getHttpClient() {
        if (mHttpClient == null) {
            SSLContextBuilder builder = new SSLContextBuilder();
            try {
                builder.loadTrustMaterial(null, new TrustAllStrategy());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyStoreException e) {
                e.printStackTrace();
            }
            SSLConnectionSocketFactory socketFactory = null;
            try {
                socketFactory = new SSLConnectionSocketFactory(
                        builder.build(), SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
            mHttpClient = httpClient;
        }
        return mHttpClient;
    }


    public void closeHttpClient() {
        if (mHttpClient != null) {
            try {
                mHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mHttpClient = null;
        }
    }



    private class TrustAllStrategy implements TrustStrategy {
        @Override
        public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            return true;
        }
    }

    /**
     * Given a local path URL generate and a fully qualified URL and return the URI representation.
     * <p>
     * The local path should start with a leading slash Eg. /some/local/path
     * <p>
     * The protocol, port and context root of the URL are all read from the application property KEY_ENDPOINT.
     *
     * @param localPath the local path
     * @return URI of the fully qualified URL
     */
    public URI getEndpointUri(final String localPath) {
        final String fullPath = String.format("%s%s", getEndpoint(), localPath);
        log(fullPath);
        return URI.create(fullPath);
    }


    protected void log(final String message) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/tmp/mvm.log", true)))) {
            out.println(message);
            out.flush();
            out.close();
        } catch (IOException e) {
        }
    }

    protected String getEndpoint() {
        return config_.getProperty(KEY_ENDPOINT);
    }

    protected String getEndpoint(String path) {
        return getEndpoint().concat(path);
    }

    protected void addParameter(String key, String value) {
        parameters.add(new BasicNameValuePair(key, value));
    }

    protected HttpEntity addQueryParams() throws UnsupportedEncodingException {
        HttpEntity entity = new UrlEncodedFormEntity(parameters);
        return entity;
    }

   



}
