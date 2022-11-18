package ApiTarefas.Post;

import Models.CriarUsuarioModel;
import TestBases.TestBase;
import Utils.ObjectUtils;
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
