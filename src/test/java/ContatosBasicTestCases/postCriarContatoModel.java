package ContatosBasicTestCases;

import Models.CriarContatoModel;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postCriarContatoModel {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;
    private static RequestSpecification requestSpecDelete;
    private static CriarContatoModel criarContatoModel = new CriarContatoModel();

    @BeforeEach
    public void setUp() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath("/contacts")
                .setBody(criarContatoModel)
                .setContentType(ContentType.JSON)
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/vnd.taskmanager.v2")
                .build();

        requestSpecDelete = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath("/contacts")
                .setContentType(ContentType.JSON)
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/vnd.taskmanager.v2")
                .build();


        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void criarContatoModel() {
        String id =

            given()
                    .log().body()
                    .spec(requestSpec)
                .when()
                    .post()
                .then()
                    .spec(responseSpec)
                .and()
                    .log()
                    .body()
                    .statusCode(201)
                    .extract().path("data.id");

        System.out.println(id.toString());
        deletaContato(id);
        verificaDelete(id);
    }

    private void deletaContato(String id) {
        given()
                .spec(requestSpecDelete)
            .when()
                .delete("/" + id)
            .then()
                .log()
                .ifValidationFails(LogDetail.STATUS)
                .statusCode(204);

    }

    private void verificaDelete(String id) {

        given()
                .spec(requestSpecDelete)
            .when()
                .delete("/" + id)
            .then()
                .spec(responseSpec)
                .log()
                .status()
                .statusCode(404)
                .body("error", equalTo("Not Found"));
    }
}

