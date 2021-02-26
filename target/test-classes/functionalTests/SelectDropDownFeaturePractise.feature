Feature: Practising select dropdown in Selenium webdriver

@select
Scenario: Testing Select dropdown in a dummy test webpage
Given I go to "https://rahulshettyacademy.com/dropdownsPractise/" page
When I select the currency dropdown as "USD"
Then I find the actual dropdown value to be "USD"