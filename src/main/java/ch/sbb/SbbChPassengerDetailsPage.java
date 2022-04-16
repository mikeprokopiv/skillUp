package ch.sbb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SbbChPassengerDetailsPage {
    private final WebDriver driver;
    private final By passengerDetailPageHeader = By.xpath("//input[@data-parsley-reisender_name='Vorname']");
    private final By passengerNameInputField = By.xpath("//input[@data-parsley-reisender_name='Vorname']");
    private final By passengerSurnameInputField = By.xpath("//input[@data-parsley-reisender_name='Name']");
    private final By passengerBirthDateInputField = By.xpath("//input[@data-traveler='birth_date']");
    private final By discountCalculationsDone = By.xpath("//*/div[contains(@style, 'display: none;') and @id='j_idt1264_blocker']");
    private final By discountOptionsDropdown = By.xpath("//button[contains(@id, 'abonnement')]/span[@class='mod_multiselect_icon']");
    private final By noDiscountOption = By.xpath("//div[@aria-hidden='false']/div/div/input[@value='KEINE']");
    private final By halfTaxOption = By.xpath("//div/div/div/input[@value='HTA123']");
    private final By acceptPassengerButton = By.xpath("//button[@id='buttonAcceptPassenger']");
    private WebDriverWait wait;

    public SbbChPassengerDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    void setWaitForPassengerPageToBeLoaded() {
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.attributeToBe(passengerDetailPageHeader, "aria-invalid", "false"));
    }

    String getPassengerName() {
        return driver.findElement(passengerNameInputField).getText();
    }

    void setPassengerName() {
        driver.findElement(passengerNameInputField).sendKeys("John");
    }

    String getPassengerSurname() {
        return driver.findElement(passengerSurnameInputField).getText();
    }

    void setPassengerSurname() {
        driver.findElement(passengerSurnameInputField).sendKeys("Smith");
    }

    String getPassengerBirthDate() {
        return driver.findElement(passengerBirthDateInputField).getText();
    }

    void setPassengerBirthDate() {
        driver.findElement(passengerBirthDateInputField).sendKeys("01.01.2004");
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

    void setDiscountOptionToHalfTax() {
        driver.findElement(passengerBirthDateInputField).click();
        driver.findElement(passengerBirthDateInputField).sendKeys(Keys.TAB);
        setWaitForDiscountCalculation();
        driver.findElement(discountOptionsDropdown).click();
        driver.findElement(halfTaxOption).click();
    }

    String getDiscountOptionChosen() {
        return driver.findElement(halfTaxOption).getText();
    }
}