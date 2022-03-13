package restAssured;

import models.Category;
import models.Order;
import models.Pet;
import models.Tag;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PetStore {
    boolean petWasFound;

    CreatePet createPet = new CreatePet();
    RetrievePet retrievePet = new RetrievePet();
    UpdatePet updatePet = new UpdatePet();
    DeletePet deletePet = new DeletePet();
    OrderPet orderPet = new OrderPet();

    @DataProvider(name = "petSpices")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {new Pet(
                        7852255,
                        new Category(1, "Imaginary"),
                        "Fairy",
                        new String[]{"https://www.myImage1.jpg"},
                        new Tag[]{new Tag(3, "Tale"), new Tag(4, "Movie"), new Tag(5, "Cheesy")},
                        "available"
                )
                },
                {new Pet(
                        589878,
                        new Category(11, "Cool"),
                        "SuperDogie",
                        new String[]{"https://www.myImage2.jpg"},
                        new Tag[]{new Tag(23, "Childhood")},
                        "available"
                )
                },
                {new Pet(
                        58988578,
                        new Category(111, "Real"),
                        "Snake",
                        new String[]{"https://www.myImage2.jpg"},
                        new Tag[]{new Tag(2, "Nasty")},
                        "available"
                )
                },
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

    @DataProvider(name = "pendingPet")
    public Object[][] getPendingPetData() {
        return new Object[][]{
                {new Pet(
                        785228555,
                        new Category(1, "Cat1"),
                        "Ferret",
                        new String[]{"https://www.myImage1.jpg"},
                        new Tag[]{new Tag(3, "Tale"), new Tag(4, "Movie"), new Tag(5, "Cheesy")},
                        "pending"
                )
                },
                {new Pet(
                        58978878,
                        new Category(11, "Cool"),
                        "Parrot",
                        new String[]{"https://www.myImage2.jpg"},
                        new Tag[]{new Tag(23, "Cat2")},
                        "pending"
                )
                }
        };
    }

    @DataProvider(name = "updatePet")
    public Object[][] getUpdatePetData() {
        return new Object[][]{
                {new Pet(
                        7852255,
                        new Category(1, "Imaginary"),
                        "Brontosaurus",
                        new String[]{"https://www.myImage1.jpg"},
                        new Tag[]{new Tag(3, "Tale"), new Tag(4, "Movie"), new Tag(5, "Cheesy")},
                        "available"
                )
                }

        };
    }

    @DataProvider(name = "orders")
    public Object[][] orders() {
        return new Object[][]{
                {new Order(
                        1,
                        10,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "sold",
                        true
                )},
                {new Order(
                        2,
                        11,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "pending",
                        true
                )},
                {new Order(
                        3,
                        12,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "active",
                        true
                )},
                {new Order(
                        4,
                        15,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "sold",
                        true
                )},
                {new Order(
                        5,
                        16,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "pending",
                        true
                )},
                {new Order(
                        6,
                        17,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "active",
                        true
                )},
                {new Order(
                        7,
                        147,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "active",
                        true
                )},
                {new Order(
                        8,
                        19,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "sold",
                        true
                )},
                {new Order(
                        9,
                        141,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "pending",
                        true
                )},
                {new Order(
                        10,
                        121,
                        1,
                        "2022-03-13T12:48:42.838+0000",
                        "active",
                        true
                )}
        };
    }

    @Test(dataProvider = "petSpices")
    public void createAndVerifyPetTest(Pet newPet) {
        createPet.createPet(newPet);
        assertEquals(retrievePet.getPetById(newPet.getId()).toString(), newPet.toString());
    }

    @Test(dataProvider = "pendingPet")
    public void createAndVerifyPendingPetTest(Pet newPet) {
        createPet.createPet(newPet);
        Pet[] pendingPetList = retrievePet.getPetByStatus("pending");
        for (Pet pet : pendingPetList) {
            if (pet.getId() == (newPet.getId())) {
                petWasFound = true;
                break;
            }
        }
        assertTrue(petWasFound);
    }

    @Test(dataProvider = "updatePet")
    public void createAndUpdatePetTest(Pet newPet){
        Pet updatedPet = new Pet(
                7852555,
                new Category(1, "Imaginary"),
                "Diplodocus",
                new String[]{"https://www.myImage1.jpg"},
                new Tag[]{new Tag(3, "Tale"),new Tag(4, "Movie"),new Tag(5, "Cheesy")} ,
                "available"
        );

        createPet.createPet(newPet);
        updatePet.updatePet(updatedPet);
        assertEquals(retrievePet.getPetById(updatedPet.getId()).getName(),"Diplodocus");
    }

    @Test(dataProvider = "petSpices")
    public void createAndDeletePetTest(Pet newPet){
    createPet.createPet(newPet);
    deletePet.deletePet((int) newPet.getId());
    }

    @Test
    public void createOrderTest(){
    Order newOrder = new Order(
                                15,
                                555,
                                1,
                                "2022-03-13T12:48:42.838+0000",
                                "TestMike",
                                true);
        orderPet.createOrder(newOrder);
    }

    @Test(dataProvider = "orders")
    public void createMultipleOrdersAndVerifyStatuses(Order newOrder){
    orderPet.createOrder(newOrder);
    retrievePet.getPetInventoriesByStatus();
    }
}