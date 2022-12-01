package ApiTarefas.Delete;

import TestBases.TestBase;
import Utils.FileOperation;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteTarefa extends TestBase{
    private static final String id = FileOperation.getProperties("Variables").getProperty("idTarefa");

    @Test
    public void deletarTarefa(){

        given()
                .spec(requestSpec)
                .basePath(PATH_TASKS)
                .when()
                .delete( "/" + id )
                .then()
                .assertThat()
                .statusCode(204);
    }

    @Test
    public void verificarDeletaTarefa(){

        given()
                .spec(requestSpec)
                .basePath(PATH_TASKS)
                .when()
                .get( "/" + id)
                .then()
                .spec(responseSpec)
                .log().status()
                .statusCode(404);
    }

}
