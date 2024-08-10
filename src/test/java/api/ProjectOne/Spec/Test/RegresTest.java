package api.ProjectOne.Spec.Test;

import api.ProjectOne.Spec.Data.CalorsData;
import api.ProjectOne.Spec.Data.SuccesReg;
import api.ProjectOne.Spec.Data.UserData;
import api.ProjectOne.Spec.Data.UserNew;
import api.ProjectOne.Spec.Data.UserNewResponse;
import api.ProjectOne.Spec.Data.ErrorReg;
import api.ProjectOne.Spec.Data.Register;
import api.ProjectOne.Spec.Specification;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegresTest {
    private final static String URL = "https://reqres.in";



    @Test
    public void checkAvatarAndIdTest(){
        Specification.installSpecification(Specification.requestSpec(URL),Specification.responseSpecOK200());
        List<UserData> users = given()
                .when()
                .get("/api/users?page=2")

                .then().log().all()
                .extract().body().jsonPath().getList("data",UserData.class);
        users.forEach(x -> assertTrue(x.getAvatar().contains(x.getId().toString())));
        assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));
        List<String> avatars = users.stream().map(UserData :: getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(x -> x.getId().toString()).collect(Collectors.toList());
        System.out.println("sdfsdf");
        System.out.println(avatars);
        System.out.println("sdfsdf");
        for (int i = 0; i< avatars.size(); i++){
           assertTrue(avatars.get(i).contains(ids.get(i)));
            System.out.println(avatars.get(i));
            System.out.println(ids.get(i));
        }


    }

    @Test
    public void getUsers1(){
        Specification.resetSpecifications();
        given()
                .when()
                .contentType(ContentType.JSON)
                .get("https://reqres.in/api/users/2")
                .then().log().all()
                .statusCode(200);
    }
    @Test
    public void getUsers(){
    Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
    given()
            .when()
            .get("/api/users/2")
            .then().log().all();
}

    @Test
    public void successRegTest(){
        Specification.installSpecification(Specification.requestSpec(URL),Specification.responseSpecOK200());
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
    @Test
    public void errorRegTest() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecERROR400());
        Register user = new Register("eve.holt@reqres", "pisto");
        ErrorReg errorReg = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(ErrorReg.class);
        assertEquals("Note: Only defined users succeed registration", errorReg.getError());
    }
    @Test
    public void errorRegTestNotPass() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecERROR400());
        Register user = new Register("eve.holt@reqres");
        ErrorReg errorReg = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(ErrorReg.class);
        assertEquals("Missing password", errorReg.getError());
    }
    @Test
    public void errorRegTestNotEmail() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecERROR400());
        Register user = new Register(null,"sdf");
        ErrorReg errorReg = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(ErrorReg.class);
        assertEquals("Missing email or username", errorReg.getError());
    }
    @Test
    public void sortedYearsTest() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        List<CalorsData> calorsData = given()
                .when()
                .get("/api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", CalorsData.class);
        List<Integer> years = calorsData.stream().map(CalorsData::getYear).collect(Collectors.toList());


        List<Integer> sortYears = years.stream().sorted().collect(Collectors.toList());
        assertEquals(sortYears, years);
    }
    @Test
    public void deleteUserTest(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecUnique(204));
        given()
                .when()
                .delete("/api/users/2")
                .then().log().all();

    }
    @Test
    public void testTime(){
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecUnique(200));
        UserNew userNew = new UserNew("morpheus","zion resident");
        UserNewResponse userNewResponse = given()
                .body(userNew)
                .when()
                .put("/api/users/2")
                .then().log().all()
                .extract().as(UserNewResponse.class);
        String regex = "(.{5})$";
        String regex1 = "(.{11})$";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex1,"");

        assertEquals(currentTime, userNewResponse.getUpdatedAt().replaceAll(regex,""));
        System.out.println(currentTime);
        System.out.println(userNewResponse.getUpdatedAt());
    }
}
