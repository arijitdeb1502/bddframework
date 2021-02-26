package pageobjectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	By inputTextEmail=By.id("email");
	By inputTextPassword=By.xpath("//input[@name='password']");
	By formButtonSubmit=By.xpath("//input[@name='submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getinputEmailText() {
		return driver.findElement(inputTextEmail);
	}
	
	public WebElement getinputPasswordText() {
		return driver.findElement(inputTextPassword);
	}
	
	public WebElement getSubmitButton() {
		return driver.findElement(formButtonSubmit);
	}
	

}
