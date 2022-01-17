package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomationPracticeHomePage {

    WebDriver driver;
    By shoppingCartIcon = By.xpath("//*[@class='shopping_cart']/a");
    By shoppingCartPageTitle = By.xpath("//h1[@id='cart_title']");

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

}
