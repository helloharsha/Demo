/**
 * 
 */
package baseFile;

import java.util.Properties;

import utils.HttpClientUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utils.SeleniumBaseFile;
import utils.SeleniumUtils;
import utils.SeleniumWait;


public abstract class BaseFile {

	public static SeleniumBaseFile selenium = SeleniumBaseFile.getInstance();
	public static WebDriver web_driver = selenium.sharedDriver();
	public static Properties or_ = selenium.object_Repository;
	public static Properties config_ = selenium.configurations_File;
	public static SeleniumUtils seleniumutils = new SeleniumUtils();
	public static SeleniumWait seleniumwait = new SeleniumWait();
	public static JavascriptExecutor js_ = (JavascriptExecutor) web_driver;
	public static Actions humanAction_ = new Actions(web_driver);
	public static utils.videoRecord videoRecord = new utils.videoRecord();

}
