package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class Client_PersonelInfoPageTest extends BaseClass {
/**
 * this script is to validate personel info page
 */
	
	@Test
	public void personelInfoValidation()
	{
		SoftAssert soft=new SoftAssert();
		
		login.setUsername(property.readData("username"));
		login.setPassword(property.readData("password"));
		login.clickLoginBT();
		
		homeAdmin.clickClientModule();
		
		clientMod.clickClient1();
		
		clientPg.clickPersonalInfo();
		
		soft.assertEquals(personelInfo.getPageHeader(), "PERSONAL INFO");
		
		soft.assertAll();
		
		
	}
}
