package StepDefinitions;

import Pojos.Customer;
import Utilities.ConfigurationReader;
import Utilities.DataGenerator;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;


import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class PositiveCreateCustomerStepDefs {

    // There are 2 bugs in this step definitions:
    // 1- "email" in the request body is not accepting more than 5 letters before "@", it doesn't seem right to me for the users perspective.
    // 2= In the task, the requirement says "title" is optional but in the Scenario Outline Examples; the second case will fail because-
    // -I send the request without "title" and it gives error it says "missing mandatory data".


    private static final Logger logger = Logger.getLogger(PositiveCreateCustomerStepDefs.class);

    Customer customer = new Customer();
    JsonPath jsonPath;


    @When("I send a Post request to the base uri with a valid body {string}")
    public void i_send_a_Post_request_to_the_base_uri_with_a_valid_body(String condition) {


        if(condition.equalsIgnoreCase("includes title")){

            Response response;

            customer.setEmail(DataGenerator.createUserInfo().get("email"));
            customer.setFirstName(DataGenerator.createUserInfo().get("firstName"));
            customer.setLastName((DataGenerator.createUserInfo().get("lastName")));
            customer.setPassword(ConfigurationReader.get("password"));
            customer.setTitle("Mrs");

            response = given().accept(ContentType.JSON)
                    .and().contentType(ContentType.JSON)
                    .when().body(customer).post().prettyPeek();

            assertEquals(200, response.getStatusCode());

            jsonPath = response.jsonPath();


        }else if(condition.equalsIgnoreCase("does not include title")){

            Response response;

            customer.setEmail(DataGenerator.createUserInfo().get("email"));
            customer.setFirstName(DataGenerator.createUserInfo().get("firstName"));
            customer.setLastName((DataGenerator.createUserInfo().get("lastName")));
            customer.setPassword(ConfigurationReader.get("password"));
            logger.info("Requirement says title is optional but response body shows that title is mandatory that's why this case will fail!");

            response = given().accept(ContentType.JSON)
                    .and().contentType(ContentType.JSON)
                    .when().body(customer).post().prettyPeek();

            assertEquals(200, response.getStatusCode());

            jsonPath = response.jsonPath();


        }else{

            logger.info("Invalid Condition, check the condition in the feature file!");
        }
    }


    @Then("I should see {string} status code")
    public void i_should_see_status_code(String expectedStatusCode) {

        assertEquals(Integer.parseInt(expectedStatusCode) , jsonPath.getInt("statusCode"));
    }



    @Then("I should see the expected response header and body for a successfull Post request")
    public void i_should_see_the_expected_response_header_and_body_for_a_successfull_Post_request() {

        assertEquals("*", jsonPath.getString("headers.Access-Control-Allow-Origin"));
        assertEquals(customer.getEmail().replace("@","") , jsonPath.getString("body.customerId"));
        assertEquals(true , jsonPath.getBoolean("body.success"));

    }
}
