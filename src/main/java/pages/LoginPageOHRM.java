package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Generic;

public class LoginPageOHRM {

	WebDriver driver;
	Generic generic = new Generic();

	public LoginPageOHRM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[contains(@class, 'orangehrm-login-title')]")
	WebElement text_LoginPageHeading;

	@FindBy(xpath = "//input[@name='username']")
	WebElement textBox_UserName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement textBox_Password;

	@FindBy(xpath = "//button [text()=' Login ' ]")
	WebElement button_Login;

	@FindBy(className = "orangehrm-login-forgot")
	WebElement link_ForgotPassword;

	@FindBy(xpath = "//div[@class='orangehrm-login-footer-sm']//a")
	List<WebElement> link_SocialMedia;

	@FindBy(xpath = "//h6[text() = 'Dashboard']")
	WebElement text_DashboardPageHeader;

//	public static void loginDetails(String Username, String Password) {
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Username);
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
//		driver.findElement(By.xpath("//button [text()=' Login ' ]")).click();
//	}

	public void loginOrangeHrmApplication(String userName, String password) {
		textBox_UserName.sendKeys(userName);
		textBox_Password.sendKeys(password);
		button_Login.click();
	}

	public void loginOrangeHrmApplication1(String userName, String password) throws Exception {
		try {
			generic.sendTextToAnElement(textBox_UserName, userName);
			generic.sendTextToAnElement(textBox_Password, password);
			generic.clickAnElement(button_Login);
//		Assert.assertEquals(text_DashboardPageHeader.getText(), "Dashboard");

//			CommonPageOHRM commonPage = new CommonPageOHRM(driver);
//			commonPage.validateThePageHeader("Dashboard");
			
			Generic.captureScreenshot();

			Generic.extentLogger.pass("Logged in OrangeHRM application",
					MediaEntityBuilder.createScreenCaptureFromPath(Generic.captureScreenshot()).build());

		} catch (Exception e) {
			Generic.extentLogger.fail("Failed to login OrangeHRM application",
					MediaEntityBuilder.createScreenCaptureFromPath(Generic.captureScreenshot()).build());

			Assert.fail("Failed to login Orange HRM page" + e.getMessage());
		}
	}

	public void openGivenSocialMediaPageOfOrangeHRM(String socialMediaName) {
//		for(WebElement each: link_SocialMedia) {
//			if(each.getText().equalsIgnoreCase(socialMediaName)) {
//				generic.clickAnElement(each);
//			}
//		}

		switch (socialMediaName) {

		case "LinkedIn":
			generic.clickAnElement(link_SocialMedia.get(0));
			break;

		case "Facebook":
//			link_SocialMedia.get(1).click();
			generic.clickAnElement(link_SocialMedia.get(1));
			break;

		case "Twitter":
			generic.clickAnElement(link_SocialMedia.get(2));
			break;

		case "YouTube":
			generic.clickAnElement(link_SocialMedia.get(3));
			break;
		}

	}

	public void openGivenSocialMediaPageOfOrangeHRM1(String socialMediaName) {
		socialMediaName = socialMediaName.toLowerCase();
		for (WebElement each : link_SocialMedia) {
//		if(each.getDomAttribute("href").contains("linkedin")) {
			if (each.getDomAttribute("href").contains(socialMediaName)) {
//			each.click();
				generic.clickAnElement(each);
			}
		}
	}
}
