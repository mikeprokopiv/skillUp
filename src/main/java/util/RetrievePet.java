package util;

import io.restassured.http.ContentType;
import models.Order;
import models.Pet;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

public class RetrievePet {
    String BASE_URL = "https://petstore.swagger.io/v2/pet/";


    public Pet getPetById(Long expectedPetId) {
        return given().
                contentType(ContentType.JSON).
                queryParam("id", expectedPetId).
                when().
                get(BASE_URL + expectedPetId).
                as(Pet.class);
    }

    public Pet[] getPetByStatus(String status) {
        return given().
                contentType(ContentType.JSON).
                queryParam("status", status).
                when().
                get(BASE_URL+"findByStatus?status="+ status).
                as((Type) Pet[].class);
    }

    public void getPetInventoriesByStatus (){
         given().
                contentType(ContentType.JSON).
                when().
                get("https://petstore.swagger.io/v2/store/inventory").
                then().
                log().body().
                assertThat().
                contentType("application/json").
                statusCode(200).
                body("active", equalTo(4)).
                body("sold", equalTo(3)).
                body("pending", equalTo(3));
    }



}
