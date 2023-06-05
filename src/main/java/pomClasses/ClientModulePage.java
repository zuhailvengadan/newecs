package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientModulePage {
//Declaration
	@FindBy(xpath="//div[@class='page-title']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//h4[text()='Ahmed, Nafousa']")
	private WebElement client1;
	
	//initialization
	
	public ClientModulePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	
	public void clickClient1()
	{
		client1.click();
	}
}
