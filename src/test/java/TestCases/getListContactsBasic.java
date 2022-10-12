package TestCases;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getListContactsBasic {

    @Test
    public void listaContatos(){
        String baseURI = "https://api-de-tarefas.herokuapp.com/contacts";

        given()
            .when()
                .get(baseURI)
            .then()
                .log()
                .body()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void listaContatos2(){
        String baseURI = "https://api-de-tarefas.herokuapp.com/contacts";

        Response resposta =
                given()
                    .when()
                        .get(baseURI)
                    .then()
                        .log()
                        .all()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();
//        resposta.body().prettyPrint();
    }

    @Test
    public void listaContatos3(){
        String baseURI = "https://api-de-tarefas.herokuapp.com/contacts";

        String resposta =
                given()
                    .when()
                        .get(baseURI)
                    .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().path("data[0].id");

        System.out.println(resposta);
    }


    @Test
    public void listaContatos4(){
        String baseURI = "https://api-de-tarefas.herokuapp.com/contacts";

        given()
            .when()
                .get(baseURI)
            .then()
                .log()
                .body()
                .assertThat()
                .statusCode(200)
                .body("data[0].attributes.name", equalTo("Aileen"));
    }
}
