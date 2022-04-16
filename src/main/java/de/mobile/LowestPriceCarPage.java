package de.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class LowestPriceCarPage {
    WebDriver driver;
    By technicalSpecification = By.xpath("//div[@id='td-box']");
    By parkOfferButton = By.xpath("//span[@id='park-link-top']");
    By carParkButton = By.xpath("//a[@id='hdmysc2']");
    By currentParkedCarPrice = By.xpath("//div[@class='parking__currentPrice']");

    public LowestPriceCarPage(WebDriver driver) {
        this.driver = driver;
    }

    boolean isTechnicalSpecificationDisplayed() {
        return driver.findElement(technicalSpecification).isDisplayed();
    }

    void addOfferToParkCar() {
        driver.findElement(parkOfferButton).click();
    }

    //TODO remove hardcode
    boolean isCarParked() {
        return Objects.equals(driver.findElement(By.xpath("//span[@class='header-meta-action-counter']")).getText(), "(1)");

    }

    void navigateToCarParkPage() {
        driver.findElement(carParkButton).click();
    }

    //TODO remove reference to static element, better to use word or create a separate class for global variable values
    boolean isOfferParked() {
        return Integer.parseInt(driver.findElement(currentParkedCarPrice).getText().replace(",", "").substring(1, 6)) == MobileDeSearchResultsPage.firstAdvertisedCarPrice;
    }
}
