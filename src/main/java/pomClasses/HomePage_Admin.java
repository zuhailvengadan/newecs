package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Admin {

	//Declaration
	@FindBy(xpath="//div[text()='E&S Homecare Solution']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//span[text()=' Clients ']")
	private WebElement clientModule;
	
	//Initialization
	
	public HomePage_Admin(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	
	public void clickClientModule()
	{
		clientModule.click();
	}
}
