package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebElement;

import commontestfunctions.Common;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjectrepo.CalendarHomePage;

public class CalenderTestSteps extends Common{
	CalendarHomePage chp;
	
	@Given("^I navigate towards \"([^\"]*)\"$")
	public void i_navigate_towards(String calendarHomePage) throws Throwable {
		driver = initializeDriver();
		driver.get(calendarHomePage);
	}

	@When("^I click on the \"([^\"]*)\" text box$")
	public void i_click_on_the_text_box(String arg1) throws Throwable {
	    chp=new CalendarHomePage(driver);
	    chp.getSearchDestinationInputBox().click();
	}

	@When("^I provide \"([^\"]*)\" as input$")
	public void i_provide_as_input(String destination) throws Throwable {
	    chp.getSearchDestinationInputBox().sendKeys(destination);
	}

	@When("^I click on the check in tab$")
	public void i_click_on_the_check_in_tab() throws Throwable {
	    chp.getcheckinTab().click();
	}

	@When("^I select checkin Month as \"([^\"]*)\"$")
	public void i_select_checkin_Month_as(String checkinMonth) throws Throwable {

		while(!chp.getcurrentCalMonth().getText().equals(checkinMonth)) {
		    chp.getNextMonthClicker().click();
		}
		
	}
	
	@When("^I select checkin day as \"([^\"]*)\"$")
	public void i_select_checkin_day_as(String checkInDay) throws Throwable {

		WebElement checkindayElem=chp.getCurrentCalDays().stream()
				  .filter(element->element.getText().equals(checkInDay))
				  .limit(1)
				  .collect(Collectors.toList()).get(0);
		
		checkindayElem.click();
	}
	

	@When("^select checkout Month as \"([^\"]*)\"$")
	public void select_checkout_Month_as(String checkoutMonth) throws Throwable {
		while(!chp.getcurrentCalMonth().getText().equals(checkoutMonth)) {
		    chp.getNextMonthClicker().click();
		}
		
	}

	@When("^I select checkout day as \"([^\"]*)\"$")
	public void i_select_checkout_day_as(String checkoutDay) throws Throwable {
		
		WebElement checkoutdayElem=chp.getCurrentCalDays().stream()
									  .filter(element->element.getText().equals(checkoutDay))
									  .limit(1)
									  .collect(Collectors.toList()).get(0);
		
		checkoutdayElem.click();
	
		
	}
	
	@When("^I click on the search button$")
	public void i_click_on_the_search_button() throws Throwable {
	    chp.getSearchButton().click();
	}
	
	@Then("^I find \"([^\"]*)\" in the webpage$")
	public void i_find_in_the_webpage(String dispString) throws Throwable {
	    assertEquals(chp.getDisplayText().getText(),dispString);
	}

}
