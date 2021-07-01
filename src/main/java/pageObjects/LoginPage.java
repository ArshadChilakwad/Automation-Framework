package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By username = By.cssSelector("[name='uid']");
	By password = By.cssSelector("[name='password']");
	By login = By.cssSelector("[name='btnLogin']");
	By logout = By.linkText("Log out");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}		

	public WebElement getUsername() {
		return driver.findElement(username);
		
	}

	public WebElement getPassword() {
		return driver.findElement(password);
		
	}

	public WebElement getSubmit() {
		return driver.findElement(login);
	}
	
	public WebElement getLogout() {
		return driver.findElement(logout);	}
}


