package StepDefinitions;

import Pojos.Customer;
import Utilities.ConfigurationReader;
import Utilities.DataGenerator;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class CustomerFlowStepDefs {

    Customer customer = new Customer();

    JsonPath jsonPath1;
    JsonPath jsonPath2;
    JsonPath jsonPath3;

    String customerId;

    @Given("I create a customer with full valid information")
    public void i_create_a_customer_with_full_valid_information() {

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

        jsonPath1 = response.jsonPath();

        customerId = jsonPath1.getString("body.customerId");
    }


    @When("I retrieve the customer which I created by using its email as an endpoint")
    public void i_retrieve_the_customer_which_I_created_by_using_its_email_as_an_endpoint() {

        Response response = given().accept(ContentType.JSON)
                            .when().get("/"+customerId).prettyPeek();

        assertEquals(200, response.getStatusCode());

        jsonPath2 = response.jsonPath();

    }


    @Then("I should see the email of the customer in the response body as {string}")
    public void i_should_see_the_email_of_the_customer_in_the_response_body_as(String endPoint) {

        assertEquals(customerId , jsonPath2.getString(endPoint));
    }


    @Then("When I delete the customer by using the same email as an endpoint")
    public void when_I_delete_the_customer_by_using_the_same_email_as_an_endpoint() {

        Response response = given().accept(ContentType.JSON)
                .when().delete("/"+customerId).prettyPeek();

        assertEquals(200, response.getStatusCode());

        jsonPath3 = response.jsonPath();
    }


    @Then("I should see {string} as true in the response body")
    public void i_should_see_as_true_in_the_response_body(String deletedInfo) {

        assertEquals(true , jsonPath3.getBoolean(deletedInfo));
    }

}
