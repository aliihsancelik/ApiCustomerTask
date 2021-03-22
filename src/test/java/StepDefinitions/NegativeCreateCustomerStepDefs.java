package StepDefinitions;

import Pojos.Customer;
import Utilities.DataGenerator;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class NegativeCreateCustomerStepDefs {


    private static final Logger logger = Logger.getLogger(NegativeCreateCustomerStepDefs.class);

    Customer customer = new Customer();
    JsonPath jsonPath;


    @When("I send a Post request to the base uri with an invalid body")
    public void i_send_a_Post_request_to_the_base_uri_with_an_invalid_body() {

        Response response;

        customer.setEmail(DataGenerator.createUserInfo().get("email"));
        customer.setFirstName(DataGenerator.createUserInfo().get("firstName"));
        customer.setLastName((DataGenerator.createUserInfo().get("lastName")));
        logger.info("\"password\" mandatory data is missing! ");

        response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .when().body(customer).post().prettyPeek();

        assertEquals(200, response.getStatusCode());

        jsonPath = response.jsonPath();
    }


    @Then("I should see the {string} error message in the response body")
    public void i_should_see_the_error_message_in_the_response_body(String errorMessage) {

        Assert.assertEquals(errorMessage , jsonPath.getString("errorMessage"));
    }

}
