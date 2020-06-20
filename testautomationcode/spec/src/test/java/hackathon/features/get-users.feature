Feature: Get the user list

Background:

Scenario: 
	Given url apiURL
	And path '/api/v2/users'
	When method GET
	Then status 200
	* print 'Response', response



 