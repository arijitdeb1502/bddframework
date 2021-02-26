@tag
Feature: Item checkout functionality from a dummy e-commerce website

  @dummy-e-commerce
  Scenario: Item(s) checkout functionality
    Given I move to "https://rahulshettyacademy.com/seleniumPractise/#/"
    When I add the following in my shopping cart
    |	Name		|	Quantity	|
    |Brocolli |			3			|
    |Tomato		| 		2			|
    |Brinjal 	| 		5 		|
    And click the add to cart icon
    And I click on the "PROCEED TO CHECKOUT" button to checkout
    And I give promocode as "rahulshettyacademy"
    And I click on the apply promocode button
    Then I see the text "Code applied ..!"
    

