package de.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MobileDeHomePage {
    WebDriver driver;
    By homePageCookies = By.xpath("//button[contains (@class, 'mde-consent-accept-btn')]");
    By languageToggle = By.xpath("//span[@data-se='header-meta-action-toggle__language']");
    By englishLanguageButton = By.xpath("//ul[@aria-hidden='false']/li/a[@data-se='header-meta-action-toggle__language-en']");
    By carMake = By.xpath("//select[@id='qsmakeBuy']/option[@value='25200']");
    By carModel = By.xpath("//select[@id='qsmodelBuy']/option[@value='54']");
    By carPrice = By.xpath("//div[@id='qsprcwrp']/div/select/option[@value='50000']");
    By carRegistrationFrom = By.xpath("//div[@id='qsfrgwrp']/div/select/option[@value='2020']");
    By carSearchButton = By.xpath("//button[@id='qssub']");
    By searchResults = By.xpath("//h1[@data-testid='result-list-headline']");

    public MobileDeHomePage(WebDriver driver) {
        this.driver = driver;
    }

    void getCookiesAccepted() {
        driver.findElement(homePageCookies).click();
    }

    void setEnglishLanguage() {
        driver.findElement(languageToggle).click();
        driver.findElement(englishLanguageButton).click();
    }

    void searchForaCar() {
        driver.findElement(carMake).click();
        driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
        driver.findElement(carModel).click();
        driver.findElement(carPrice).click();
        driver.findElement(carRegistrationFrom).click();
        driver.findElement(carSearchButton).click();
    }
}
