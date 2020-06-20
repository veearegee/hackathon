Feature: API test with Karate DSL

Scenario: Verify return of pages

Given url 'http://dummy.restapiexample.com/api/v1/employees'
When method get
Then status 200

* print 'Tester', a
