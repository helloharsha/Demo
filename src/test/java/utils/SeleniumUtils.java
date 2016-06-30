/**
 * 
 */
package utils;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Select;

import baseFile.BaseFile;
import cucumber.api.Scenario;


public class SeleniumUtils extends BaseFile {

	static Log log = LogFactory.getLog(SeleniumUtils.class);

	protected Scenario scenario;

	
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	protected void embedTextInReport(String text) {
		scenario.write(text);
	}

	protected void embedXmlInReport(String xml) {
		xml = "<textarea readonly>" + xml + "</textarea>";
		scenario.write(xml);
	}

	public void navigateTo_(String URL) {
		try {
			web_driver.get(config_.getProperty(URL));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUrl(String url) {
		try {
			System.out.println("geting " + url);
			web_driver.get(url);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return url;
	}

	// get text
	public String getTextByXPath_(String objectName) {

		return web_driver.findElement(By.xpath(or_.getProperty(objectName)))
				.getText();

	}

	public String getTextByCss_(String objectName) {

		return web_driver.findElement(
				By.cssSelector(or_.getProperty(objectName))).getText();

	}

	public String getTextByid_(String objectName) {

		return web_driver.findElement(By.id(or_.getProperty(objectName)))
				.getText();

	}

	// assign to a webelement
	public WebElement webElementBy_ID(String objectName) {
		WebElement assignelement = web_driver.findElement(By.id(or_
				.getProperty(objectName)));
		return assignelement;
	}

	public WebElement webElementBy_Xpath(String objectName) {
		WebElement assignelement = web_driver.findElement(By.xpath(or_
				.getProperty(objectName)));
		return assignelement;
	}

	public WebElement webElementBy_CSS(String objectName) {
		WebElement assignelement = web_driver.findElement(By.cssSelector(or_
				.getProperty(objectName)));
		return assignelement;
	}

	public WebElement webElementBy_Name(String objectName) {
		WebElement assignelement = web_driver.findElement(By.name(or_
				.getProperty(objectName)));
		return assignelement;
	}

	public WebElement webElementBy_ClassName(String objectName) {
		WebElement assignelement = web_driver.findElement(By.className(or_
				.getProperty(objectName)));
		return assignelement;
	}

	// list to a webelement
	public List<WebElement> listwebElementsBy_ID(String objectName) {
		List<WebElement> assignelement = web_driver.findElements(By.id(or_
				.getProperty(objectName)));
		return assignelement;
	}

	public List<WebElement> listwebElementsBy_Xpath(String objectName) {
		List<WebElement> assignelement = (List<WebElement>) web_driver
				.findElements(By.xpath(or_.getProperty(objectName)));
		return assignelement;
	}

	public WebElement listwebElementsBy_CSS(String objectName) {
		WebElement assignelement = (WebElement) web_driver.findElements(By
				.cssSelector(or_.getProperty(objectName)));
		return assignelement;
	}

	// clearby ID

	public void clearBYID_(String objectName) {

		web_driver.findElement(By.id(or_.getProperty(objectName))).clear();
	}

	public void clear_Css(String objectName) {

		web_driver.findElement(By.cssSelector(or_.getProperty(objectName)))
				.clear();
	}

	public void clearBY_Xpath(String objectName) {

		web_driver.findElement(By.xpath(or_.getProperty(objectName))).clear();
	}

	public void clearBY_Name(String objectName) {

		web_driver.findElement(By.name(or_.getProperty(objectName))).clear();
	}

	// clicking on any object
	public void clickByXPath_(String objectName) {

		web_driver.findElement(By.xpath(or_.getProperty(objectName))).click();

	}

	public void clickByCSS_(String objectName) {

		web_driver.findElement(By.cssSelector(or_.getProperty(objectName)))
				.click();
	}

	public void clickBY_LinkText(String text) {
		web_driver.findElement(By.linkText(text)).click();
	}

	public void clickById_(String objectName) {

		web_driver.findElement(By.id(or_.getProperty(objectName))).click();
	}

	public void clickBy_Class(String objectName) {

		web_driver.findElement(By.className(or_.getProperty(objectName)))
				.click();
	}

	public void clickBy_Name(String objectName) {

		web_driver.findElement(By.name(or_.getProperty(objectName))).click();
	}

	// Type

	public void typeByXpath_(String text, String objectName) {

		web_driver.findElement(By.xpath(or_.getProperty(objectName)))
				.sendKeys(text);
	}

	public void typeBy_Id(String text, String objectName) {

		web_driver.findElement(By.id(or_.getProperty(objectName))).sendKeys(
				text);
	}

	public void typeBy_Name(String text, String objectName) {

		web_driver.findElement(By.name(or_.getProperty(objectName))).sendKeys(
				text);
	}

	public void typeBy_Class(String text, String objectName) {

		web_driver.findElement(By.className(or_.getProperty(objectName)))
				.sendKeys(text);
	}

	public void typeByCSS_(String text, String objectName) {

		web_driver.findElement(By.cssSelector(or_.getProperty(objectName)))
				.sendKeys(text);
	}

	// Select
	public void selectByIdvisibletext_(String text, String objectName) {

		Select te = new Select(web_driver.findElement(By.id((or_
				.getProperty(objectName)))));
		te.selectByVisibleText(text);

	}

	public void selectByclass_visibletext(String text, String objectName) {

		Select te = new Select(web_driver.findElement(By.className((or_
				.getProperty(objectName)))));
		te.selectByVisibleText(text);

	}

	public void selectByName_visibletext(String text, String objectName) {

		Select te = new Select(web_driver.findElement(By.name((or_
				.getProperty(objectName)))));
		te.selectByVisibleText(text);

	}

	public void selectByCSS_visibletext(String text, String objectName) {

		Select te = new Select(web_driver.findElement(By.cssSelector((or_
				.getProperty(objectName)))));
		te.selectByVisibleText(text);

	}

	public void selectByxpath_visibletext(String text, String objectName) {

		Select te = new Select(web_driver.findElement(By.xpath((or_
				.getProperty(objectName)))));
		te.selectByVisibleText(text);

	}

	public void selectByid_ByIndex(int text, String objectName) {

		Select te = new Select(web_driver.findElement(By.id((or_
				.getProperty(objectName)))));
		te.selectByIndex(text);

	}

	public void selectByclass_ByIndex(int text, String objectName) {

		Select te = new Select(web_driver.findElement(By.className((or_
				.getProperty(objectName)))));
		te.selectByIndex(text);

	}

	public void selectByName_ByIndex(int text, String objectName) {

		Select te = new Select(web_driver.findElement(By.name((or_
				.getProperty(objectName)))));
		te.selectByIndex(text);

	}

	public void selectByCSS_ByIndex(int text, String objectName) {

		Select te = new Select(web_driver.findElement(By.cssSelector((or_
				.getProperty(objectName)))));
		te.selectByIndex(text);

	}

	public void selectByxpath_ByIndex(int text, String objectName) {

		Select te = new Select(web_driver.findElement(By.xpath((or_
				.getProperty(objectName)))));
		te.selectByIndex(text);

	}

	public void selectByid_ByValue(String text, String objectName) {

		Select te = new Select(web_driver.findElement(By.id((or_
				.getProperty(objectName)))));
		te.selectByValue(text);

	}

	public void selectByclass_ByValue(String text, String objectName) {

		Select te = new Select(web_driver.findElement(By.className((or_
				.getProperty(objectName)))));
		te.selectByValue(text);

	}

	public void selectByName_ByValue(String text, String objectName) {

		Select te = new Select(web_driver.findElement(By.name((or_
				.getProperty(objectName)))));
		te.selectByValue(text);

	}

	public void selectByCSS_ByValue(String text, String objectName) {

		Select te = new Select(web_driver.findElement(By.cssSelector((or_
				.getProperty(objectName)))));
		te.selectByValue(text);

	}

	public void selectByxpath_ByValue(String text, String objectName) {

		Select te = new Select(web_driver.findElement(By.xpath((or_
				.getProperty(objectName)))));
		te.selectByValue(text);

	}

	// GetText

	public String getTextdisplayedBy_Id(String objectName) {
		return web_driver.findElement(By.id((or_.getProperty(objectName))))
				.getText();

	}

	public String getTextdisplayedBy_CSS(String objectName) {
		return web_driver.findElement(
				By.cssSelector((or_.getProperty(objectName)))).getText();

	}

	public String getTextdisplayedBy_Xpath(String objectName) {
		return web_driver.findElement(By.xpath((or_.getProperty(objectName))))
				.getText();

	}

	public String getTextdisplayedBy_class(String objectName) {
		return web_driver.findElement(
				By.className((or_.getProperty(objectName)))).getText();

	}

	// text By attribute

	public String getTextdBy_IdAttribute(String objectName) {
		return web_driver.findElement(By.id((or_.getProperty(objectName))))
				.getAttribute("name");

	}

	public String getTextdisplayedBy_Attributevalue(String objectName) {
		return web_driver.findElement(By.id((or_.getProperty(objectName))))
				.getAttribute("value");

	}

	public String verifyElementdisplayedBy_Attributeclassname(String objectName) {
		return web_driver.findElement(
				By.className((or_.getProperty(objectName)))).getAttribute(
				"checked");

	}

	public String getTextdByXpathAttribute_(String objectName, String attribute) {
		return web_driver.findElement(By.xpath((or_.getProperty(objectName))))
				.getAttribute((or_.getProperty(attribute)));

	}

	// radio button selected
	public boolean isRadiobuttonSelectedByXpath_(String objectName) {
		return web_driver.findElement(By.xpath(or_.getProperty(objectName)))
				.isSelected();
	}

	public boolean isRadiobuttonSelectedBy_Id(String objectName) {
		return web_driver.findElement(By.id(or_.getProperty(objectName)))
				.isSelected();
	}

	public boolean isRadiobuttonSelectedBy_class(String objectName) {
		return web_driver.findElement(
				By.className(or_.getProperty(objectName))).isSelected();
	}

	public boolean isRadiobuttonSelectedBy_Name(String objectName) {
		return web_driver.findElement(By.name(or_.getProperty(objectName)))
				.isSelected();
	}

	public boolean isRadiobuttonSelectedBy_css(String objectName) {
		return web_driver.findElement(
				By.cssSelector(or_.getProperty(objectName))).isSelected();
	}

	// javascript

	public void executeJavascript(String javascriptExpression) {
		JavascriptExecutor js = (JavascriptExecutor) web_driver;
		js.executeScript(javascriptExpression);
	}

	public Object getObjectFromJavascript(String javascriptExpression) {

		try {
			Object o = js_.executeScript("return " + javascriptExpression);

			log.info("Javascript: " + javascriptExpression + " gives "
					+ (o == null ? null : o.toString()));
			return o;
		} catch (Exception e) {
			throw new RuntimeException("Unable to execute javascript: "
					+ javascriptExpression, e);
		}
	}

	public String getStringFromJavascript(String javascriptExpression) {
		return (String) getObjectFromJavascript(javascriptExpression);
	}

	public boolean getBooleanFromJavascript(String javascriptExpression) {
		return (Boolean) getObjectFromJavascript(javascriptExpression);
	}

	public long getLongFromJavascript(String javascriptExpression) {
		Object o = getObjectFromJavascript(javascriptExpression);
		if (o instanceof Long)
			return (Long) o;
		return Long.parseLong((String) o);
	}

	public double getDoubleFromJavascript(String javascriptExpression) {
		return (Double) getObjectFromJavascript(javascriptExpression);
	}

	public void assertNoJavascriptErrorsOccurred() {
		long l = getLongFromJavascript("javascriptErrors.length");
		if (l == 0)
			return;
		String s = getStringFromJavascript("javascriptErrors[0]");

		fail(l + " javascript errors.  First error is " + s);
	}

	// upload file

	public void uploadfileBy_Name(String filePath) {
		// filePath = "path\\to\\file\for\\upload";
		JavascriptExecutor jsx = (JavascriptExecutor) web_driver;
		jsx.executeScript("document.getElementByname('data').value='"
				+ or_.getProperty(filePath) + "';");
		if (true) {
			throw new IllegalArgumentException("Error in uploadfileName method");
		}
	}
	public void uploadfileBy_xpath(String filePath) {
		// filePath = "path\\to\\file\for\\upload";
		JavascriptExecutor jsx = (JavascriptExecutor) web_driver;
		jsx.executeScript("document.getElementByxpath('data').value='"
				+ or_.getProperty(filePath) + "';");
		if (true) {
			throw new IllegalArgumentException("Error in uploadfileName method");
		}
	}
	// is elements present

	public boolean isElementsPresentBy_Xpath(String objectName) {

		int count = web_driver.findElements(
				By.xpath(or_.getProperty(objectName))).size();
		if (count == 0)
			return false;
		else
			return true;
	}

	public boolean isElementsPresentBy_Css(String objectName) {

		int count = web_driver.findElements(
				By.cssSelector(or_.getProperty(objectName))).size();
		if (count == 0)
			return false;
		else
			return true;
	}

	public boolean isElementSPresentBy_Class(String objectName) {

		int count = web_driver.findElements(
				By.className(or_.getProperty(objectName))).size();
		if (count == 0)
			return false;
		else
			return true;
	}

	public boolean isElementsPresentBy_id(String objectName) {

		int count = web_driver
				.findElements(By.id(or_.getProperty(objectName))).size();
		if (count == 0)
			return false;
		else
			return true;
	}

	public boolean isElementsPresentBy_Name(String objectName) {

		int count = web_driver.findElements(
				By.name(or_.getProperty(objectName))).size();
		if (count == 0)
			return false;
		else
			return true;
	}

	public boolean isElementsPresentBy_Link(String objectName) {

		int count = web_driver.findElements(By.linkText((objectName))).size();
		if (count == 0)
			return false;
		else
			return true;
	}

	// displayed
	public boolean isElementDisplayedBy_linK(String text) {

		return web_driver.findElement(By.linkText(text)).isDisplayed();

	}

	public boolean isElementDisplayedByid_(String objectName) {

		return web_driver.findElement(By.id(or_.getProperty(objectName)))
				.isDisplayed();

	}

	public boolean isElementDisplayedBy_class(String objectName) {

		return web_driver.findElement(
				By.className(or_.getProperty(objectName))).isDisplayed();

	}

	public boolean isElementDisplayedBy_css(String objectName) {

		return web_driver.findElement(
				By.cssSelector(or_.getProperty(objectName))).isDisplayed();

	}

	public boolean isElementDisplayedByXpath_(String objectName) {

		return web_driver.findElement(By.xpath(or_.getProperty(objectName)))
				.isDisplayed();

	}

	public boolean isElementDisplayedBy_Name(String objectName) {

		return web_driver.findElement(By.name(or_.getProperty(objectName)))
				.isDisplayed();

	}

	// enabled

	public boolean isElementEnabledByid_(String objectName) {

		return web_driver.findElement(By.id(or_.getProperty(objectName)))
				.isEnabled();

	}

	public boolean isElementEnabledBy_class(String objectName) {

		return web_driver.findElement(
				By.className(or_.getProperty(objectName))).isEnabled();

	}

	public boolean isElementEnabledBy_css(String objectName) {

		return web_driver.findElement(
				By.cssSelector(or_.getProperty(objectName))).isEnabled();

	}

	public boolean isElementEnabledBy_Xpath(String objectName) {

		return web_driver.findElement(By.xpath(or_.getProperty(objectName)))
				.isEnabled();

	}

	// return page title

	public String getPageTitle_() {

		return web_driver.getTitle();

	}

	// switch window

	public void swicthwindowBy_Id(String franename, String objectName) {
		web_driver.findElement(By.id(or_.getProperty(objectName)));
		web_driver.switchTo().frame(franename);

	}

	// Refresh

	public void refreshPage() {
		web_driver.navigate().refresh();
	}

	// Navigate page back
	public void navigatePageback() {
		web_driver.navigate().back();

	}

	// Navigate page forward
	public void navigatePageForward() {
		web_driver.navigate().forward();

	}

	// is element visible
	public boolean iselementvisibleByid_(String objectName) {
		WebElement element = web_driver.findElement(By.id(or_
				.getProperty(objectName)));
		if (element instanceof WebElement) {

			return true;
		} else {

		}
		return false;

	}

	public boolean iselementvisibleBy_Xpath(String objectName) {
		WebElement element = web_driver.findElement(By.xpath(or_
				.getProperty(objectName)));
		if (element instanceof WebElement) {

			return true;
		} else {

		}
		return false;

	}

	public boolean iselementvisibleBy_css(String objectName) {
		WebElement element = web_driver.findElement(By.cssSelector(or_
				.getProperty(objectName)));
		if (element instanceof WebElement) {

			return true;
		} else {

		}
		return false;

	}

	public boolean iselementvisibleBy_Link(String objectName) {
		WebElement element = web_driver.findElement(By.linkText(objectName));
		if (element instanceof WebElement) {
			return true;
		} else {

			return false;
		}
	}

	public boolean iselementvisibleBy_Name(String objectName) {
		WebElement element = web_driver.findElement(By.xpath(or_
				.getProperty(objectName)));
		if (element instanceof WebElement) {

			return true;
		} else {

		}
		return false;

	}

	// ScreenShot
	public void takeScreenShot(String fileName) throws IOException {

		WebDriver augmentedDriver = new Augmenter().augment(web_driver);
		File screenshot = ((TakesScreenshot) augmentedDriver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("screenshots" + File.separator
				+ System.currentTimeMillis() + "_" + fileName + ".png"));

	}

	// close
	public void close() {
		web_driver.close();
		web_driver.quit();

	}

	// actions

	public void dragElement(WebElement webElement, int xOffSet, int yOffSet) {

		Actions builder = new Actions(web_driver);
		Action dragAndRelease = builder.clickAndHold(webElement)
				.moveByOffset(xOffSet, yOffSet).release().build();
		dragAndRelease.perform();

	}

	// doubleclick
	public void zoomMapUsing_DoubleClick(WebElement e) {
		Actions builder = new Actions(web_driver);
		builder.doubleClick(e).build().perform();

	}

	public void zoomMapsingleClick(WebElement e) {
		Actions builder = new Actions(web_driver);
		builder.click(e).build().perform();

	}

	public void delete_Cookies() {
		web_driver.manage().deleteAllCookies();
	}

	public void maximizeBrowsersize() {

		web_driver.manage().window().maximize();
	}

}