Feature: Delete user

Background:
 * def id = 
Scenario: 
	Given url apiURL
	And path '/api/v2/', id, '/deleteuser'
	When method DELETE
	Then status 200
	* print 'Delete Response >>>', response



 