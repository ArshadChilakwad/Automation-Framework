package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManagersPage {

	public WebDriver driver;
	
	public ManagersPage(WebDriver driver) {
		this.driver=driver;
		
	}

	By newCustomer = By.linkText("New Customer");
	By name = By.cssSelector("[name='name']");
	By gender = By.cssSelector("[name='rad1']");
	By dob = By.cssSelector("[name='dob']");
	By address = By.cssSelector("[name='addr']");
	By city =By.cssSelector("[name='city']");
	By state =By.cssSelector("[name='state']");
	By pin =By.cssSelector("[name='pinno']");
	By phoneNo =By.cssSelector("[name='telephoneno']");
	By mail =By.cssSelector("[name='emailid']");
	By submit =By.cssSelector("[value='Submit']");
	By pass = By.name("password");


	
	public WebElement addNewCustomer() {
		return driver.findElement(newCustomer);
	}

	public WebElement getName() {
		return driver.findElement(name);
	}

	public WebElement getGender() {
		return driver.findElement(gender);
	}
	public WebElement getDob() {
		return driver.findElement(dob);
	}
	
	public WebElement getAddress() {
		return driver.findElement(address);
	}

	public WebElement getCity() {
		return driver.findElement(city);
	}

	public WebElement getState() {
		return driver.findElement(state);
	}

	public WebElement getPin() {
		return driver.findElement(pin);
	}

	public WebElement getPhoneNo() {
		return driver.findElement(phoneNo);
	}

	public WebElement getMail() {
		return driver.findElement(mail);
	}

	public WebElement getPassword() {
		return driver.findElement(pass);
	}

	public WebElement getSubmit() {
		return driver.findElement(submit);
	}
}
