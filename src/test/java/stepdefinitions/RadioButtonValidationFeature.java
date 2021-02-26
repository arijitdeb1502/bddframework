package stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commontestfunctions.Common;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjectrepo.RadioButtonHomePage;

public class RadioButtonValidationFeature extends Common{
	
	WebDriver driver;
	static RadioButtonHomePage rbp;
	WebElement selectedRadioButton=null;

	
	@Given("^I move to \"([^\"]*)\" page$")
	public void i_move_to_page(String radioButtonPage) throws Throwable {
		driver = initializeDriver();
		driver.get(radioButtonPage);
	}

	@Then("^I find total (\\d+) radio buttons on the page$")
	public void i_find_total_radio_buttons_on_the_page(int expectedRadioButtonCount) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    rbp=new RadioButtonHomePage(driver);
	    
	    int actualRadioButtonCount=rbp.getAllRadioButtonElements().size();
	    assertEquals(expectedRadioButtonCount,actualRadioButtonCount);
	
	}
	
	@When("^I select radio button with display text as \"([^\"]*)\"$")
	public void i_select_radio_button_with_display_text_as(String radioButtonText) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		rbp=new RadioButtonHomePage(driver);
		
		for(WebElement radioButtonElem:rbp.getAllRadioButtonElements()) {
			System.out.println(radioButtonElem.getAttribute("value"));

			if(radioButtonElem.getAttribute("value").equals(radioButtonText)) {
				selectedRadioButton=radioButtonElem;
				radioButtonElem.click();
			}
		}
		System.out.println(rbp.getAllRadioButtonElements().get(1).isSelected()+"ARRRRRR");
		
		
	}

	@Then("^I see that the text message of the selected radio button is \"([^\"]*)\"$")
	public void i_see_that_the_text_message_of_the_selected_radio_button_is(String expectedVal) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(selectedRadioButton.getAttribute("value"),expectedVal);
	
	}





}
