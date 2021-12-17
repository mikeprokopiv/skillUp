package com.epam;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPageTest {

    @Test
    public void AmazonPageMailLocators() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        WebElement todayDeal = driver.findElement(By.cssSelector(("a[data-csa-c-content-id='nav_cs_gb_5d8ef71f209b44c2acab6343d6a5a05e']")));

        WebElement languageSelector = driver.findElement(By.cssSelector(("a[id='icp-nav-flyout']")));

        WebElement ordersMenu = driver.findElement(By.cssSelector(("a[id='nav-orders']")));

        WebElement shoppingCart = driver.findElement(By.cssSelector(("a[id='nav-cart']")));

        WebElement logoFooter = driver.findElement(By.cssSelector("div[class='nav-logo-base nav-sprite']"));

        WebElement privacyNotice = driver.findElement(By.cssSelector("a[href='/gp/help/customer/display.html?nodeId=468496&amp;ref_=footer_privacy']"));

        driver.quit();
    }
}