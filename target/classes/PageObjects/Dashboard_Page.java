package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard_Page {
	
	public WebDriver driver;
	
	public Dashboard_Page(WebDriver driver)
	{
	   this.driver=driver;		
	}
	
    private By login_Name=By.xpath("//span[@class='navbar-current-user']"); 
    private By sign_Out=By.xpath("//a[contains(text(),'Log Out')]"); 

    public WebElement getLoginAccount()
    {
    	return driver.findElement(login_Name);
    }
 
    public WebElement getSignout()
    {
    	return driver.findElement(sign_Out);

    }
    public By getPath(String pathname)
    {
    
       if(pathname.equals("sign_Out"))
       {
    	   return sign_Out;
       }
       
       if(pathname.equals("login_Name"))
       {
    	   return login_Name;
       }
       return null;
    }
 
}
