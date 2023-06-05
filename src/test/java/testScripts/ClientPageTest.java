package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class ClientPageTest extends BaseClass{
/**
 * this script is to validate one of the client page in client module 
 */
	
	@Test
	public void clientPageValidation()
	{
		SoftAssert soft=new SoftAssert();
		login.setUsername(property.readData("username"));
		login.setPassword(property.readData("password"));
		login.clickLoginBT();
		
		homeAdmin.clickClientModule();
		clientMod.clickClient1();
		
		soft.assertEquals(clientPg.getPageHeader(), true);
		
		soft.assertAll();
	}
}
