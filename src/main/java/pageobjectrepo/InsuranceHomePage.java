package pageobjectrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InsuranceHomePage {
	
	public WebDriver driver;
	
	By ByLogoutButton=By.xpath("//input[@value='Log out']");
	By ByLogoImagesrc=By.xpath("//img[@src='/logo.png']");
	By ByHomePageTitle=By.xpath("//div[@id='site-name']/a");
	By ByMenuBarSelenium=By.xpath("//div[@id='navbar-brand-centered']/ul/li[1]/a");
	By ByAllMenuSelenium=By.xpath("//div[@id='navbar-brand-centered']/ul/li[1]/ul/li/a");

	public InsuranceHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogoutButton() {
		return driver.findElement(ByLogoutButton);
	}
	
	public WebElement getLogoImageSrc() {
		return driver.findElement(ByLogoImagesrc);
	}
	
	public WebElement getMenuBarSelenium() {
		return driver.findElement(ByMenuBarSelenium);
	}
	
	public WebElement getHomePageTitle() {
		return driver.findElement(ByHomePageTitle);
	}
	
	public List<WebElement> getAllMenusSelenium(){
		return driver.findElements(ByAllMenuSelenium);
	}

}
