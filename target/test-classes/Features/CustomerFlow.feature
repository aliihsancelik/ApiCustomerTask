


  Feature: Creating, getting and deleting a customer

    @flowTest
    Scenario: Verify the flow of create, get and delete a customer

      Given I create a customer with full valid information
      When I retrieve the customer which I created by using its email as an endpoint
      Then I should see the email of the customer in the response body as "customerId"
      And When I delete the customer by using the same email as an endpoint
      Then I should see "deleted" as true in the response body

