Feature: Practising radio button validation in Selenium webdriver

Scenario: Testing radio button count validation in a dummy test webpage
Given I move to "http://demo.guru99.com/test/radio.html" page
Then I find total 3 radio buttons on the page

@radioButton
Scenario: Testing radio button selection validation in a dummy test webpage
Given I move to "http://demo.guru99.com/test/radio.html" page
When I select radio button with display text as "Option 2"
Then I see that the text message of the selected radio button is "Option 2"