





Feature: Creating a Customer

    @negativeCreate
    Scenario: Verify creating a customer feature by sending invalid Post requests
      When I send a Post request to the base uri with an invalid body
      And I should see the "Missing mandatory data" error message in the response body