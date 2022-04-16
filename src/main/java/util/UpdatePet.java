package util;

import io.restassured.http.ContentType;
import models.Pet;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class UpdatePet {
    public void updatePet(Pet updatedPet) {
        given().
                contentType(ContentType.JSON).
                body(updatedPet).
                when().
                put("https://petstore.swagger.io/v2/pet/").
                then().
                log().body().
                assertThat().
                contentType("application/json").
                statusCode(200).
                body("id", equalTo((int)updatedPet.getId())).
                body("name", equalTo(updatedPet.getName()));
    }


}
