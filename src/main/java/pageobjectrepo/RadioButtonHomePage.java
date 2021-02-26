package pageobjectrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonHomePage {
	
	public WebDriver driver;
	
	By radioButtonElements=By.cssSelector("input[type='radio']");
	
	public RadioButtonHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public List<WebElement> getAllRadioButtonElements(){
		return driver.findElements(radioButtonElements);
	}

}
