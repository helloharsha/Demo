package utils;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class SeleniumBaseFile {

	static SeleniumBaseFile sel;
	public Properties object_Repository;
	public Properties configurations_File;
	private BrowserFactory browserFactory;

	static Log log = LogFactory.getLog(SeleniumBaseFile.class);

	private SeleniumBaseFile() {

		loadPropertiesFiles_();
	}

	public static SeleniumBaseFile getInstance() {
		try {
			if (sel == null)
				sel = new SeleniumBaseFile();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return sel;
	}

	public synchronized WebDriver sharedDriver() {
		browserFactory = new BrowserFactory();
		try {
			return browserFactory.intialiseBrowser();
		} catch (MalformedURLException e) {
			throw new InternalError();
		}

	}

	private void loadPropertiesFiles_() {

		if (object_Repository == null) {
			try {
				object_Repository = new Properties();
				object_Repository
						.load(this.getClass().getClassLoader().getResourceAsStream("ObjectRepository.properties"));
				log.info("load Object Repository");
			} catch (Exception e) {
				log.error("Error on intializing ObjectRepository files:" + e.getCause());
				e.printStackTrace();
			}

			if (configurations_File == null) {
				try {
					configurations_File = new Properties();
					configurations_File.load(new FileInputStream("Automation.properties"));
					log.info("Load Config Repository");
				} catch (Exception e) {
					log.error("Error on intializing OsMapMaker properties Files" + e.getCause());
					e.printStackTrace();
				}
			}

		}
	}

}