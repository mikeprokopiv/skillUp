package ch.sbb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SbbChLoginPage {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 60);
    By loginPageHeader = By.xpath("//*/div/h1[@class='mod_pagetitle']");
    By loginAsGuestButton = By.xpath("//button[@id='loginAsGuestButton']");

    public SbbChLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    void waitForLoginPageToLoad() {
        wait.until(ExpectedConditions.textToBe(loginPageHeader, "Anmelden und profitieren."));
    }
    void loginAsGuest() {
        driver.findElement(loginAsGuestButton);
    }
}
