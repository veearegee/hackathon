Feature: Update user details

Background:
 * def payload = read('classpath:hackathon/payloads/user-details.json')

Scenario: 
	Given url apiURL
	And path 'api/v2/updateuser'
	And request payload
	When method PUT
	Then status 200
	* print 'Update Response >>>', response



 