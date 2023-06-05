package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class LoginPageTest extends BaseClass {
	/**
	 * test script to validate login page
	 */
	@Test
	public void loginToESHomecare()
	{
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(login.getPageHeader(),"Sign In");
		
		loadLogin.loginAdmin(login.getUsernameTF(), login.getPasswordTF(), login.getLoginBT());
	
	/*	login.setUsername(property.readData("username"));
		login.setPassword(property.readData("password"));
		login.clickLoginBT();*/

		soft.assertAll();
	}
	
	

}
