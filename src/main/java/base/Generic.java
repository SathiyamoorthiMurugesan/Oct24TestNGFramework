package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Generic {

	public static WebDriver driver;
	Select select1 = null;
	public static ExtentReports extentReport;
	public static ExtentTest extentLogger;
	public static ExtentSparkReporter sparkReporter;
	static String reportPath;
	
	Utilities util = new Utilities();

//	@BeforeMethod
	public WebDriver launchABrowser(String browserName) {

		WebDriver driver;

		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver_131.exe");
			driver = new ChromeDriver();
			break;

		case "Edge":
			System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver_131.exe");
			driver = new EdgeDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver_131.exe");
			driver = new ChromeDriver();
		}

		return driver;

	}
	
	@BeforeMethod
//	@BeforeClass
	public void launchABrowser() throws Exception {

		String browserName = util.readAProperty("browser");

		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver_131.exe");
			driver = new ChromeDriver();
			break;

		case "Edge":
			System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver_131.exe");
			driver = new EdgeDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver_131.exe");
			driver = new ChromeDriver();
		}
		
		maximizeTheWindow();
		openAnApplication();
		implicitWait(5);

	}

	public void openAnApplication(String ApplicationUrl) {
		driver.get(ApplicationUrl);
	}

	public void openAnApplication() throws Exception {
		Utilities utility = new Utilities();
		driver.get(utility.readAProperty("url"));
	}

	public void implicitWait(long secondsToWait) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secondsToWait));
	}

	public void maximizeTheWindow() {
		driver.manage().window().maximize();
	}

	public void minimizeTheWindow() {
		driver.manage().window().minimize();
	}

	public void fullScreenTheWindow() {
		driver.manage().window().fullscreen();
	}

//	WebDriver methods 

	public String getTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}

	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	public void closeTheCurrentWindow() {
		driver.close();
	}

	public void closeTheBrowser() {
		driver.quit();
	}

	public WebElement findTheElement(String elementLocator, String value) {

		switch (elementLocator) {
		case "id":
			return driver.findElement(By.id(value));

		case "xpath":
			return driver.findElement(By.xpath(value));

		case "linkText":
			return driver.findElement(By.linkText(value));
		}
		return null;
	}

	public List<WebElement> findTheElements(String elementLocator, String value) {

		switch (elementLocator) {
		case "id":
			return driver.findElements(By.id(value));

		case "xpath":
			return driver.findElements(By.xpath(value));

		case "linkText":
			return driver.findElements(By.linkText(value));
		}
		return null;
	}
	
//	Report and Screenshot methods 
	
	@BeforeSuite
	public void extentReport() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");

		String sDate = sdf.format(date);

		reportPath = System.getProperty("user.dir") + File.separator + "Reports" + File.separator + "TCExecutedOn"
				+ sDate + File.separator;

		sparkReporter = new ExtentSparkReporter(reportPath + "extent.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
	}

	@AfterSuite
	public void flushReport() {
		extentReport.flush();
	}

//	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}

	public static String captureScreenshot() throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File src = scrShot.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");

		String sDate = sdf.format(date);

		String screenshotdir = reportPath + "ScreenShots" + File.separator + "imageName" + sDate + ".png";

		File screenshotName = new File(screenshotdir);

		FileUtils.copyFile(src, screenshotName);

		return screenshotdir;
	}

//	WebElement methods 

	public void sendTextToAnElement(WebElement ele, String text) {
		ele.sendKeys(text);
	}

	public void clickAnElement(WebElement ele) {
		ele.click();
	}

	public boolean elementIsSelected(WebElement ele) {
		return ele.isSelected();
	}

	public String getTextFromAnElement(WebElement ele) {
		return ele.getText();
	}

//	Alert methods 

	public void acceptAnAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAnAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getTextFromAnAlert() {
		return driver.switchTo().alert().getText();
	}

	public void sendTextToAnAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

//	Actions class methods 

	public void scrollToAnElementUsingActions(WebElement element) {
		Actions actions = new Actions(driver);
		actions.scrollToElement(element).build().perform();
	}

	public void rightClickAnElement(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.contextClick(ele).build().perform();
	}

	public void moveMouseOnAnElement(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).perform();
		;
	}

	public void rightClickOnMouse() {
		Actions actions = new Actions(driver);
		actions.contextClick().build().perform();
	}

	public void clickAnElementUsingActions(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).build().perform();
	}

	public void pressAKeyUsingActionsClass(String keyName) {
		Actions actions = new Actions(driver);
		switch (keyName) {
		case "a":
//			actions.keyDown(Keys.A).keyUp(Keys.a);
		}
	}

	public void typeInCaptialUsingActions(String text) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).sendKeys(text).keyUp(Keys.SHIFT).build().perform();
	}

