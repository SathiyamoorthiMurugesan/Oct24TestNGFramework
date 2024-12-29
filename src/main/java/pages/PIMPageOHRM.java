package pages;


public class PIMPageOHRM {
	
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

/*	public static void pimPageDataEditWithNameFromTable(String firstName) {
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
