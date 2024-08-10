package api.ProjectOne.Spec.Test;

import api.ProjectOne.Spec.Data.Register;
import api.ProjectOne.Spec.Data.SuccesReg;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class RegresNoPojoTest {
    private final static String URL = "https://reqres.in";
    @Test
    public void getUsers1(){
        given()
                .when()
                .contentType(ContentType.JSON)
                .get("https://reqres.in/api/users/2")
                .then().log().all()
                .statusCode(200);
    }
    @Test
    public void successRegTest(){
        int id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in","pistol");
        SuccesReg succesReg = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(SuccesReg.class);
        assertEquals(id,succesReg.getId());
        assertEquals(token,succesReg.getToken());
        System.out.println(succesReg.getToken());
    }
}
