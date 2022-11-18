package ApiTarefas.Post;

import Models.RealizarLoginModel;
import TestBases.TestBase;
import Utils.FileOperation;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class PostRealizarLogin extends TestBase {
    private static final RealizarLoginModel realizarLoginModel = new RealizarLoginModel();
    @Test
    public void realizarLogin(){
        Response resposta =

            given()
                    .spec(requestSpec)
                    .basePath(PATH_SESSIONS)
                    .body(realizarLoginModel)
                    .log().body()
                    .when()
                    .post()
                    .then()
                    .log().body()
                    .spec(responseSpec)
                    .statusCode(200)
                    .extract().response();

        FileOperation.setProperties("Variables", "tokenLogin" , resposta.then().extract().path("data.attributes.auth-token"));
        System.out.println(resposta.then().extract().path("data.attributes.auth-token").toString());
    }
}

