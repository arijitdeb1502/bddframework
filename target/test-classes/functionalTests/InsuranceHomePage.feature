
@tag
Feature: Loging page features for demo insurance app in guru99

Background: User is logged in
  Given I navigate to "http://demo.guru99.com/insurance/v1/index.php" page
  When I submit email as "arijithere@gmail.com" and password as "password"
  Then user should be reditrected to "http://demo.guru99.com/insurance/v1/header.php" page
 
Scenario: User will be able to log out
	When I click on the "Log Out" button
	Then I will be redirected to "http://demo.guru99.com/insurance/v1/index.php" page

Scenario: The logo of the insurance page is properly dispalyed
	When I check the logo 
	Then I find its image source attribute as "http://demo.guru99.com/logo.png"   
	And I find its alternate source as "Guru99 Demo Sites"
	And also when I check the logo text
	Then I find the value as "Demo Site"

Scenario: The Selenium menubar toggle functionality is working properly
	When I click on the Selenium menubar
	Then the following dropdown list is getting displayed
	| displayText			           			 |	hrefVal												|
	|	Flash Movie Demo 					 			 |	http://demo.guru99.com/test/flash-testing.html |
	|	Radio & Checkbox Demo			 			 |  http://demo.guru99.com/test/radio.html 			 |
	|	Table Demo						 			     |  http://demo.guru99.com/test/table.html 				 |
	| Accessing Link                   |  http://demo.guru99.com/test/link.html         |
	| Ajax Demo                        |  http://demo.guru99.com/test/ajax.html  |
	| Inside & Outside Block Level Tag |  http://demo.guru99.com/test/block.html |
  | Delete Customer Form             |  http://demo.guru99.com/test/delete_customer.php |
  | Yahoo			           			       |	http://demo.guru99.com/test/yahoo.html												|
	|	Tooltip         					 			 |	http://demo.guru99.com/test/tooltip.html |
	|	File Upload			 			 |  http://demo.guru99.com/test/upload/ 			 |
	|	Login						 			     |  http://demo.guru99.com/test/login.html 				 |
	| Social Icon                  |  http://demo.guru99.com/test/social-icon.html         |
	| Selenium Auto IT                       |  http://demo.guru99.com/test/autoit.html  |
	| Selenium IDE Test |  http://demo.guru99.com/test/facebook.html |
  | Guru99 Demo Page            |  http://demo.guru99.com/test/guru99home/ |
  |	Scrollbar Demo			 			 |  http://demo.guru99.com/test/guru99home/scrolling.html 			 |
	|	File Upload using Sikuli Demo						 			     |  http://demo.guru99.com/test/image_upload/ 				 |
	| Cookie Handling Demo                   |  http://demo.guru99.com/test/cookie/selenium_aut.php         |
	| Drag and Drop Action                       |  http://demo.guru99.com/test/drag_drop.html  |
	| Selenium DatePicker Demo |  http://demo.guru99.com/test/ |
	  