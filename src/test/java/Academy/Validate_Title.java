package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.Landing_Page;

public class Validate_Title extends Base {
	WebDriver driver;
	Logger log = LogManager.getLogger(Home_Page.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() {

		Landing_Page lp = new Landing_Page(driver);

		Assert.assertEquals(lp.getTitle().getText(), "Featured Courses");

	}

	@Test
	public void gitExample() {
		System.out.println("Just for Git Example1 Purpose");
		System.out.println("Just for Git Example2 Purpose");
		System.out.println("newly add file");

	}

	@AfterTest
	public void shutdown() {
		driver.close();

	}

}
