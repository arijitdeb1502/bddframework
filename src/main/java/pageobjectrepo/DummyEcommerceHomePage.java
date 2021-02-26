package pageobjectrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DummyEcommerceHomePage {
	
public WebDriver driver;
	
	By itemNameLists=By.xpath("//h4[@class='product-name']");
	By itemCountIncrements=By.xpath("//a[@class='increment']");
	By allAddToCartButtons=By.xpath("//div[@class='product-action']/button");
    By cartIcon=By.xpath("//img[@alt='Cart']");
	By checkOutButton=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoCodeTextBox=By.cssSelector("input.promoCode");
	By promoButton=By.xpath("//button[@class='promoBtn']");
	
	public DummyEcommerceHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public List<WebElement> getAllItemNames(){
		return driver.findElements(itemNameLists);
	}
	
	public List<WebElement> getAllItemIncrements(){
		return driver.findElements(itemCountIncrements);
	}
	
	public List<WebElement> getAllAddToCartButtons(){
		return driver.findElements(allAddToCartButtons);
	}
	

	public WebElement getCheckOutButton() {
		return driver.findElement(checkOutButton);
	}
	
	
	public WebElement getCartIcon() {
		return driver.findElement(cartIcon);
	}
	
	public WebElement getPromoCodeTextBox() {
		return driver.findElement(promoCodeTextBox);
	}

	public WebElement getApplyPromoButton() {
		return driver.findElement(promoButton);
	}
}
