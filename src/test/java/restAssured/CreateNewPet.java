package restAssured;

import io.restassured.http.ContentType;
import models.Category;
import models.Pet;
import models.Tags;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateNewPet {
    String BASE_URL = "https://petstore.swagger.io/v2";

    @Test
    public void createDog() {
        String body = """
                {
                  "id": 333,
                  "category": {
                    "id": 1,
                    "name": "small dog"
                  },
                  "name": "Archie",
                  "photoUrls": [
                    "string"
                  ],
                  "tags": [
                    {
                      "id": 2,
                      "name": "dog"
                    }
                  ],
                  "status": "available"
                }
                """;

        var response = given().
                contentType(ContentType.JSON).
                body(body).when().post(BASE_URL + "/pet/").then();
        response.log().body();
    }

    @Test
    public void createSerializedDog() {
        Pet dog = new Pet(
                1,
                new Category(1, "Dogs"),
                "Archie",
                new String[]{"https://en.wikipedia.org/wiki/Dog"},
                new Tags[]{},
                "available"
        );
        var response = given().contentType(ContentType.JSON).
                body(dog).when().post(BASE_URL + "/pet/").then();
        response.log().body();
    }
}