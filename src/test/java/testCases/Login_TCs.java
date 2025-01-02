package testCases;

import org.testng.annotations.Test;

import base.Generic;
import pages.CommonPageOHRM;
import pages.LoginPageOHRM;

public class Login_TCs extends Generic {

//	@BeforeMethod
//	public void hello() {
//		System.out.println("Hello");
//	}

	@Test
	public void validateHRMLogin() throws Exception {

		Generic.extentLogger = extentReport.createTest("TC01_Validating HRM login");
		CommonPageOHRM commonPage = new CommonPageOHRM(driver);
		LoginPageOHRM loginPage = new LoginPageOHRM(driver);

		loginPage.loginOrangeHrmApplication1("Admin", "admin123");
		commonPage.validateThePageHeader("Dashboard");
		commonPage.goToAPage("PIM");
		commonPage.validateThePageHeader("PIM1");
	}
	
	@Test
	public void validateHRMLogin1() throws Exception {

		Generic.extentLogger = extentReport.createTest("TC01_Validating HRM login");
		CommonPageOHRM commonPage = new CommonPageOHRM(driver);
		LoginPageOHRM loginPage = new LoginPageOHRM(driver);

//		loginPage.loginOrangeHrmApplication1("Admin", "admin123");
//		commonPage.validateThePageHeader("Dashboard");
//		commonPage.goToAPage("PIM");
		commonPage.validateThePageHeader("Dashboard");
	}

}
