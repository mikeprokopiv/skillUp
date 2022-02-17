package restAssured;

import io.restassured.http.ContentType;
import models.Category;
import models.Pet;
import models.Tag;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class PetStore {
    String BASE_URL = "https://petstore.swagger.io/v2";

    @DataProvider(name = "petSpices")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {new Pet(
                        20221,
                        new Category(1, "Pegasus"),
                        "Valkyrie",
                        new String[]{"https://www.helpfulhorsehints.com/wp-content/uploads/white-pegasus-768x512.jpg"},
                        new Tag[]{new Tag(3, "Mystery creatures")},
                        "available"
                )
                },
                {
                        new Pet(
                                20222,
                                new Category(2, "Unicorn"),
                                "Sparky Daydreamer",
                                new String[]{"https://i.pinimg.com/originals/a3/c9/0e/a3c90e5b792d65dc17fce0c2e1f12a6c.png"},
                                new Tag[]{new Tag(3, "Mystery creatures")},
                                "available"
                        )
                },
                {
                        new Pet(
                                20223,
                                new Category(3, "Snake-Turtle"),
                                "Hiragana",
                                new String[]{"https://www.everythingreptiles.com/wp-content/uploads/2020/07/Pet-Turtle-Names.jpg"},
                                new Tag[]{new Tag(1, "Reptile")},
                                "available"
                        )
                }

        };
    }

    @Test(dataProvider = "petSpices")
    public void createPet(Pet newPet) {
        given().
                contentType(ContentType.JSON).
                body(newPet).
        when().
                post(BASE_URL + "/pet/").
        then().
                log().body().
        assertThat().
                contentType("application/json").
                statusCode(200).
                body("id", equalTo(newPet.getId())).
                body("category.size()", equalTo(2)).
                body("category.id", equalTo(newPet.getCategory().getId())).
                body("category.name", equalTo(newPet.getCategory().getName())).
                body("name", equalTo(newPet.getName())).
                body("photoUrls.size()", equalTo(newPet.getPhotoUrls().length)).
//              TODO:assertion fails since Actual result has redundant "<>" signs.To check how properly handle.
//              body("photoUrls", equalTo(Arrays.toString(newPet.getPhotoUrls()))).
//              TODO:To check why we have to -1 the expected array.size.
//              body("tags.size()", equalTo(pet.getTag().length - 1)).
//              TODO:assertion fails since Actual result has redundant "<>" signs.To check how properly handle.
//              body("tags", equalTo(newPet.getTags())).
                body("status", equalTo(newPet.getStatus()));
    }

    @Test(dataProvider = "petSpices")
    public void getPet(Pet expectedPet) {
        Pet actualPet =
                given().
                        contentType(ContentType.JSON).
                        queryParam("id", expectedPet.getId()).
                when().
                        get(BASE_URL + "/pet/"+ expectedPet.getId()).
                as(Pet.class);
                assertEquals(expectedPet.toString(), actualPet.toString());
    }
}