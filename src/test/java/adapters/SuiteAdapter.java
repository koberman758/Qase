package adapters;

import dto.Suite;

import static io.restassured.RestAssured.given;

public class SuiteAdapter {

    public void create(Suite suite, String code) {
        given().
                body(suite).
                when().
                post("https://api.qase.io/v1/suite/" + code).
                then().
                log().all().
                statusCode(200);
    }

    public void delete(String code) {
        given().
                when().
                delete("https://api.qase.io/v1/suite/" + code + "/1").
                then().
                log().all().
                statusCode(200);
    }
}