// Dropdown methods 

	public Select yourDropDown(WebElement ele) {
		select1 = new Select(ele);
		return select1;

	}

	public boolean isTheDropDownMultipleSelect1() {
		return select1.isMultiple();
	}

	public void selectByVisibleText1(String text) {
		select1.selectByVisibleText(text);
	}

// Frames methods 

	public void switchToFrame(int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}

	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}

	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public int getTotalIFrames() {
		return driver.findElements(By.tagName("iframe")).size();
	}

	public int getTotalFrames() {
		return driver.findElements(By.tagName("frame")).size();
	}

// Robot class methods 

	public void uploadAFileUsingSendKeys(By by, String pathOfFileToBeUploaded) {
		driver.findElement(by).sendKeys(pathOfFileToBeUploaded);
	}
	// uploadAFileUsingSendKeys(By.id("fileToUpload"),"D:\\sathiya\\Text123.txt"),

	public void uploadAFileUsingRobotClass(String pathOfFile) throws Exception {
		Robot robo = new Robot();
//		C:\Users\LENOVO\Desktop\Vinothini.txt

		StringSelection stringSelection = new StringSelection(pathOfFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(3000);

		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);

	}

	public void enterAKeyUsingRobotClass(String keyName) throws AWTException {
		Robot robo = new Robot();
		switch (keyName) {
		case "a":
			robo.keyPress(KeyEvent.VK_A);
			robo.keyRelease(KeyEvent.VK_A);
			break;

		}

	}

	public void enterAStringUsingRobotClass(String value) throws AWTException {
		Robot robo = new Robot();
		String[] letters = value.split("");
		for (String eachLetter : letters) {
			switch (eachLetter) {
			case "a":
				robo.keyPress(KeyEvent.VK_A);
				robo.keyRelease(KeyEvent.VK_A);
				break;

			case "b":
				robo.keyPress(KeyEvent.VK_B);
				robo.keyRelease(KeyEvent.VK_B);
				break;

			case "c":
				robo.keyPress(KeyEvent.VK_C);
				robo.keyRelease(KeyEvent.VK_C);
				break;

			case " ":
				robo.keyPress(KeyEvent.VK_SPACE);
				robo.keyRelease(KeyEvent.VK_SPACE);
				break;
			}
		}
	}

	public void enterTwoKeyUsingRobotClass(String keysName) throws AWTException {
		Robot robo = new Robot();
		switch (keysName) {
		case "ControlA":
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_A);
			robo.keyRelease(KeyEvent.VK_A);
			robo.keyRelease(KeyEvent.VK_CONTROL);
			break;

		case "CapsA":
			robo.keyPress(KeyEvent.VK_SHIFT);
			robo.keyPress(KeyEvent.VK_A);
			robo.keyRelease(KeyEvent.VK_A);
			robo.keyRelease(KeyEvent.VK_SHIFT);
			break;

		}
	}
	
//	Java script methods 
	
	public void scrollToBottomOfThePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
	}

	public void scrollToTopOfThePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,0)");
	}
	
	public void scrollToTheGivenElementUsingJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", element); 
	}
	

	public void clickTheGivenElementUsingJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void sendTextToAnElement(WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("arguments[0].value='enter the value here';", ele);
	}
	
	public void scrollToElementUsingActions(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.scrollToElement(ele).build().perform();
	}
	
//	Wait methods 
	
	public void waitForAlertToBePresent(long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForElementToBeClickableById(String idText, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(idText)));
	}

	public void waitForElementToBeClickableByXpath(String xpathText, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathText)));
	}

	public void waitForElementToBeClickableByClass(String classText, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(By.className(classText)));
	}

	public void waitForElementToBeClickableByLocator(String locatorName, String classText, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		switch (locatorName) {
		case "id":
			wait.until(ExpectedConditions.elementToBeClickable(By.id(classText)));
			break;
		case "className":
			wait.until(ExpectedConditions.elementToBeClickable(By.className(classText)));
			break;

		case "name":
			wait.until(ExpectedConditions.elementToBeClickable(By.name(classText)));
			break;

		case "tagName":
			wait.until(ExpectedConditions.elementToBeClickable(By.tagName(classText)));
			break;

		case "css selector":
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(classText)));
			break;

		case "xpath":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(classText)));
			break;

		}
	}
	
	public void waitForElementToBeClickable(WebElement ele, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void waitForElementToBeVisible(WebElement ele, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

}
