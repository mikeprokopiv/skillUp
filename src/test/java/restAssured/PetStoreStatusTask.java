package restAssured;

import io.restassured.http.ContentType;
import models.Category;
import models.Pet;
import models.Tag;
import org.apache.commons.lang.ArrayUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PetStoreStatusTask {
    String BASE_URL = "https://petstore.swagger.io/v2";

    @DataProvider(name = "petSpices")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {new Pet(
                        785228555,
                        new Category(1, "Cat1"),
                        "Ferret",
                        new String[]{"https://www.myImage1.jpg"},
                        new Tag[]{new Tag(3, "Tale"),new Tag(4, "Movie"),new Tag(5, "Cheesy")} ,
                        "pending"
                        )
                },
                {new Pet(
                        58978878,
                        new Category(11, "Cool"),
                        "Parrot",
                        new String[]{"https://www.myImage2.jpg"},
                        new Tag[]{new Tag(23, "Cat2")} ,
                        "pending"
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
                body("id", equalTo((int)newPet.getId())).
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

    @Test(dataProvider = "petSpices")
    public void getAllPendingPets(Pet expectedPet) {
        boolean petWasFound = false;
        Pet[] pendingPetList= given().
                        contentType(ContentType.JSON).
                        queryParam("status", "pending").
                when().
                        get(BASE_URL + "/pet/findByStatus?status=pending").
                        as((Type) Pet[].class);

        for (Pet pet : pendingPetList) {
            if (expectedPet.getId() == (pet.getId())) {
                petWasFound = true;
                break;
            }
        }
        assertTrue(petWasFound);
        ;
    }
}