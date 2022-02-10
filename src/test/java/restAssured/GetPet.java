package restAssured;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import io.restassured.http.ContentType;
import models.Category;
import models.Pet;
import models.Tags;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetPet {
    String BASE_URL = "https://petstore.swagger.io/v2";

    @Test
    //not working solution :(
    public void getPegasus() {
        Pet expectedPet = new Pet(
                20221,
                new Category(1, "Pegasus"),
                "Valkyrie",
                new String[]{"https://www.helpfulhorsehints.com/wp-content/uploads/white-pegasus-768x512.jpg"},
                new Tags[]{},
                "available"
        );

         Pet actualPet =
                given().
                    contentType(ContentType.JSON).
                    queryParam("id", 20221).
                when().
                    get(BASE_URL + "/pet/20221/").
                    as(Pet.class);
                assertThat(actualPet,samePropertyValuesAs(expectedPet));
    }


    @Test
    public void getNotDeserializedPegasus() {
        given().
                contentType(ContentType.JSON).
                queryParam("id", 20221).
        when().
                get(BASE_URL + "/pet/20221/").
        then().
                log().body().
                assertThat().
                contentType("application/json").
                statusCode(200).
                body("id", equalTo(20221)).
                body("category.name",equalTo("Pegasus")).
                body("name",equalTo("Valkyrie"));
    }

    @Test
    public void getNotDeserializedUnicorn() {
        given().
                contentType(ContentType.JSON).
                queryParam("id", 20222).
        when().
                get(BASE_URL + "/pet/20222/").
        then().
                log().body().
                assertThat().
                contentType("application/json").
                statusCode(200).
                body("id", equalTo(20222)).
                body("category.name",equalTo("Unicorn")).
                body("name",equalTo("Sparky Daydreamer"));
    }


    @Test
    public void getNotDeserializedSnakeTurtle() {
        given().
                contentType(ContentType.JSON).
                queryParam("id", 20223).
        when().
                get(BASE_URL + "/pet/20223/").
        then().
                log().body().
                assertThat().
                contentType("application/json").
                statusCode(200).
                body("id", equalTo(20223)).
                body("category.name",equalTo("Snake-Turtle")).
                body("name",equalTo("Hiragana"));
    }

}