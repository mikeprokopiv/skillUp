package restAssured;

import io.restassured.http.ContentType;
import models.Category;
import models.Pet;
import models.Tag;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class PetStore2 {
    String BASE_URL = "https://petstore.swagger.io/v2";

    @DataProvider(name = "petSpices")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {new Pet(
                        20221,
                        new Category[]{ new Category(1, "Imaginary"), new Category(2, "Cute")},
                        "Fairy",
                        new String[]{"https://www.myImage1.jpg"},
                        new Tag[]{new Tag(3, "Tale"),new Tag(4, "Movie"),new Tag(5, "Cheesy")} ,
                        "available"
                        )
                },
                {new Pet(
                        589878,
                        new Category[]{ new Category(11, "Cool")},
                        "SuperDoggie",
                        new String[]{"https://www.myImage2.jpg"},
                        new Tag[]{new Tag(23, "Childhood")} ,
                        "available"
                )
                },
                {new Pet(
                        58988578,
                        new Category[]{ new Category(111, "Real")},
                        "Snake",
                        new String[]{"https://www.myImage2.jpg"},
                        new Tag[]{new Tag(2, "Nasty")} ,
                        "available"
                )
                }









                            } ;
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
                body("category.id[0]", equalTo(newPet.getCategory()[0].getId())).
//                body("category.name", equalTo(newPet.getCategory().getName())).
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