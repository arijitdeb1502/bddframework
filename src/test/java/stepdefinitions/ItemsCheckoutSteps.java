package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commontestfunctions.Common;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjectrepo.DummyEcommerceHomePage;
//Test comments
public class ItemsCheckoutSteps extends Common{
	
	WebDriver driver;
	static DummyEcommerceHomePage ehp;
	
	@Given("^I move to \"([^\"]*)\"$")
	public void i_move_to(String dummyEcommerceHomePage) throws Throwable {
		driver = initializeDriver();
		driver.get(dummyEcommerceHomePage);
	}

	@When("^I add the following in my shopping cart$")
	public void i_add_the_following_in_my_shopping_cart(DataTable itemsList) throws Throwable {
		
	    ehp=new DummyEcommerceHomePage(driver);
		
		List<Map<String,String>> listOfItemsAndQty=itemsList.asMaps(String.class,String.class);

		for(int i=0;i<ehp.getAllItemNames().size();i++) {
		
			for(Map<String, String> listItem:listOfItemsAndQty) {
				if(ehp.getAllItemNames().get(i).getText().contains(listItem.get("Name"))) {
					int itemCnt=1;
					while(itemCnt<Integer.parseInt(listItem.get("Quantity"))) {
						ehp.getAllItemIncrements().get(i).click();
						itemCnt++;
					}
					
					ehp.getAllAddToCartButtons().get(i).click();
							
				}

			}
		}
	
	}

	@When("^click the add to cart icon$")
	public void click_the_add_to_cart_icon() throws Throwable {
	    ehp.getCartIcon().click();
	}
	
	@When("^I click on the \"([^\"]*)\" button to checkout$")
	public void i_click_on_the_button_to_checkout(String arg1) throws Throwable {
//		driver.manage().window().maximize();
		ehp.getCheckOutButton().click();
	}


	@When("^I give promocode as \"([^\"]*)\"$")
	public void i_give_promocode_as(String promoCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions	    
	    ehp.getPromoCodeTextBox().sendKeys(promoCode);
	}
	
	@When("^I click on the apply promocode button$")
	public void i_click_on_the_apply_promocode_button() throws Throwable {
	    ehp.getApplyPromoButton().click();
	}

	@Then("^I see the text \"([^\"]*)\"$")
	public void i_see_the_text(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait w =new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(),arg1);
	}



}
