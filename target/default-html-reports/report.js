$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/Resources/Features/CustomerFlow.feature");
formatter.feature({
  "name": "Creating, getting and deleting a customer",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify the flow of create, get and delete a customer",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@flowTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I create a customer with full valid information",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.CustomerFlowStepDefs.i_create_a_customer_with_full_valid_information()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I retrieve the customer which I created by using its email as an endpoint",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.CustomerFlowStepDefs.i_retrieve_the_customer_which_I_created_by_using_its_email_as_an_endpoint()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the email of the customer in the response body as \"customerId\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.CustomerFlowStepDefs.i_should_see_the_email_of_the_customer_in_the_response_body_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "When I delete the customer by using the same email as an endpoint",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.CustomerFlowStepDefs.when_I_delete_the_customer_by_using_the_same_email_as_an_endpoint()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see \"deleted\" as true in the response body",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.CustomerFlowStepDefs.i_should_see_as_true_in_the_response_body(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
});