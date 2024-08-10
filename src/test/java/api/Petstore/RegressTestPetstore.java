package api.Petstore;
import api.Petstore.Data.DataGetCategory;
import api.Petstore.Data.DataGetPet;
import api.Petstore.Data.DataGetTag;
import io.restassured.http.ContentType;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegressTestPetstore {
    String URL = "https://petstore.swagger.io/v2";

    @Test
            public void getPetTest() {
        List<DataGetPet> pet = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/pet/2")
                .then().log().all()
                .statusCode(200)
                .extract().body().jsonPath().getList("Data", DataGetPet.class);
//        DataGetPet dataGetPet = new DataGetPet(); Бля я заебался не могу понять как мне из pet достать поле DataGetPet.getId, хочу проверить что id равен цифре в урле
//        System.out.println

    }

}
