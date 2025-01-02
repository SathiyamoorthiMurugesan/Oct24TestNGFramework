package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Generic;

public class CommonPageOHRM {

	Generic generic = new Generic();

	public CommonPageOHRM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h6[text() = 'Dashboard']")
	WebElement text_DashboardPageHeader;
	
	@FindBy(tagName = "h6")
	WebElement text_PageHeader;
	
	@FindBy(xpath = "//div[@class='oxd-sidepanel-body']//span")
	List<WebElement> link_Page;
	
	public void validateThePageHeader(String pageHeader) throws Exception {
		try {
//		Assert.assertEquals(text_DashboardPageHeader.getText(), pageHeader);
		Assert.assertEquals(text_PageHeader.getText(), pageHeader);
		Generic.extentLogger.pass("Page header validation is successfull",
				MediaEntityBuilder.createScreenCaptureFromPath(Generic.captureScreenshot()).build());

	} catch (Exception e) {
		Generic.extentLogger.fail("Failed tot validate the page header",
				MediaEntityBuilder.createScreenCaptureFromPath(Generic.captureScreenshot()).build());

		Assert.fail("Failed tot validate the page header "+ e.getMessage());
	}
	}
	
	public void goToAPage(String pageName) throws Exception {
		try {
		for(WebElement each: link_Page) {
//			System.out.println(each.getText());
			if(each.getText().equalsIgnoreCase(pageName)) {
//				each.click();
				generic.clickAnElement(each);
				break;
			}
			else {
				Generic.extentLogger.fail("Failed to move to page"+pageName,
						MediaEntityBuilder.createScreenCaptureFromPath(Generic.captureScreenshot()).build());

				Assert.fail("Failed to move to page"+pageName +"\n");
			}
		
		}
		generic.waitForElementToBeVisible(text_PageHeader, 5);
		Generic.extentLogger.pass("Moved to the page: "+pageName,
				MediaEntityBuilder.createScreenCaptureFromPath(Generic.captureScreenshot()).build());

	} catch (Exception e) {
		Generic.extentLogger.fail("Failed to move to page"+pageName,
				MediaEntityBuilder.createScreenCaptureFromPath(Generic.captureScreenshot()).build());

		Assert.fail("Failed to move to page"+pageName +"\n"+ e.getMessage());
	}
	}

}
