package pageobjectrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectDropDownPage {
	
	public WebDriver driver;
	
	By staticDropDown=By.id("ctl00_mainContent_DropDownListCurrency");
	
	public SelectDropDownPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getStaticDropDownElement(){
		return driver.findElement(staticDropDown);
	}

}
