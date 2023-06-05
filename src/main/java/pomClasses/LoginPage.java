 package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Declaration
	@FindBy(xpath="//strong[text()='Sign In ']")
	private WebElement loginHeader;
	
	@FindBy(name="userName")
	private WebElement userNameTB;
	
	@FindBy(id="txtPassword")
	private WebElement passwordTB;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-primary btn-block']")
	private WebElement loginBT;
	
	
	//Initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	
	
	public String getPageHeader()
	{
		return loginHeader.getText();
	}

	public void setUsername(String key)
	{
		userNameTB.sendKeys(key);
	}
//change	
	public WebElement getUsernameTF()
	{
		return userNameTB;
	}
	public void setPassword(String key)
	{
		passwordTB.sendKeys(key);
	}
//change	
	public WebElement getPasswordTF()
	{
		return passwordTB;
	}
	public void clickLoginBT()
	{
		loginBT.click();
	}
//change
	public WebElement getLoginBT()
	{
		return loginBT;
	}
}
