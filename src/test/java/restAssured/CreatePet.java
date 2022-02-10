package restAssured;

import io.restassured.http.ContentType;
import models.Category;
import models.Pet;
import models.Tags;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class CreatePet {
    String BASE_URL = "https://petstore.swagger.io/v2";

   @Test
    public void createPegasus() {
        Pet Pegasus = new Pet(
                20221,
                new Category(1, "Pegasus"),
                "Valkyrie",
                new String[]{"https://www.helpfulhorsehints.com/wp-content/uploads/white-pegasus-768x512.jpg"},
                new Tags[]{},
                "available"
                        );
        given().
                contentType(ContentType.JSON).
                body(Pegasus).
        when().
                post(BASE_URL + "/pet/").
        then().
                log().body().
                assertThat().
                contentType("application/json").
                statusCode(200).
                body("id", equalTo(20221)).
                body("category.size()",equalTo(2)).
                body("category.id",equalTo(1)).
                body("category.name",equalTo("Pegasus")).
                body("name",equalTo("Valkyrie")).
                body("tags.size()",equalTo(0)).
                body("status",equalTo("available"));
   }

    @Test
    public void createUnicorn() {
        Pet Pegasus = new Pet(
                20222,
                new Category(2, "Unicorn"),
                "Sparky Daydreamer",
                new String[]{"https://i.pinimg.com/originals/a3/c9/0e/a3c90e5b792d65dc17fce0c2e1f12a6c.png"},
                new Tags[]{},
                "available"
        );
        given().
                contentType(ContentType.JSON).
                body(Pegasus).
                when().
                post(BASE_URL + "/pet/").
                then().
                log().body().
                assertThat().
                contentType("application/json").
                statusCode(200).
                body("id", equalTo(20222)).
                body("category.size()",equalTo(2)).
                body("category.id",equalTo(2)).
                body("category.name",equalTo("Unicorn")).
                body("name",equalTo("Sparky Daydreamer")).
                body("tags.size()",equalTo(0)).
                body("status",equalTo("available"));
    }

    @Test
    public void createSnakeTurtle() {
        Pet Pegasus = new Pet(
                20223,
                new Category(3, "Snake-Turtle"),
                "Hiragana",
                new String[]{"https://www.everythingreptiles.com/wp-content/uploads/2020/07/Pet-Turtle-Names.jpg"},
                new Tags[]{},
                "available"
        );
        given().
                contentType(ContentType.JSON).
                body(Pegasus).
                when().
                post(BASE_URL + "/pet/").
                then().
                log().body().
                assertThat().
                contentType("application/json").
                statusCode(200).
                body("id", equalTo(20223)).
                body("category.size()",equalTo(2)).
                body("category.id",equalTo(3)).
                body("category.name",equalTo("Snake-Turtle")).
                body("name",equalTo("Hiragana")).
                body("tags.size()",equalTo(0)).
                body("status",equalTo("available"));
    }
}