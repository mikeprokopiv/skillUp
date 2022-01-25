package de.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class LowestPriceCarPage {
    WebDriver driver;
    By technicalSpecification = By.xpath("//div[@id='td-box']");
    By parkOfferButton = By.xpath("//span[@id='park-link-top']");
    By carPark = By.xpath("//a[@id='hdmysc2']");
    By currentParkedCarPrice = By.xpath("//div[@class='parking__currentPrice']");

    public LowestPriceCarPage(WebDriver driver) {
        this.driver = driver;
    }

    boolean technicalSpecificationIsDisplayed() {
        return driver.findElement(technicalSpecification).isDisplayed();
    }

    boolean parkCar() {
        driver.findElement(parkOfferButton).click();
        return Objects.equals(driver.findElement(By.xpath("//span[@class='header-meta-action-counter']")).getText(), "(1)");

    }

    void goToCarPark() {
        driver.findElement(carPark).click();
    }

    boolean offerIsParked() {
        return Integer.parseInt(driver.findElement(currentParkedCarPrice).getText().replace(",", "").substring(1, 6)) == MobileDeSearchResultsPage.firstAdvertisedCarPrice;
    }
}
