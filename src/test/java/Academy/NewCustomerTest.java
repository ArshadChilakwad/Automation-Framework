package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ManagersPage;
import resources.base;

public class NewCustomerTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initiallize() throws IOException {

		driver = initializeDriver();
		 log.info("Driver initialized in newCustomer");
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void newCustomerPage() throws IOException, InterruptedException {

		LoginPage lgp = new LoginPage(driver);
		lgp.getUsername().sendKeys(prop.getProperty("username"));
		 log.info("Entered username");
		lgp.getPassword().sendKeys(prop.getProperty("password"));
		 log.info("Entered Password");
		lgp.getSubmit().click();
		 log.info("Click on submit");
		log.info("logged in sucessfully");

		ManagersPage mp = new ManagersPage(driver);
		mp.addNewCustomer().click();
		 log.info("Clicked on add new customer and navigated");
		mp.getName().sendKeys("mkbgh");
		mp.getCity().sendKeys("lkfbhyr");
		mp.getState().sendKeys("uyjfbt");
		mp.getDob().sendKeys("08211998");
		mp.getAddress().sendKeys("ahjd dsiug wqoi");
		mp.getGender().click();
		mp.getPin().sendKeys("158221");
		mp.getPhoneNo().sendKeys("2587654499");
		mp.getMail().sendKeys("abjklwsic4225ll@gmail.com");
		mp.getPassword().sendKeys("arlirpds12");
		 log.info("All the required details are filled");
		mp.getSubmit().click();
		 log.info("Clicked on Submit button");

		if (isAlertPressent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			 log.info("Unable to add customer, Test failed");
		}

		else {
			Assert.assertTrue(true);
			 log.info("Customer added successfully, Test passed");
		}
	}
	// user defined method to check alert is present or not
	public boolean isAlertPressent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@AfterTest
	public void teardown() {
		driver.close();
		 log.info("Browser is close");
	}
}
