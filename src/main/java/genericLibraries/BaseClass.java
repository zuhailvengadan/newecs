package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomClasses.ClientModulePage;
import pomClasses.ClientPage;
import pomClasses.Client_EmergencyInfoPage;
import pomClasses.Client_PersonelInfoPage;
import pomClasses.Client_SchedulePage;
import pomClasses.HomePage_Admin;
import pomClasses.LoginPage;

public class BaseClass {
	
	protected PropertiesUtility property;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected LoadLogin loadLogin;
	
	protected LoginPage login;
	protected HomePage_Admin homeAdmin;
	protected ClientModulePage clientMod;
	protected ClientPage clientPg;
	protected Client_PersonelInfoPage personelInfo;
	protected Client_EmergencyInfoPage emergencyInfo;
	protected Client_SchedulePage schedule;
	
	
	//@BeforeSuit
	//@BeforeTest
	@BeforeClass
	public void classConfig()
	{
		property=new PropertiesUtility();
		web =new  WebDriverUtility();
		loadLogin=new LoadLogin();
		
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		
		
	}
	@BeforeMethod
	public void methodConfig()
	{
			driver=web.launchBrowser(property.readData("browser"));
			web.maximizeBrowser();
			web.navigateToApp(property.readData("url"));
			web.waitUntilElementFound(Long.parseLong(property.readData("time")));
			
			login=new LoginPage(driver);
			homeAdmin=new HomePage_Admin(driver);
			clientMod=new ClientModulePage(driver);
			clientPg=new ClientPage(driver);
			personelInfo=new Client_PersonelInfoPage(driver);
			emergencyInfo=new Client_EmergencyInfoPage(driver);
			schedule=new Client_SchedulePage(driver);
	}
	
	@AfterMethod
	public void methodTearDown()
	{
		web.quitAllWindows();
	}
//	@AfterClass
//	@AfterTest
//	@AfterSuit
	

}
