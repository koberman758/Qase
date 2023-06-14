package adapters;

import dto.Project;

import static io.restassured.RestAssured.given;

public class ProjectAdapter {

    public void create(Project project) {
        given().
                body(project).
                when().
                post("https://api.qase.io/v1/project").
                then().
                log().all().
                statusCode(200);
    }

    public void delete(String code) {
        given().
                when().
                delete("https://api.qase.io/v1/project/" + code).
                then().
                log().all().
                statusCode(200);
    }
}
