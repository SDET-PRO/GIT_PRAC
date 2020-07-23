package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landing_Page {
	
	public WebDriver driver;
	
	public Landing_Page(WebDriver driver)
	{
	   this.driver=driver;		
	}
	
    private By sign_in=By.xpath("//a[@href='http://qaclickacademy.usefedora.com/sign_in']"); 
    private By title=By.xpath("//h2[text()='Featured Courses']");
    
    public Login_Page getLogin()
    {
     driver.findElement(sign_in).click();
     Login_Page lp=new Login_Page(driver);
     return lp;
    }
    public WebElement getTitle()
    {
    	return driver.findElement(title);
    }
 
}
