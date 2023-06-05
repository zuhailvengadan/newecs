package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class Client_SchedulePage extends BaseClass {
/**
 * this script is to validate personel info page
 */
	
	@Test
	public void schedulePageValidation()
	{
		SoftAssert soft=new SoftAssert();
		
		login.setUsername(property.readData("username"));
		login.setPassword(property.readData("password"));
		login.clickLoginBT();
		
		homeAdmin.clickClientModule();
		
		clientMod.clickClient1();
		
		clientPg.clickSchedule();
		
		soft.assertEquals(schedule.getPageHeader(), "Billing Authorizations");
		
		soft.assertAll();
		
		
	}
}
