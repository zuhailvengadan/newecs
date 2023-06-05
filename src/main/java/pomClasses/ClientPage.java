package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPage {
	//Declaration
	@FindBy(xpath="//h3[contains(text(),'Client:')]")
	private WebElement pageHeader;
	
	@FindBy(xpath="//span[text()='Personal Info']")
	private WebElement personalInfo;
	
	@FindBy(xpath="//span[text()='Emergency Info']")
	private WebElement emergencyInfo;
	
	@FindBy(xpath="//span[text()='Schedule']")
	private WebElement schedule;
	
	
	//Initialization
	
	public ClientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	
	public boolean getPageHeader()
	{
		return pageHeader.isDisplayed();
	}
	
	public void clickPersonalInfo() 
	{
		personalInfo.click();
	}
	
	public void clickEmergencyInfo()
	{
		emergencyInfo.click();
	}
	
	public void clickSchedule()
	{
		schedule.click();
	}

}
