package adapters;


import dto.TestCase;

import static io.restassured.RestAssured.given;

public class CaseAdapter {

    public void create(TestCase testCase, String code) {
        given().
                body(testCase).
                when().
                post("https://api.qase.io/v1/case/" + code).
                then().
                log().all().
                statusCode(200);
    }

    public void delete(String code) {
        given().
                when().
                delete("https://api.qase.io/v1/case/" + code + "/1").
                then().
                log().all().
                statusCode(200);
    }
}
