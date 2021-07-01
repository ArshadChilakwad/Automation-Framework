package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import resources.base;

public class HomePageTest extends base {
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		 driver=initializeDriver();
		 log.info("Driver is initialized");
		 driver.get(prop.getProperty("url"));
		 log.info("Navigated to Login Page");
	}
	

	@Test(dataProvider= "getData")
	public void basePageNavigation(String username, String password) throws IOException {
		 
		 LoginPage lgp = new LoginPage(driver);
		 lgp.getUsername().sendKeys(username);
		 log.info("Entered Username");
		 lgp.getPassword().sendKeys(password);
		 log.info("Entered Password");
		 lgp.getSubmit().click();
		 log.info("click on submit");
		 
		 
		 if(isAlertPressent()==true) {
			 driver.switchTo().alert().accept();
			// driver.switchTo().defaultContent();
			 Assert.assertTrue(false);
			 log.info("Test failed");
		 }
		 
		 else {
			 Assert.assertTrue(true);
			 lgp.getLogout().click();
			 driver.switchTo().alert().accept();
			 log.info("Test success, Logged in successfully");
		 }
			 
		 
	}
	
	//user defined method to check alert is present or not
	public boolean isAlertPressent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		 catch (NoAlertPresentException e) {
			 return false;
		 }
	}

	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "mngr26593";
		data[0][1] = "1!";

		data[1][0] = "mngr26593";
		data[1][1] = "1!";
		
		data[2][0] = "mngr1592";
		data[2][1]= "1256";
		
		return data;

	}
	
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
}
