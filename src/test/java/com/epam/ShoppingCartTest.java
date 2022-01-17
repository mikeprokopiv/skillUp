package com.epam;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCartTest {

    WebDriver driver;
    AutomationPracticeHomePage automationPracticeHomePage;
    AutomationPracticeShoppingCartPage automationPracticeShoppingCartPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    @DisplayName("Verify user is redirected to Shopping-cart page")
    public void shoppingCardTest() {
        automationPracticeHomePage = new AutomationPracticeHomePage(driver);
        Assertions.assertTrue(automationPracticeHomePage.shoppingCartPageButtonIsDisplayed());
        Assertions.assertEquals("SHOPPING-CART SUMMARY", automationPracticeHomePage.getShoppingCartPageTitle());
    }

    @Test
    @DisplayName("Verify shopping cart is empty & summary steps are displayed")
    public void shoppingCartIsEmptyTest() {
        automationPracticeShoppingCartPage = new AutomationPracticeShoppingCartPage(driver);
        Assertions.assertEquals("Your shopping cart is empty.", automationPracticeShoppingCartPage.getShoppingCartSummaryText());
        Assertions.assertTrue(automationPracticeShoppingCartPage.summaryButtonIsDisplayed());
        Assertions.assertTrue(automationPracticeShoppingCartPage.signInButtonButtonIsDisplayed());
        Assertions.assertTrue(automationPracticeShoppingCartPage.addressButtonButtonIsDisplayed());
        Assertions.assertTrue(automationPracticeShoppingCartPage.shippingButtonButtonIsDisplayed());
        Assertions.assertTrue(automationPracticeShoppingCartPage.paymentButtonButtonIsDisplayed());
    }

    @After
    public void terminateBrowser() {
        driver.close();
    }
}
