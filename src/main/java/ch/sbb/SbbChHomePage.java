package ch.sbb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SbbChHomePage {
    WebDriver driver;
    By acceptCookiesButton = By.xpath("//*/button[@id='onetrust-accept-btn-handler']");
    By departureStationInputField = By.xpath("//div[@class='mod_textfield mod_timetable_input_form_gpsinput']/div[@class='mod_textfield_container']/input[@id='fromField']");
    By arrivalStationInputField = By.xpath("//div[@class='mod_textfield mod_timetable_input_form_gpsinput']/div[@class='mod_textfield_container']/input[@id='toField']");
    By datePickerNextDayButton = By.xpath("//button[@data-datepicker='button_next_day']");
    By searchButton = By.xpath("//div[contains(@class, 'mod_timetable_input_form_buttonwrapper')]/button[@data-sit-component='primary button']");

    public SbbChHomePage(WebDriver driver) {
        this.driver = driver;
    }

    void navigateToSbbSite() {
        driver.manage().window().maximize();
        driver.get("https://www.sbb.ch/");
    }

    void acceptCookies() {
        driver.findElement(acceptCookiesButton).click();
    }

    void setDepartureStation() {
        driver.findElement(departureStationInputField).sendKeys("Zürich HB");
    }

    void setArrivalStationStation() {
        driver.findElement(arrivalStationInputField).sendKeys("Genève");
    }

    String getDepartureStation() {
        return driver.findElement(departureStationInputField).getText();
    }

    String getArrivalStationStation() {
        return driver.findElement(arrivalStationInputField).getText();
    }

    void setTravelDateToNextDay() {
        driver.findElement(datePickerNextDayButton).click();
    }

    void clickConnectionSearchButton() {
        driver.findElement(searchButton).click();
    }

}
