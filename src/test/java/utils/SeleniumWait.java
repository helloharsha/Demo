/**
 * 
 */
package utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseFile.BaseFile;


public class SeleniumWait extends BaseFile {

	FluentWait<WebDriver> wait = new WebDriverWait(web_driver, 180).pollingEvery(
			1, TimeUnit.SECONDS);

	public void waitWithTimeOut(int time) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(web_driver, time);
		wait.withTimeout(time, TimeUnit.SECONDS);
	}

	public FluentWait<WebDriver> timeOutWithMessage(String message)
			throws InterruptedException {

		return wait.withMessage(message);

	}

	public void waitforAlertisPresent() throws InterruptedException {

		wait.until(ExpectedConditions.alertIsPresent());
	}

	public Boolean waitforTitletoBePresent(String title)
			throws InterruptedException {

		return wait.until(ExpectedConditions.titleIs(title));

	}

	public boolean waitfortextToBePresentByxpath(String objectName, String text) {

		return wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(or_.getProperty(objectName)), text));
	}

	public boolean waitfortextToBe_PresentByid(String objectName, String text) {

		return wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.id(or_.getProperty(objectName)), text));
	}

	public boolean waitfortextToBePresentByclass(String objectName, String text) {

		return wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.className(or_.getProperty(objectName)), text));
	}

	public boolean waitfortextToBePresentBycss(String objectName, String text) {

		return wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.cssSelector(or_.getProperty(objectName)), text));
	}

	public boolean waitfortextToBePresentByLinkText(String text) {

		return wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.linkText(text), text));
	}

	public WebElement waitforvisibilityOfWebElement(WebElement objectName) {

		return wait.until(ExpectedConditions.visibilityOf(objectName));
	}

	public List<WebElement> waitforListofWebElements(List<WebElement> objectName) {

		return wait.until(ExpectedConditions
				.visibilityOfAllElements((objectName)));

	}

	public List<WebElement> waitforvisibilityOfAllElementsByCss(
			String objectName) {

		return wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.cssSelector(or_
						.getProperty(objectName))));

	}

	public List<WebElement> waitforvisibilityOfAllElementsBYxpath(
			String objectName) {

		return wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath(or_
						.getProperty(objectName))));

	}

	public List<WebElement> waitforvisibilityOfAllElementsBYID(String objectName) {

		return wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.id(or_
						.getProperty(objectName))));

	}

	public List<WebElement> waitforvisibilityOfAllElementsBYClass(
			String objectName) {

		return wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.className(or_
						.getProperty(objectName))));

	}

	public Boolean waitforelementToBeSelected(WebElement objectName) {

		return wait.until(ExpectedConditions.elementToBeSelected(objectName));
	}

	public Boolean waitforelementToBeSelectedByxpath(String objectName) {

		return wait.until(ExpectedConditions.elementToBeSelected(By.xpath(or_
				.getProperty(objectName))));
	}

	public Boolean waitforelementToBeSelectedByclass(String objectName) {

		return wait.until(ExpectedConditions.elementToBeSelected(By
				.className(or_.getProperty(objectName))));
	}

	public Boolean waitforelementToBeSelectedByid(String objectName) {

		return wait.until(ExpectedConditions.elementToBeSelected(By.id(or_
				.getProperty(objectName))));
	}

	public Boolean waitforelementToBeSelectedBycss(String objectName) {

		return wait.until(ExpectedConditions.elementToBeSelected(By
				.cssSelector(or_.getProperty(objectName))));
	}

	public WebDriver waitforframeToBeAvailableAndSwitchToItBycss(
			String objectName) {

		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
				.cssSelector(or_.getProperty(objectName))));
	}

	public WebDriver waitforframeToBeAvailableAndSwitchToItByxpath(
			String objectName) {

		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
				.xpath(or_.getProperty(objectName))));
	}

	public WebDriver waitforframeToBeAvailableAndSwitchToItByid(
			String objectName) {

		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
				.id(or_.getProperty(objectName))));
	}

	public WebDriver waitforframeToBeAvailableAndSwitchToItByclass(
			String objectName) {

		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
				.className(or_.getProperty(objectName))));
	}

	public WebDriver waitforframeToBeAvailableAndSwitchToIt(String objectName) {

		return wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(objectName));

	}

	public Boolean waitforstaleness(WebElement objectName) {

		return wait.until(ExpectedConditions.stalenessOf(objectName));

	}

	public WebElement waitforPresenceOfElementLocatedByXpath_(String objectName) {

		return wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(or_.getProperty(objectName))));

	}

	public WebElement waitforpresenceOfElementLocatedByid_(String objectName) {

		return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(or_
				.getProperty(objectName))));

	}

	public WebElement waitforpresenceOfElementLocatedByclass(String objectName) {

		return wait.until(ExpectedConditions.presenceOfElementLocated(By
				.className(or_.getProperty(objectName))));

	}

	public WebElement waitforpresenceOfElementLocatedBy_Name(String objectName) {

		return wait.until(ExpectedConditions.presenceOfElementLocated(By
				.name(or_.getProperty(objectName))));

	}

	public WebElement waitforpresenceOfElementLocatedByCss_(String objectName) {

		return wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector(or_.getProperty(objectName))));

	}

	public WebElement waitforpresenceOfElementLocatedByLink(String objectName) {

		return wait.until(ExpectedConditions.presenceOfElementLocated(By
				.linkText((objectName))));

	}

	// invisibility
	public Boolean waitforInvsibilityByID_(String objectName) {

		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By
				.id((objectName))));

	}

	// wait
	public void waitforPagetoLoad(int time) {

		web_driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);

	}

	public void wait(int time) {

		web_driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	public void pause(double secondsToWait) {

		try {
			Thread.sleep((int) (secondsToWait * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// wait for element to be clickable

	public void waitforElementtobeClickableByxpath(int time, String objectName) {

		WebDriverWait wait = new WebDriverWait(web_driver, time);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(or_.getProperty(objectName))));
	}

	public void waitforElementtobeClickablebyClass(int time, String objectName) {
		WebDriverWait wait = new WebDriverWait(web_driver, time);

		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.className(or_
						.getProperty(objectName))));
	}

	public void waitforElementtobeClickablebyCss(int time, String objectName) {

		WebDriverWait wait = new WebDriverWait(web_driver, time);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector(or_
						.getProperty(objectName))));
	}

	public void waitforElementtobeClickablebyID(int time, String objectName) {

		WebDriverWait wait = new WebDriverWait(web_driver, time);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.id(or_.getProperty(objectName))));
	}

}
