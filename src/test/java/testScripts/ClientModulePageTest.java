package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class ClientModulePageTest extends BaseClass{
	
	/**
	 * this is the script to validate client module page
	 */
@Test
public void clientPageValidation()
{
	SoftAssert soft=new SoftAssert();
	login.setUsername(property.readData("username"));
	login.setPassword(property.readData("password"));
	login.clickLoginBT();
	
	homeAdmin.clickClientModule();
	soft.assertEquals(clientMod.getPageHeader(),"Client List");
	
	soft.assertAll();
}
}
