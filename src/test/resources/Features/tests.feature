@E2E
Feature: Verify the APIs of Restful-Booker website


Background:

Given I give the baseURI and request Specifications

@getRequest
Scenario: Verify GET request method


When I send the "GET" request with "getBookings" endpoint

Then I verify the "GET" response code 200 

@getToken 
Scenario: Create Auth token

And I send the "AUTH" request with "createAuth" endpoint 


@postRequest 
Scenario: Verify POST request method

Given I give the "POSTRequest" body

When I send the "POST" request with "createBooking" endpoint

Then I verify the "POST" response code 200 


@putRequest
Scenario: Verify PUT request method

Given I give the "PUTRequest" body

When I send the "PUT" request with "updateBooking" endpoint

Then I verify the "PUT" response code 200


@patchRequest 
Scenario: Verify PATCH request method

Given I give the "PATCHRequest" body

When I send the "PATCH" request with "partialUpdateBooking" endpoint

Then I verify the "PATCH" response code 200


@deleteRequest 
Scenario: Verify DELETE request method

Given I give the baseURI and request Specifications

When I send the "DELETE" request with "deleteBooking" endpoint

Then I verify the "DELETE" response code 201
