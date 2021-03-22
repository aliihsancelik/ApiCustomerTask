




  Feature: Creating a customer

    @positiveCreate
    Scenario Outline: Verify creating a customer feature by sending valid Post request "<condition>"
      When I send a Post request to the base uri with a valid body "<condition>"
      Then I should see "200" status code
      And I should see the expected response header and body for a successfull Post request
      Examples:
      |condition|
      |includes title|
      |does not include title|




