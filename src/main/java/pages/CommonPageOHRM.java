package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	public void validateThePageHeader(String pageHeader) {
//		Assert.assertEquals(text_DashboardPageHeader.getText(), pageHeader);
		Assert.assertEquals(text_PageHeader.getText(), pageHeader);
	}
	
	public void goToAPage(String pageName) {
		for(WebElement each: link_Page) {
			if(each.getText().equalsIgnoreCase(pageName)) {
//				each.click();
				generic.clickAnElement(each);
			}
		}
	}

}
