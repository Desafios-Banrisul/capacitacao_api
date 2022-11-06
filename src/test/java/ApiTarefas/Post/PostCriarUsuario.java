package ApiTarefas.Post;

import Models.CriarUsuarioModel;
import TestBases.TestBase;
import Utils.FileOperation;
import Utils.ObjectUtils;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostCriarUsuario extends TestBase {
    private static final CriarUsuarioModel criarUsuarioModel = new CriarUsuarioModel();
    private static Map<String, Object> createUserObject;

    @Test
    public void criarUser(){
        createUserObject = ObjectUtils.buildModalBody("user", criarUsuarioModel);

            given()
                    .spec(requestSpec)
                    .basePath(PATH_USERS)
                    .body(createUserObject)
                    .log().body()
                .when()
                    .post()
                .then()
                    .spec(responseSpec)
                .and()
                    .log().body()
                    .log().status()
                    .statusCode(201);
    }
}
