package Academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	public WebDriver driver;
	Properties prop;
	public WebDriver initializeDriver() throws IOException 
	{
	
		prop=new Properties();
		FileInputStream fis=new FileInputStream("L:\\Eclipse2\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browser_name=prop.getProperty("browser");
		if(browser_name.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browser_name.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Drivers\\geckodriver.exe");
		     driver = new FirefoxDriver();
		}
		else if(browser_name.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Selenium Drivers\\IEDriverServer.exe");
			 driver = new  InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		return driver;
	}

	public void explicitWait(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public String screenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        
        return destinationFile;
	}
	
}
