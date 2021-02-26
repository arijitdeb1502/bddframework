package stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commontestfunctions.Common;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjectrepo.SelectDropDownPage;
 

public class SelectDropDownFeatureSteps extends Common {
	SelectDropDownPage sdp;
	static Select dropdown;
	
	@Given("^I go to \"([^\"]*)\" page$")
	public void i_go_to_page(String selectDropDownPage) throws Throwable {
		driver = initializeDriver();
		driver.get(selectDropDownPage);
	}
	
	@When("^I select the currency dropdown as \"([^\"]*)\"$")
	public void i_select_the_currency_dropdown_as(String currency) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		sdp=new SelectDropDownPage(driver);
		WebElement staticDropDown = sdp.getStaticDropDownElement();
		
	    dropdown=new Select(staticDropDown);
		dropdown.selectByVisibleText(currency);
		
	}

	@Then("^I find the actual dropdown value to be \"([^\"]*)\"$")
	public void i_find_the_actual_dropdown_value_to_be(String actualDropDownVal) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(dropdown.getFirstSelectedOption().getText(),actualDropDownVal);
	}

}
