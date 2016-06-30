/**
 * 
 */
package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

	WebDriver web_driver = null;
	DesiredCapabilities cap = null;
	Properties config_ = SeleniumBaseFile.getInstance().configurations_File;
	static Log log = LogFactory.getLog(BrowserFactory.class);

	public WebDriver intialiseBrowser() throws MalformedURLException {

		if (web_driver == null) {
			if (browserName_("firefox")) {
				remoteWebdriver_(cap, "firefox", "WIN10_Firefox");
			} else if (browserName_("chrome")) {
				remoteWebdriver_(cap, "chrome", "WIN10_Chrome");
			} else if (browserName_("ie8")) {
				remoteWebdriver_(cap, "ie8", "WIN10_IE8");
			} else if (browserName_("ie9")) {
				remoteWebdriver_(cap, "ie9", "WIN10_IE9");
			} else if (browserName_("ie10")) {
				remoteWebdriver_(cap, "ie10", "WIN10_IE10");
			} else if (browserName_("ie11")) {
				remoteWebdriver_(cap, "ie11", "WIN10_IE11");
			} else {
				defaultDriver_();
			}
			maximizeBrowsersize_();
		}
		log.info("Opening Driver ");
		return web_driver;

	}

	private void remoteWebdriver_(DesiredCapabilities cap, String Browsername, String vmUrl)
			throws MalformedURLException {

		switch (Browsername) {
		case "firefox":
			cap = firefoxCapabalities_(Browsername);
			remoteWebdriverUrl_(cap, vmUrl);
			break;
		case "chrome":
			cap = chromeCapabailities_(Browsername);
			remoteWebdriverUrl_(cap, vmUrl);
			break;
		case "ie8":
			cap = ieCapabilities_("xp");
			remoteWebdriverUrl_(cap, vmUrl);
			break;
		case "ie9":
			cap = ieCapabilities_("windows");
			remoteWebdriverUrl_(cap, vmUrl);
			break;
		case "ie10":
			cap = ieCapabilities_("windows");
			remoteWebdriverUrl_(cap, vmUrl);
			break;
		case "ie11":
			cap = ieCapabilities_("windows");
			remoteWebdriverUrl_(cap, vmUrl);
			break;

		}
	}

	private DesiredCapabilities chromeCapabailities_(String browsername) {
		cap = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		cap.setBrowserName(browsername);
		log.info(cap.getBrowserName());
		cap.setPlatform(org.openqa.selenium.Platform.ANY);
		return cap;

	}

	private DesiredCapabilities firefoxCapabalities_(String Browsername) {
		cap = DesiredCapabilities.firefox();
		cap.setCapability("TakesScreenshot", true);
		cap.setBrowserName(Browsername);
		log.info(cap.getBrowserName());
		cap.setPlatform(org.openqa.selenium.Platform.ANY);
		return cap;
	}

	private DesiredCapabilities ieCapabilities_(String platform) {
		cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability("ensureCleanSession", true);
		cap.setCapability("TakesScreenshot", true);
		cap.setBrowserName("internet explorer");
		log.info(cap.getBrowserName());
		if (platform.equalsIgnoreCase("xp")) {
			cap.setPlatform(org.openqa.selenium.Platform.XP);
		} else {
			cap.setPlatform(org.openqa.selenium.Platform.ANY);
		}

		return cap;
	}

	private void remoteWebdriverUrl_(DesiredCapabilities cap, String vmUrl) throws MalformedURLException {
		web_driver = new RemoteWebDriver(new URL(config_.getProperty(vmUrl)), cap);

	}

	private void defaultDriver_() {
		web_driver = new FirefoxDriver();
	}

	private boolean browserName_(String browsername) {
		return System.getProperty("browser").equalsIgnoreCase(browsername);

	}

	private void maximizeBrowsersize_() {
		web_driver.manage().window().maximize();
	}

}