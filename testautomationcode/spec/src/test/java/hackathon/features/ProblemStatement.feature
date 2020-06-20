Feature: 

Background:

#Problem A
Scenario: 
	Given url apiURL
	And path '/api/v2/users'
	When method GET
	Then status 200 
	* print 'Response', response

#Problem B
Scenario: 
#Add new user
	 * def id = 100
	 * def name = "Akshatha"
	 * def surname = "Friend"
	 * def address = "Bengaluru"
	 * def payload = read('classpath:hackathon/payloads/user-details.json')

	Given url apiURL
	And path 'api/v2/addusers'
	And request payload
	When method POST
	Then status 200
	* print 'Add user Response', response
	* def generatedId = response.id
	* print 'User Id generated ::', generatedId
	
#Updating the user details
    * def id = generatedId
	* def name = "NewAkshatha"
	* def surname = "NewFriend"
	* def address = "Chennai"
 	* def payload = read('classpath:hackathon/payloads/user-details.json')

	Given url apiURL
	And path 'api/v2/updateuser'
	And request payload
	When method PUT
	Then status 200
	* print 'Update Response >>>', response
	* match response.name == name
	* match response.surname == surname
	* match response.adress == address
	
#Delete the User
	* def id = generatedId
    Given url apiURL
	And path '/api/v2/', id, '/deleteuser'
	When method DELETE
	Then status 200
	* print 'Delete Response >>>', response
	
#Delete the User for non-existing id
	* def id = 123
    Given url apiURL
	And path '/api/v2/', id, '/deleteuser'
	When method DELETE
	Then status 404
	* print 'Delete non-existing id Response >>>', response
	* match response.apierror.status == "NOT_FOUND"
	


