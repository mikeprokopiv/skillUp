package ch.sbb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SbbChPassengerDetailsPage {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 60);
    By passengerDetailPageHeader = By.xpath("//input[@data-parsley-reisender_name='Vorname']");
    By passengerNameInputField = By.xpath("//input[@data-parsley-reisender_name='Vorname']");
    By passengerSurnameInputField = By.xpath("//input[@data-parsley-reisender_name='Name']");
    By passengerBirthDateInputField = By.xpath("//input[@data-traveler='birth_date']");
    By discountCalculationsDone = By.xpath("//*/div[contains(@style, 'display: none;') and @id='j_idt1264_blocker']");
    By discountOptionsDropdown = By.xpath("//button[contains(@id, 'abonnement')]/span[@class='mod_multiselect_icon']");
    By noDiscountOption = By.xpath("//div[@aria-hidden='false']/div/div/input[@value='KEINE']");
    By acceptPassengerButton = By.xpath("//button[@id='buttonAcceptPassenger']");

    public SbbChPassengerDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    void setWaitForPassengerPageToBeLoaded() {
        wait.until(ExpectedConditions.attributeToBe(passengerDetailPageHeader, "aria-invalid", "false"));
    }

    String getPassengerName() {
        return driver.findElement(passengerNameInputField).getText();
    }

    void setPassengerName(String passengerName) {
        driver.findElement(passengerNameInputField).sendKeys(passengerName);
    }

    String getPassengerSurname() {
        return driver.findElement(passengerSurnameInputField).getText();
    }

    void setPassengerSurname(String passengerSurname) {
        driver.findElement(passengerSurnameInputField).sendKeys(passengerSurname);
    }

    String getPassengerBirthDate() {
        return driver.findElement(passengerBirthDateInputField).getText();
    }

    void setPassengerBirthDate(String passengerBirthDate) {
        driver.findElement(passengerBirthDateInputField).sendKeys(passengerBirthDate);
        driver.findElement(passengerBirthDateInputField).sendKeys(Keys.TAB);
    }

    void setWaitForDiscountCalculation() {
        wait.until(ExpectedConditions.attributeToBe(discountCalculationsDone, "display", "none"));
    }

    void setDiscountOptionToNone() {
        driver.findElement(discountOptionsDropdown).click();
        driver.findElement(noDiscountOption).click();
    }

    void acceptPassenger() {
        driver.findElement(acceptPassengerButton).click();
    }
}
