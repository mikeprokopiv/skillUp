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
    DataProviders dataProviders = new DataProviders();

    @DataProvider(name = "petSpices")
    public Object[][] petSpices() {
        return dataProviders.getNewPetSpicesCreated();
    }

    @DataProvider(name = "pendingPet")
    public Object[][] pendingPet() {
        return dataProviders.getNewPendingPet();
    }

    @DataProvider(name = "updatePet")
    public Object[][] updatePet() {
        return dataProviders.getNewPetToBeUpdated();
    }

    @DataProvider(name = "ordersList")
    public Object[][] orderList() {
        return dataProviders.getOrderList();
    }

    @DataProvider(name = "singleOrder")
    public Object[][] singleOrder (){
        return dataProviders.getSingleOrder();
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
    public void createAndUpdatePetTest(Pet newPet) {
        Pet updatedPet = new Pet(
                7852555,
                new Category(1, "Imaginary"),
                "Diplodocus",
                new String[]{"https://www.myImage1.jpg"},
                new Tag[]{new Tag(3, "Tale"), new Tag(4, "Movie"), new Tag(5, "Cheesy")},
                "available"
        );

        createPet.createPet(newPet);
        updatePet.updatePet(updatedPet);
        assertEquals(retrievePet.getPetById(updatedPet.getId()).getName(), "Diplodocus");
    }

    @Test(dataProvider = "petSpices")
    public void createAndDeletePetTest(Pet newPet) {
        createPet.createPet(newPet);
        deletePet.deletePet((int) newPet.getId());
    }

    @Test(dataProvider = "singleOrder")
    public void createOrderTest(Order newSingleOrder) {
        orderPet.createOrder(newSingleOrder);
    }

    @Test(dataProvider = "ordersList")
    public void createMultipleOrdersAndVerifyStatuses(Order newOrder) {
        orderPet.createOrder(newOrder);
        retrievePet.getPetInventoriesByStatus();
    }
}