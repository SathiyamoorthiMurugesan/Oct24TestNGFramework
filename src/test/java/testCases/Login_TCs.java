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
	public void validateHRMLogin() {
		LoginPageOHRM loginPage = new LoginPageOHRM(driver);
		loginPage.loginOrangeHrmApplication1("Admin", "admin123");
		
		CommonPageOHRM commonPage = new CommonPageOHRM(driver);
		commonPage.goToAPage("PIM");
		
	}

}
