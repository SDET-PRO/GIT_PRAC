package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Dashboard_Page;
import PageObjects.Landing_Page;
import PageObjects.Login_Page;

public class Home_Page extends Base {
	
 WebDriver driver;	
 Logger log=LogManager.getLogger(Home_Page.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver Initiated");
		driver.get(prop.getProperty("url"));
		log.debug("Opening Url in the browser");
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password) throws InterruptedException 
	{
		log.info("Landed in the landing page");
		Landing_Page lp= new Landing_Page(driver);
		log.debug("Clicked on login button");
		log.info("Landed in the login page");
		Login_Page login= lp.getLogin();
		login.getEmail().sendKeys(username);
		log.debug("Username entered");
		login.getPassword().sendKeys(password);
		log.debug("Password entered");

		login.getSubmit().click();	
		log.debug("Clicked on submit button");
		log.info("Landed on dashboard page");
		Dashboard_Page dp = new Dashboard_Page(driver);
        dp.getLoginAccount().click();
		log.debug("Clicked on Account button");

        explicitWait(dp.getPath("sign_Out"));
        dp.getSignout().click();
		log.debug("Clicked on LogOut button");

	}
	
	@DataProvider
	public Object getData()
	{
		Object[][] data= new Object[2][2];
		data[0][0]="soumyastechnology@gmail.com";
		data[0][1]="hacker";
		
		data[1][0]="hsja@gmail.com";
		data[1][1]="paaas";
		
		return data;
	}
	
	@AfterTest
	public void shutdown()
	{
		driver.close();
		
	}

}
