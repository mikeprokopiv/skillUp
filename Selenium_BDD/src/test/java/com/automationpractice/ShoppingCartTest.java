package com.automationpractice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingCartTest {

    WebDriver driver;
    AutomationPracticeHomePage automationPracticeHomePage;
    AutomationPracticeShoppingCartPage automationPracticeShoppingCartPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver99.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void shoppingCardTest() {
        automationPracticeHomePage = new AutomationPracticeHomePage(driver);
        assertTrue(automationPracticeHomePage.shoppingCartPageButtonIsDisplayed());
        assertEquals("SHOPPING-CART SUMMARY", automationPracticeHomePage.getShoppingCartPageTitle());
    }

    @Test
    public void shoppingCartIsEmptyTest() {
        automationPracticeShoppingCartPage = new AutomationPracticeShoppingCartPage(driver);
        assertEquals("Your shopping cart is empty.", automationPracticeShoppingCartPage.getShoppingCartSummaryText());
        assertTrue(automationPracticeShoppingCartPage.summaryButtonIsDisplayed());
        assertTrue(automationPracticeShoppingCartPage.signInButtonButtonIsDisplayed());
        assertTrue(automationPracticeShoppingCartPage.addressButtonButtonIsDisplayed());
        assertTrue(automationPracticeShoppingCartPage.shippingButtonButtonIsDisplayed());
        assertTrue(automationPracticeShoppingCartPage.paymentButtonButtonIsDisplayed());
    }

    @After
    public void terminateBrowser() {
        driver.close();
    }
}
