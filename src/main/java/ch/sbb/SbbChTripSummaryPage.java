package ch.sbb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SbbChTripSummaryPage {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 60);
    By priceWithoutDiscount = By.xpath("//*/li/p[@class='mod_dates_summation_box_ticket_price']");
    By editPassengerButton = By.xpath("//*/button[@id='buttonEditPassenger']");

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

}
