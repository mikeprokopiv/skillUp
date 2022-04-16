package ch.sbb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SbbChTripSummaryPage {
    private final WebDriver driver;
    private final By priceWithoutDiscount = By.xpath("//*/li/p[@class='mod_dates_summation_box_ticket_price']");
    private final By editPassengerButton = By.xpath("//*/button[@id='buttonEditPassenger']");
    private final By getDepartureStation = By.xpath("//*/h1/span[contains (@class, 'origin_destination')]");
    private final By getArrivalStation = By.xpath("//*/h1/span[contains (@class, 'target_destination')]");
    private final By tripsTomorrowsDate = By.xpath("//*/li/p[contains(@class, 'ticket_date')]");
    private final By getTripsDepartureTime = By.xpath("//*/li/p[contains(@class, 'ticket_date')]");
    private final By getTripsArrivalTime = By.xpath("//*/li/p[contains(@class, 'ticket_validity')]");
    private final By getTripsPassengerNameAndSurname = By.xpath("//*/div/ol[contains(@class,'travelers_list')]");
    private final By getTaxOption = By.xpath("//*/span[@class='traveler_discounts']");

    public SbbChTripSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    int priceWithoutDiscount() {
        return Integer.parseInt(driver.findElement(priceWithoutDiscount).getText());
    }

    void editPassengerData() {
        driver.findElement(editPassengerButton).click();
    }

    //TODO to check if this method can be removed
    int priceWithDiscount() {
        return Integer.parseInt(driver.findElement(priceWithoutDiscount).getText());
    }

    String getTripsDepartureStation() {
        return driver.findElement(getDepartureStation).getText().substring(13, 22);
    }

    String getTripsArrivalStation() {
        return driver.findElement(getArrivalStation).getText().substring(13, 23);
    }

    String getTripTomorrowsDate() {
        return driver.findElement(tripsTomorrowsDate).getText().substring(13, 23);
    }

    String tomorrowsDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        return new SimpleDateFormat("dd.MM.yyyy").format(c.getTime());
    }

    String getTripsDepartureTime() {
        return driver.findElement(getTripsDepartureTime).getText().substring(27, 32);
    }

    String getTripsArrivalTime() {
        return driver.findElement(getTripsArrivalTime).getText().substring(20, 25);
    }

    String getTripsPassengerNameAndSurname() {
        return driver.findElement(getTripsPassengerNameAndSurname).getText().substring(0, 10);
    }

    String getTaxOption() {
        return driver.findElement(getTaxOption).getText();
    }
}


