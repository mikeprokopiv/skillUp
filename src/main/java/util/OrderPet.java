package util;

import io.restassured.http.ContentType;
import models.Order;
import models.Pet;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class OrderPet {
    String BASE_URL = "https://petstore.swagger.io/v2/store/order/";

    public void createOrder(Order newOrder) {
        given().
                contentType(ContentType.JSON).
                body(newOrder).
        when().
                post(BASE_URL).
        then().
                log().body().
                assertThat().
                contentType("application/json").
                statusCode(200).
                body("id", equalTo(newOrder.getId())).
                 body("petId", equalTo(newOrder.getPetId())).
                body("quantity", equalTo(newOrder.getQuantity())).
                body("shipDate", equalTo(newOrder.getShipDate())).
                body("status",equalTo(newOrder.getStatus())).
                body("complete",equalTo(newOrder.isComplete()));
    }
}