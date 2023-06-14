package adapters;


import utils.PropertyReader;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class BaseAdapter {

    public BaseAdapter() {
        requestSpecification = given().
                header("Content-Type", "application/json").
                header("Token", System.getProperty("token", PropertyReader.getProperty("token")));
    }
}
