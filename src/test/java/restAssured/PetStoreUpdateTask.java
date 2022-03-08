package restAssured;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import models.Category;
import models.Pet;
import models.Tag;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PetStoreUpdateTask {
    String BASE_URL = "https://petstore.swagger.io/v2";

    @DataProvider(name = "petSpices")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {new Pet(
                        7852555,
                        new Category(1, "Cat1"),
                        "Brontosaurus",
                        new String[]{"https://www.myImage1.jpg"},
                        new Tag[]{new Tag(3, "Tale"),new Tag(4, "Movie"),new Tag(5, "Cheesy")} ,
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

  //This code is not working
    @Test
    public void updatePet() {
                Pet updatedPet = new Pet(
                                        7852255,
                                        new Category(1, "Imaginary"),
                                        "Diplodocus",
                                        new String[]{"https://www.myImage1.jpg"},
                                        new Tag[]{new Tag(3, "Tale"),new Tag(4, "Movie"),new Tag(5, "Cheesy")} ,
                                        "available"
                                        );
                given().
                        contentType(ContentType.JSON).
                        body(updatedPet).
                when().
                        put(BASE_URL + "/pet/"+ 7852555).
                then().
                        log().body().
                assertThat().
                        contentType("application/json").
                        statusCode(200).
                        body("id", equalTo(7852555)).
                        body("name", equalTo("Diplodocus"));
    }
}