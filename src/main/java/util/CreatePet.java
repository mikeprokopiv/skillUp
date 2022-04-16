package util;

import io.restassured.http.ContentType;
import models.Pet;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class CreatePet {
    String  BASE_URL = "https://petstore.swagger.io/v2/pet/";

    public void createPet(Pet newPet) {
        given().
                contentType(ContentType.JSON).
                body(newPet).
        when().
                post(BASE_URL).
        then().
                log().body().
        assertThat().
                contentType("application/json").
                statusCode(200).
                body("id", equalTo((int) newPet.getId())).
                body("category.size()", equalTo(2)).
                body("category.id", equalTo(newPet.getCategory().getId())).
                body("category.name", equalTo(newPet.getCategory().getName())).
                body("name", equalTo(newPet.getName())).
                body("photoUrls[0]", equalTo(newPet.getPhotoUrls()[0])).
                body("tags.size()", equalTo(newPet.getTags().length)).
                body("tags[0].id", equalTo(newPet.getTags()[0].getId())).
                body("tags[0].name", equalTo(newPet.getTags()[0].getName())).
                body("status", equalTo(newPet.getStatus()));
    }
}
