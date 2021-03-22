package StepDefinitions;

import Utilities.ConfigurationReader;
import io.cucumber.java.*;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.*;

public class Hooks {

    private static final Logger logger = Logger.getLogger(Hooks.class);

    @Before
    public void setup(){
        logger.info("Before the URI Setup");
        baseURI = ConfigurationReader.get("uri");
    }
}
