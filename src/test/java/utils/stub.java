/**
 * 
 */
package utils;

import java.io.StringWriter;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class stub {

	private static WebDriver driver;
	private static Logger log = Logger.getLogger(stub.class);
	public static void testCookieIsSecured_() throws Exception {

		Set<Cookie> c = driver.manage().getCookies();
		Iterator<Cookie> iter = c.iterator();
		while (iter.hasNext()) {
			Cookie cookie = iter.next();
			log.info(cookie.getDomain() + "---" + cookie.getName()
					+ "-----------" + cookie.getPath() + "------------"
					+ cookie.getValue());
			Assert.assertTrue(cookie.isSecure());
			log.info("verified cookie is secured");

		}
	}
	

	
}
