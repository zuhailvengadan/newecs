package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	private WebDriver driver;
	public WebDriver launchBrowser(String browser)
	{
		switch(browser)
		{
		case "chrome":WebDriverManager.chromedriver().setup();
					  driver =new ChromeDriver();
		break;
		case "firefox": WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
		break;
		case "edge": WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
		default: System.out.println("Invalid Browser Info");
		}
		return driver;
	}
	
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	public void navigateToApp(String url)
	{
		driver.get(url);
	}
	/**
	 * it is used to wait until element or list of elements is found
	 * @param time
	 */
	public void waitUntilElementFound(long time)
	{
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	
	public WebElement explicitWait(WebElement element,long time)
	{
		WebDriverWait wait= new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public boolean explicitWait(long time,String title)
	{
		WebDriverWait wait= new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.titleContains(title));
	}
	public WebElement explicitWait(long time,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void mouseOver(WebElement element)
	{
		Actions actions=new  Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void doubleClickOnElement(WebElement element)
	{
		Actions actions=new  Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void rightClick(WebElement element)
	{
		Actions actions=new  Actions(driver);
		actions.contextClick(element).perform();
	}
	public void dragAndDropElement(WebElement element,WebElement dest)
	{
		Actions actions=new  Actions(driver);
		actions.dragAndDrop(element, dest).perform();
	}
	
	/**
	 * switch to frame methods using different parameters(method overloading)
	 * @param index
	 */
	public void switchToFrame (int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame (String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	public void switchToFrame (WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	public void switchBackFromFrame()
	{
		driver.switchTo().defaultContent();
	}
	/***
	 * This method is used to take screenshot of web page
	 */
	public void takeScreenshot()
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/screenshot.png");
		try {
			FileUtils.copyFile(src, dest);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * This method is used to scroll to an element
	 * 
	 */
	public void scrollToElement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	
	/**
	 * This method used to select an element from dropdown
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void dropdown(WebElement element,String value)
	{
		Select s=new Select(element);	
		s.selectByValue(value);
	}
	public void dropdown(String text,WebElement element)
	{
		Select s=new Select(element);
		s.deselectByVisibleText(text);
	}
/**
 * 	handle alert popup
 */
public void handleAlert(String status)
{
	Alert al=driver.switchTo().alert();
	if(status.equalsIgnoreCase("ok"))
	{
	al.accept();
	}
	else
	{
		al.dismiss();
	}
}
/**
 *to switch to parent window
 */
public void switchToParentWindow()
{
	String parentID=driver.getWindowHandle();
	driver.switchTo().window(parentID);
}
/**
 * switch to child window
 */
public void handleChildBrowser()
{
	Set<String> set=driver.getWindowHandles();
	for(String id: set)
	{
		driver.switchTo().window(id);
	}
}

/**
 * to close the current tab
 */
public void closeCurrentTab()
{
	driver.close();
}
/**
 * to close all the tabs or windows
 */
public void quitAllWindows()
{
	driver.quit();
}

}
