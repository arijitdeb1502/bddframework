package pageobjectrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarHomePage {
	public WebDriver driver;
	
	By searchDestinationInputBox=By.xpath("//input[@aria-label='Please type your destination']");
	By checkinTab=By.xpath("//div[@data-calendar2-title='Check-in']");
	By checkoutTab=By.xpath("//div[@data-calendar2-title='Check-out']");
	By currentCalMonth=By.xpath("//div[@class='bui-calendar__month']");
	By nextMonthClicker=By.xpath("//div[@data-bui-ref='calendar-next']");
	By currentCalDay=By.cssSelector("td[class='bui-calendar__date']");
	By searchButton=By.cssSelector(".sb-searchbox__button ");
	By displayText=By.cssSelector(".sr_header ");
	
	public CalendarHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSearchDestinationInputBox() {
		return driver.findElement(searchDestinationInputBox);
	}
	
	public WebElement getcheckinTab() {
		return driver.findElement(checkinTab);
	}
	
	public WebElement getcheckoutTab() {
		return driver.findElement(checkoutTab);
	}
	
	public WebElement getcurrentCalMonth() {
		return driver.findElement(currentCalMonth);
	}
	
	public WebElement getNextMonthClicker() {
		return driver.findElement(nextMonthClicker);
	}
	
	public List<WebElement> getCurrentCalDays() {
		return driver.findElements(currentCalDay);
	}
	
	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}
	
	public WebElement getDisplayText() {
		return driver.findElement(displayText);
	}
	
}