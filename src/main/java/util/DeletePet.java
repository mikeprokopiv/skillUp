package util;

import io.restassured.http.ContentType;
import models.Pet;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class DeletePet {
    String  BASE_URL = "https://petstore.swagger.io/v2/pet/";

    public void deletePet(int petId) {
         given().
                contentType(ContentType.JSON).
                when().
                delete(BASE_URL+ petId).
                then().log().body().assertThat().
                contentType("application/json").
                statusCode(200).
                 body("message", equalTo(String.valueOf(petId)));
    }




}
