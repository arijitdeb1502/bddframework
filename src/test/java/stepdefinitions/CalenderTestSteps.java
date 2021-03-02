package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;

import commontestfunctions.Common;
import commontestfunctions.Log;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjectrepo.CalendarHomePage;

import org.apache.log4j.xml.DOMConfigurator;


public class CalenderTestSteps extends Common{
	
	CalendarHomePage chp;
	
	@Given("^I navigate towards \"([^\"]*)\"$")
	public void i_navigate_towards(String calendarHomePage) throws Throwable {
		
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Starting calendarHomePage Tests");
		driver = initializeDriver();
		Log.info("I navigate towards"+calendarHomePage);
		driver.get(calendarHomePage);
	}

	@When("^I click on the \"([^\"]*)\" text box$")
	public void i_click_on_the_text_box(String arg1) throws Throwable {
	    chp=new CalendarHomePage(driver);
	    Log.info("I click on the "+arg1+"text box");
	    chp.getSearchDestinationInputBox().click();
	}

	@When("^I provide \"([^\"]*)\" as input$")
	public void i_provide_as_input(String destination) throws Throwable {
	    Log.info("I provide "+destination+" as input");
		chp.getSearchDestinationInputBox().sendKeys(destination);
	}

	@When("^I click on the check in tab$")
	public void i_click_on_the_check_in_tab() throws Throwable {
	    Log.info("I click on the check in tab");
		chp.getcheckinTab().click();
	}

	@When("^I select checkin Month as \"([^\"]*)\"$")
	public void i_select_checkin_Month_as(String checkinMonth) throws Throwable {

		Log.info("I select checkin Month as "+checkinMonth);
		while(!chp.getcurrentCalMonth().getText().equals(checkinMonth)) {
		    chp.getNextMonthClicker().click();
		}
		
	}
	
	@When("^I select checkin day as \"([^\"]*)\"$")
	public void i_select_checkin_day_as(String checkInDay) throws Throwable {

		Log.info("I select checkin day as "+checkInDay);
		WebElement checkindayElem=chp.getCurrentCalDays().stream()
				  .filter(element->element.getText().equals(checkInDay))
				  .limit(1)
				  .collect(Collectors.toList()).get(0);
		
		checkindayElem.click();
	}
	

	@When("^select checkout Month as \"([^\"]*)\"$")
	public void select_checkout_Month_as(String checkoutMonth) throws Throwable {
		Log.info("select checkout Month as "+checkoutMonth);
		while(!chp.getcurrentCalMonth().getText().equals(checkoutMonth)) {
		    chp.getNextMonthClicker().click();
		}
		
	}

	@When("^I select checkout day as \"([^\"]*)\"$")
	public void i_select_checkout_day_as(String checkoutDay) throws Throwable {
		
		Log.info("I select checkout day as "+checkoutDay);

		WebElement checkoutdayElem=chp.getCurrentCalDays().stream()
									  .filter(element->element.getText().equals(checkoutDay))
									  .limit(1)
									  .collect(Collectors.toList()).get(0);
		
		checkoutdayElem.click();
	
		
	}
	
	@When("^I click on the search button$")
	public void i_click_on_the_search_button() throws Throwable {
		Log.info("I click on the search button");
	    chp.getSearchButton().click();
	}
	
	@Then("^I find \"([^\"]*)\" in the webpage$")
	public void i_find_in_the_webpage(String dispString) throws Throwable {
	    Log.info("I find "+dispString+" in the webpage");
		assertEquals(chp.getDisplayText().getText(),dispString);
		Log.endTestCase("Ending Calender Home Page test features");

	}

}
