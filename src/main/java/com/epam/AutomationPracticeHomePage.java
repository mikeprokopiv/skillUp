package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomationPracticeHomePage {

    WebDriver driver;
    By shoppingCartIcon = By.xpath("//*[@class='shopping_cart']/a");
    By shoppingCartPageTitle = By.xpath("//h1[@id='cart_title']");
    By searchButton = By.xpath("//form/input[contains (@class, 'search_query')]");
    By submitButton = By.xpath("//button[@name='submit_search']");
    By dressTitle = By.xpath("//ul[contains (@class, 'product_list')]/li/div[@class='product-container']/div/h5/a");
    By dressItem = By.xpath("//ul[contains (@class, 'product_list')]/li/div[@class='product-container']");
    By expectedDressTitle = By.xpath("//div/div[@class='columns-container']/div/div[@class='row']/div[@id='center_column']/div/div/div/h1");

    public AutomationPracticeHomePage(WebDriver driver) {
        this.driver = driver;
    }

    Boolean shoppingCartPageButtonIsDisplayed() {
        return driver.findElement(shoppingCartIcon).isDisplayed();
    }

    String getShoppingCartPageTitle() {
        driver.findElement(shoppingCartIcon).click();
        return driver.findElement(shoppingCartPageTitle).getText();
    }

    void searchForText(String searchText) {
        driver.findElement(searchButton).isDisplayed();
        driver.findElement(searchButton).sendKeys(searchText);
        driver.findElement(submitButton).click();
    }

    String getDressTitle() {
        return driver.findElement(dressTitle).getText();
    }

    void getToProductPage() {
        driver.findElement(dressItem).click();
    }
    String getExpectedDressTitle() {
        return driver.findElement(expectedDressTitle).getText();
    }

}
