package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomationPracticeShoppingCartPage {

    WebDriver driver;
    By shoppingCartSummary = By.xpath("//div/p[contains (@class, 'alert-warning')]");
    By summaryButton = By.xpath("//ul[@id='order_step']/li[contains (@class, 'first')]");
    By signInButton = By.xpath("//ul[@id='order_step']/li[contains (@class, 'second')]");
    By addressButton = By.xpath("//ul[@id='order_step']/li[contains (@class, 'third')]");
    By shippingButton = By.xpath("//ul[@id='order_step']/li[contains (@class, 'four')]");
    By paymentButton = By.xpath("//ul[@id='order_step']/li[contains (@class, 'last')]");

    public AutomationPracticeShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    String getShoppingCartSummaryText() {
        return driver.findElement(shoppingCartSummary).getText();
    }

    Boolean summaryButtonIsDisplayed() {
        return driver.findElement(summaryButton).isDisplayed();
    }

    Boolean signInButtonButtonIsDisplayed() {
        return driver.findElement(signInButton).isDisplayed();
    }

    Boolean addressButtonButtonIsDisplayed() {
        return driver.findElement(addressButton).isDisplayed();
    }

    Boolean shippingButtonButtonIsDisplayed() {
        return driver.findElement(shippingButton).isDisplayed();
    }

    Boolean paymentButtonButtonIsDisplayed() {
        return driver.findElement(paymentButton).isDisplayed();
    }
}
