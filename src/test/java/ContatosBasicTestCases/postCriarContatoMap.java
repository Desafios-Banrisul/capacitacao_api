package ContatosBasicTestCases;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postCriarContatoMap {
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;
    private static RequestSpecification requestSpecificationDelete;

    @BeforeEach
    public void setUp() {
        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("name", "Eduarda");
        requestBody.put("last_name", "Keller");
        requestBody.put("email", "dk12345@teste.com.br");
        requestBody.put("age", "23");
        requestBody.put("phone", "6765545");
        requestBody.put("address", "Rua Torta");
        requestBody.put("state", "RS");
        requestBody.put("city", "Porto Alegre");

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath("/contacts")
                .setBody(requestBody)
                .setContentType(ContentType.JSON)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/vnd.tasksmanager.v2")
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();

        requestSpecificationDelete = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath("/contacts")
                .setContentType(ContentType.JSON)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/vnd.tasksmanager.v2")
                .build();

    }

        @Test
        public void criarContato(){
            given()
                .spec(requestSpecification)
            .when()
                    .post()
            .then()
                    .spec(responseSpecification)
            .and()
                    .log()
                    .body()
                    .statusCode(201);
    }

    @Test
    public void criarEsalvaId(){
        String id =

        given()
                .spec(requestSpecification)
            .when()
                .post()
            .then()
                .spec(responseSpecification)
            .and()
                .log()
                .body()
                .statusCode(201)
                .extract()
                .path("data.id");

        System.out.println(id.toString());
        deletaContatos(id);
        verificaDeletarContato(id);
    }

    private void deletaContatos(String id){
        given()
                .spec(requestSpecificationDelete)
            .when()
                .delete("/"+ id)
            .then()
                .log()
                .ifValidationFails(LogDetail.STATUS)
                .statusCode(204);
    }

    private void verificaDeletarContato(String id ){
        given()
                .spec(requestSpecificationDelete)
            .when()
                .get("/"+ id)
            .then()
                .spec(responseSpecification)
                .log()
                .status()
                .statusCode(404)
                .body("error", equalTo("Not Found"));
    }
}
