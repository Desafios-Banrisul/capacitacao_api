package ApiTarefas.Post;

import ApiTarefas.Delete.DeleteContato;
import Models.CriarContatoModel;
import TestBases.TestBase;
import Utils.FileOperation;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostCriarContato extends TestBase {
    private static final CriarContatoModel criarContatoModel = new CriarContatoModel();
    private static final DeleteContato deleteContato = new DeleteContato();

    @Test
    public void criarContato(){
        Response resposta =

            given()
                    .spec(requestSpec)
                    .basePath(PATH_CONTACTS)
                    .body(criarContatoModel)
                    .log().body()
                .when()
                    .post()
                .then()
                    .spec(responseSpec)
                .and()
                    .log()
                    .body()
                    .statusCode(201)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/json-schema.json"))
                    .extract().response();

        System.out.println(resposta.then().extract().path("data.id").toString());
        FileOperation.setProperties("Variables", "idContato", resposta.then().extract().path("data.id"));

        deleteContato.deletarContato();
        deleteContato.confirmaDeleteContato();
    }
}
