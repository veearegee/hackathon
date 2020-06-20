Feature: API test with Karate DSL

Background:
 * def tester = "123"
 
Scenario Outline: 
	Given url 'http://dummy.restapiexample.com/api/v1/employees'
	When method get
	Then status 200
	And def a = <testValue>
	* call read('pages-get2.feature') 
	* print 'Tester in page1', a

Examples:
 |testValue|
 |"Rajagopal"|
 |"Akshatha"| 
 

 