package genericLibraries;

import org.openqa.selenium.WebElement;

public class LoadLogin {
	
	public void loginAdmin(WebElement username,WebElement password,WebElement loginBT)
	{
		username.sendKeys("username");
		password.sendKeys("password");
		loginBT.click();
		
	}

}
