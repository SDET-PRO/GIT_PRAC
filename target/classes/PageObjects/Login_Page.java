package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
	
	public WebDriver driver;
	
	public Login_Page(WebDriver driver)
	{
	   this.driver=driver;		
	}
	
    private By email_Id=By.xpath("//input[@type='email']");
    private By password=By.xpath("//input[@type='password']");
    private By submit=By.xpath("//input[@type='submit']");

    public WebElement getEmail()
    {
    	return driver.findElement(email_Id);
    }
    
    public WebElement getPassword()
    {
    	return driver.findElement(password);
    }
    
    public WebElement getSubmit()
    {
    	return driver.findElement(submit);
    }
    
 
}
