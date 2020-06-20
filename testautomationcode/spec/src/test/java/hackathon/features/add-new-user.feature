Feature: Add a new user to the list

Background:
 
 * def payload = read('classpath:hackathon/payloads/user-details.json')

Scenario: 
	Given url apiURL
	And path 'api/v2/addusers'
	And request payload
	When method POST
	Then status 200
	* print 'Add user Response', response



 