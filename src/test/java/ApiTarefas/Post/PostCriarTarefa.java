package ApiTarefas.Post;

import Models.CriarTarefaModel;
import TestBases.TestBase;
import Utils.FileOperation;
import Utils.ObjectUtils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostCriarTarefa extends TestBase {

    private static final CriarTarefaModel criarTarefaModel = new CriarTarefaModel();
    private static String token = FileOperation.getProperties("Variables").getProperty("tokenLogin");
    protected static Map<String, Object> criarTarefaObject;

    @Test
    public void criarTarefa() {

        criarTarefaObject = ObjectUtils.buildModalBody("task", criarTarefaModel);

        Response reposta =

            given()
                    .spec(requestSpec)
                    .basePath(PATH_TASKS)
                    .header("Authorization", token)
                    .body(criarTarefaObject)
                    .log().body()
                .when()
                    .post()
                .then()
                    .spec(responseSpec)
                    .log().body()
                    .statusCode(201)
                    .extract().response();

        FileOperation.setProperties("Variables", "idTarefa", reposta.then().extract().path("data.id"));
        System.out.println(reposta.then().extract().path("data.id").toString());
    }
}
