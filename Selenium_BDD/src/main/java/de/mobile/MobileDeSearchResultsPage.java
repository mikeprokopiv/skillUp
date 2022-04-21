package de.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MobileDeSearchResultsPage {
    static int firstAdvertisedCarPrice;
    WebDriver driver;
    boolean priceLowestFirstSorting;
    List<WebElement> searchedResultCarsPrices;
    By searchResults = By.xpath("//h1[@data-testid='result-list-headline']");
    By sortPriceLowToHigh = By.xpath("//select[@id='so-sb']/option[@value='p-up']");
    By resultsOffersPrices = By.xpath("//span[@class='h3 u-block']");

    public MobileDeSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchResultsDisplayed() {
        return driver.findElement(searchResults).isDisplayed();
    }

    public void sortResultsFromLowToHighPrice() {
        driver.findElement(sortPriceLowToHigh).click();
    }

    public boolean isSearchResultsSorted() {
        searchedResultCarsPrices = driver.findElements(resultsOffersPrices);
        firstAdvertisedCarPrice = Integer.parseInt(searchedResultCarsPrices.get(1).getText().replace(",", "").substring(1, 6));
        int secondAdvertisedCarPrice = Integer.parseInt(searchedResultCarsPrices.get(2).getText().replace(",", "").substring(1, 6));
        int thirdAdvertisedCarPrice = Integer.parseInt(searchedResultCarsPrices.get(3).getText().replace(",", "").substring(1, 6));
        if (firstAdvertisedCarPrice <= secondAdvertisedCarPrice) {
            priceLowestFirstSorting = secondAdvertisedCarPrice <= thirdAdvertisedCarPrice;
        }
        return priceLowestFirstSorting;

    }

    public void selectLowestPriceOffer() {
        searchedResultCarsPrices.get(1).click();
    }

}
