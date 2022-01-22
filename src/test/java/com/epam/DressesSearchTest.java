package com.epam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class DressesSearchTest {

    WebDriver driver;
    AutomationPracticeHomePage automationPracticeHomePage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void dressSearchTest() {
        automationPracticeHomePage = new AutomationPracticeHomePage(driver);
        automationPracticeHomePage.searchForText("dresses");
        automationPracticeHomePage.getDressTitle();
        automationPracticeHomePage.getToProductPage();

        assertEquals(automationPracticeHomePage.getExpectedDressTitle(), automationPracticeHomePage.getDressTitle());
    }

    @After
    public void terminateBrowser() {
        driver.close();
    }
}