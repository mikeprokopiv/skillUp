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
    By getCarMake = By.xpath("//*/label[@for= 'qsmakeBuy']");
    By carModel = By.xpath("//select[@id='qsmodelBuy']/option[@value='54']");
    By getCarModel = By.xpath("//*/select[@id= 'qsmodelBuy']");
    By carPrice = By.xpath("//div[@id='qsprcwrp']/div/select/option[@value='50000']");
    By getCarPrice = By.xpath("//div[@id='qsprcwrp']");
    By carRegistrationDateFrom = By.xpath("//div[@id='qsfrgwrp']/div/select/option[@value='2020']");
    By getCarRegistrationDateFrom = By.xpath("//div[@id='qsfrgwrp']");
    By carSearchButton = By.xpath("//button[@id='qssub']");
    By englishPageHeader = By.xpath("//*/header[@id='main-header']");

    public MobileDeHomePage(WebDriver driver) {
        this.driver = driver;
    }

    void acceptCookies() {
        driver.findElement(homePageCookies).click();
    }

    void setLanguageToEnglish() {
        driver.findElement(languageToggle).click();
        driver.findElement(englishLanguageButton).click();
    }

    String pageHeaderText() {return driver.findElement(englishPageHeader).getText().substring(0, 37);}

    void setCarMake() {
        driver.findElement(carMake).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    void setCarModel() {
        driver.findElement(carModel).click();
    }

    void setCarPrice() {
        driver.findElement(carPrice).click();
    }

    void setCarRegistrationDateFrom() {
        driver.findElement(carRegistrationDateFrom).click();
    }

    String getCarMake() {
        return driver.findElement(getCarMake).getText();
    }

    String getCarModel() {return driver.findElement(getCarModel).getText();}

    String getCarPrice() {return driver.findElement(getCarPrice).getText();}

    String getCarRegistrationDateFrom() {return driver.findElement(getCarRegistrationDateFrom).getText();}

    void clickCarSearchButton() {
        driver.findElement(carSearchButton).click();
    }
}
