package ApiTarefas.Delete;

import TestBases.TestBase;
import Utils.FileOperation;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteContato extends TestBase {
    private static final String id = FileOperation.getProperties("Variables").getProperty("idContato");

    @Test
    public void deletarContato(){

        given()
                .spec(requestSpec)
                .basePath(PATH_CONTACTS)
            .when()
                .delete("/" + id)
            .then()
                .statusCode(204);
    }

    @Test
    public void confirmaDeleteContato(){

        given()
                .spec(requestSpec)
                .basePath(PATH_CONTACTS)
            .when()
                .get("/" + id)
            .then()
                .spec(responseSpec)
                .log().status()
                .statusCode(404)
                .body("error" , equalTo ("Not Found"));
    }
}
