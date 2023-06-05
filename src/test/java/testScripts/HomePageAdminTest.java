package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class HomePageAdminTest extends BaseClass {
/**
 * test script to validate admin Home page
 */
	@Test
	public void homePageAdmin()
	{
		SoftAssert soft=new SoftAssert();
		
		login.setUsername(property.readData("username"));
		login.setPassword(property.readData("password"));
		login.clickLoginBT();
		
		soft.assertEquals(homeAdmin.getPageHeader(),"E&S Homecare Solution");
		
		soft.assertAll();
		
	}
}
