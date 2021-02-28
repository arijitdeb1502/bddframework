package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import commontestfunctions.Common;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageobjectrepo.LoginPage;
import pageobjectrepo.InsuranceHomePage;


public class InsurancePageFeatureSteps extends Common{
	InsuranceHomePage ihp;
	static WebElement imageSrc;
	static WebElement menuBarSelenium;
	static String titleText;
	
	@Given("^I navigate to \"([^\"]*)\" page$")
	public void i_navigate_to_page(String homepageUrl) throws Throwable {

		driver = initializeDriver();
		driver.get(homepageUrl);

	}

	@When("^I submit email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void i_submit_email_as_and_password_as(String email, String password) throws Throwable {
	    LoginPage hp=new LoginPage(driver);
		
	    hp.getinputEmailText().sendKeys(email);;

		hp.getinputPasswordText().sendKeys(password);;

	    hp.getSubmitButton().click();
		
	}

	@Then("^user should be reditrected to \"([^\"]*)\" page$")
	public void user_should_be_reditrected_to_page(String insurancePageUrl) throws Throwable {	    
		assertEquals(insurancePageUrl, driver.getCurrentUrl());
	}

	@When("^I click on the \"([^\"]*)\" button$")
	public void i_click_on_the_button(String logoutButtonText) throws Throwable {
	    
		ihp=new InsuranceHomePage(driver);
		ihp.getLogoutButton().click();
		
	}

	@Then("^I will be redirected to \"([^\"]*)\" page$")
	public void i_will_be_redirected_to_page(String homepageUrl) throws Throwable {
		
		assertEquals(homepageUrl, driver.getCurrentUrl());

	}
	
	@When("^I check the logo$")
	public void i_check_the_logo() throws Throwable {
		ihp=new InsuranceHomePage(driver);
		imageSrc=ihp.getLogoImageSrc();
	}

	@Then("^I find its image source attribute as \"([^\"]*)\"$")
	public void i_find_its_image_source_attribute_as(String srcName) throws Throwable {
	    assertEquals(imageSrc.getAttribute("src"),srcName);
	}

	@Then("^I find its alternate source as \"([^\"]*)\"$")
	public void i_find_its_alternate_source_as(String altSrc) throws Throwable {
		assertEquals(imageSrc.getAttribute("alt"),altSrc);
	}

	@Then("^also when I check the logo text$")
	public void also_when_I_check_the_logo_text() throws Throwable {
		
		titleText=ihp.getHomePageTitle().getText();
		
	}

	@Then("^I find the value as \"([^\"]*)\"$")
	public void i_find_the_value_as(String actualTitleText) throws Throwable {
	    
		assertEquals(titleText,actualTitleText);

	}
	
	@When("^I click on the Selenium menubar$")
	public void i_click_on_the_Selenium_menubar() throws Throwable {

		ihp=new InsuranceHomePage(driver);
		menuBarSelenium=ihp.getMenuBarSelenium();
		menuBarSelenium.click();
	}

	@Then("^the following dropdown list is getting displayed$")
	public void the_following_dropdown_list_is_getting_displayed(DataTable arg1) throws Throwable {
		ArrayList<WebElement> allMenuElements=(ArrayList<WebElement>) ihp.getAllMenusSelenium();
		List<Map<String,String>> expectedMenuElements=arg1.asMaps(String.class, String.class);
		int expectedIdx=0;
		for(WebElement menuElement:allMenuElements ) {

			assertEquals(expectedMenuElements.get(expectedIdx).get("displayText"),
				    menuElement.getText());
			assertEquals(expectedMenuElements.get(expectedIdx).get("hrefVal"),
					menuElement.getAttribute("href"));
			expectedIdx++;
			
		}
		
	}


}
