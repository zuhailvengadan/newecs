package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Client_PersonelInfoPage {
	//Declaration
	@FindBy(xpath="//strong[text()='Personal Info']")
	private WebElement pageHeader;
	
	//initialization
	public Client_PersonelInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
}
