
@calendar
Feature: Clicking on calender in booking.com

Scenario: Display search result based on checkin and checkout date
	Given I navigate towards "https://www.booking.com/" 
	When I click on the "Where are you going?" text box
	And I provide "Kashmir" as input
	And I click on the check in tab
	And I select checkin Month as "October 2021"
	And I select checkin day as "5"
	And select checkout Month as "November 2021"
	And I select checkout day as "3"
	And I click on the search button
	Then I find "Jammu & Kashmir: 247 properties found" in the webpage 	