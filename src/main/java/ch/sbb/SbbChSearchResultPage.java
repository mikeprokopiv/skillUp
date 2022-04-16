package ch.sbb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SbbChSearchResultPage {
    private final WebDriver driver;
    private final By searchedResultsGrid = By.xpath("//button[contains(@class, 'mod_timetable_buy_button')]");
    private final By departureTime = By.xpath("//*/div[@class='mod_timetable_starttime']/span");
    private final By arrivalTime = By.xpath("//*/div[@class='mod_timetable_endtime']/span");

    public SbbChSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    String getDepartureTime() {
        return driver.findElements(departureTime).get(1).getText();
    }

    String getArrivalTime() {
        return driver.findElements(arrivalTime).get(1).getText();
    }

    List<WebElement> getSearchResultsOption() {
        return driver.findElements(searchedResultsGrid);
    }

}
