package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Generic;

public class PIMPageOHRM {
	
	WebDriver driver;
	Generic generic = new Generic();

	public PIMPageOHRM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text() = 'PIM']")
	WebElement pimPageroute;
	
	@FindBy(xpath = "//label[text()='Employee Name']//parent::div//following-sibling::div//input")
	WebElement textbox_EmployeeName;	
	
	@FindBy(xpath = "//label[text()='Employee Id']//parent::div//following-sibling::div//input")
	WebElement textbox_EmployeeId;	
	
	@FindBy(xpath = "//label[text()='Supervisor Name']//parent::div//following-sibling::div//input")
	WebElement textbox_SupervisorName;
	
	@FindBy(xpath = "//button [@type = 'reset']")
	WebElement button_Reset;
	
	@FindBy(xpath = "//button [@type = 'submit")
	WebElement button_Search;
	
	//span[text() = 'PIM']

	//label[text()='Employee Name']//parent::div//following-sibling::div//input
	//label[text()='Employee Id']//parent::div//following-sibling::div//input
	//label[text()='Supervisor Name']//parent::div//following-sibling::div//input
	
	//label[text()='Employment Status']//following::div - to click on dropdown
	//div[@role='listbox']//span [ text() = 'Full-Time Permanent'] - to select the dropdown value
	
	//label[text()='Include']//following::div - to click on dropdown
	//div[@role='listbox']//span[text()='Past Employees Only'] - to select the dropdown value
	
//	Job Title dropdown
	//label[text() = 'Job Title']//following::div - to click on dropdown
	//div[@role='listbox']//span[text()='Account Assistant'] - to select the dropdown value
	
//	Sub unit dropdown
	//label[text() = 'Sub Unit']//following::div - to click on dropdown
	//div[@role='listbox']//span [ text() = 'OrangeHRM'] - to select the dropdown value
	
//	Reset and Search button
//	driver.findElement(By.xpath("//button [@type = 'reset']")).click();
//	driver.findElement(By.xpath("//button [@type = 'submit']")).click();

/*	public static void pIMtab() {
		driver.findElement(By.xpath("//span[text() = 'PIM']")).click();
	}
	
	public static void pimPageEmployeeName(String empname) {
		driver.findElement(By.xpath("//label[text()='Employee Name']//parent::div//following-sibling::div//input[@placeholder='Type for hints...']")).sendKeys(empname);
	}
	
	public static void pimPageEmployeeId(String empId) {
		driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div//following-sibling::div//input")).sendKeys(empId);
	}
	
	public static void pimPageEmploymentStatus(String empStatus) {
		driver.findElement(By.xpath("//label[text() = 'Employment Status']//following::div")).click();
		driver.findElement(By.xpath("//div[@role='listbox']//span [ text() = '"+empStatus+"']")).click();
	}
	public static void pimPageInclude(String includeType) {
		driver.findElement(By.xpath("//label[text() = 'Include']//following::div")).click();
		driver.findElement(By.xpath("//div[@role='listbox']//span[text()='"+includeType+"']")).click();
	}
	
	public static void pimPageSupervisorName(String supname) {
		driver.findElement(By.xpath("//label[text()='Supervisor Name']//parent::div//following-sibling::div//input[@placeholder='Type for hints...']")).sendKeys(supname);
	}
	
	public static void pimPageJobTitle(String jobtitle) {
		driver.findElement(By.xpath("//label[text()='Job Title']//following::div")).click();
		driver.findElement(By.xpath("//div[@role='listbox']//span[text()='"+jobtitle+"']")).click();
	}
	public static void pimPageSubUnit(String subunit) {
		driver.findElement(By.xpath("//label[text()='Sub Unit']//following::div")).click();
		driver.findElement(By.xpath("//div[@role='listbox']//span[text()='"+subunit+"']")).click();
	}
	
	public static void pimPageSearchButton(String button) {
		switch(button){
		case "Search":
			driver.findElement(By.xpath("//button [@type = 'submit']")).click();
			break;
		case "Reset":
			driver.findElement(By.xpath("//button [@type = 'reset']")).click();
			break;
		}
	}
	
	public static void pimPageDataEditWithNameFromTable(String firstName) {
		driver.findElement(By.xpath("//div[contains(text(),'"+firstName+"')]//parent::div//following-sibling::div//i[@class='oxd-icon bi-pencil-fill']")).click();
	}
	
	public static void pimPageDataDeleteWithNameFromTable(String firstName,String confirm) throws InterruptedException {
		driver.findElement(By.xpath("//div[contains(text(),'"+firstName+"')]//parent::div//following-sibling::div//i[@class='oxd-icon bi-trash']")).click();
		Thread.sleep(2000);
		switch (confirm) {
		case "Yes":
			driver.findElement(By.xpath("//button[contains (@class, \"label-danger orangehrm-button-margin\")]")).click();
			break;
			
		case "No":
			driver.findElement(By.xpath("//button[contains (@class, \"ghost orangehrm-button-margin\")]")).click();
			break;		
		}
	}
	
	public static void pimPageNaviConfigurationMenu(String configDpdvalue) {
		driver.findElement(By.xpath("//span [contains(text(),'Configuration')]")).click();
		driver.findElement(By.xpath("//a[contains(text() , '"+configDpdvalue+" ')]")).click();
	}
	
	public static void pimPageNavigMenu(String NavigMenuName) {
		driver.findElement(By.xpath("//a [contains(text (),'"+NavigMenuName+"')]")).click();
	}
	
	public static void pimAddEmployeePage(String fstName,String lstName) {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fstName);
		driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lstName);
		driver.findElement(By.xpath("//button [@type = 'submit']")).click();
	}
	*/
}
