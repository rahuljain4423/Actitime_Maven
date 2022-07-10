package com.actitime.testscripts;

import com.actitime.generics.BaseClass;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generics.ListenerImplementation.class)

public class CoustomerModule extends BaseClass{

	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException {
	   String CustomerName = f.getExcelData("CreateCustomer", 2, 2);
	   String CustomerDescription = f.getExcelData("CreateCustomer", 2, 3);
	  
		Reporter.log("CreateCustomer",true);
		EnterTimeTrackPage e= new EnterTimeTrackPage(driver);
		e.setTaskTab();
		TaskListPage t =new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustOptions().click();
		t.getEnterCustNameTbx().sendKeys(CustomerName);
		t.getEnterCustDescTbx().sendKeys(CustomerDescription);
		t.getSelectCustDD().click();
		t.getOurCompany().click();
		t.getCreateCustBtn().click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustomer(), CustomerName));
		String actualCustText = t.getActualCustomer().getText();
	    Assert.assertEquals(actualCustText, CustomerName);
 }
}
