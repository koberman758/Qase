//import adapters.ProjectAdapter;
//import com.google.gson.Gson;
//import dto.Project;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.when;
//import static org.hamcrest.Matchers.equalTo;
//
//public class OnlinerTest {
//    @Test
//    public void testOnliner() {
//        given().
//                body("{\"login\":\"\",\"password\":\"\"}").
//                header("content-type", "application/json").
//                when().
//                post("https://www.onliner.by/sdapi/user.api/login").
//                then().
//                log().all();
//
//    }
//
//    @Test
//    public void testOnlinerLogin() {
//        given().
//                body("{\"login\":\"david758@yandex.ru\",\"password\":\"\"}").
//                header("content-type", "application/json").
//                when().
//                post("https://www.onliner.by/sdapi/user.api/login").
//                then().
//                log().all().
//                statusCode(422).
//                body("errors.password[0]", equalTo("Укажите пароль"));
//
//    }
//
//    @Test
//    public void testQase() {
//        Project project = Project.builder().
//                title("Tests Project").
//                code("tests").
//                build();
//        new ProjectAdapter().create(project);
//    }
//
//    @Test
//    public void hhRu() {
//      String body =
//            when().
//                      get("https://api.hh.ru/vacancies?text=QA").
//                    then().
//                    //    log().all().
//                        statusCode(200).
//                    extract().response().body().asPrettyString();
//        System.out.println(body);
//        Gson parser = new Gson();
//        HHResponse hhResponse = parser.fromJson(body, HHResponse.class);
//        System.out.println(hhResponse);
//    }
//}
