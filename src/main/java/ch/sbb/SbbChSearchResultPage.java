package ch.sbb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SbbChSearchResultPage {
    WebDriver driver;
    By searchedResultsGrid = By.xpath("//button[contains(@class, 'mod_timetable_buy_button')]");
    By departureTime = By.xpath("//*/div[@class='mod_timetable_starttime']/span");
    By arrivalTime = By.xpath("//*/div[@class='mod_timetable_endtime']/span");

    public SbbChSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    String getDepartureTime(int searchResultOptionNumber) {
        return driver.findElements(departureTime).get(searchResultOptionNumber).getText();
    }

    String getArrivalTime(int searchResultOptionNumber) {
        return driver.findElements(arrivalTime).get(searchResultOptionNumber).getText();
    }

    List<WebElement> getSearchResultsOption() {
        return driver.findElements(searchedResultsGrid);
    }

}
