package com.amazon;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPageTest {

    @Test
    public void AmazonPageMailLocators() {
        System.setProperty("webdriver.chrome.driver", "chromedriver99.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        WebElement todayDeal = driver.findElement(By.xpath(("//div[@id='nav-xshop']/a[@href='/gp/goldbox?ref_=nav_cs_gb']")));

        WebElement languageSelector = driver.findElement(By.cssSelector(("a[id='icp-nav-flyout']")));

        WebElement ordersMenu = driver.findElement(By.cssSelector(("a[id='nav-orders']")));

        WebElement shoppingCart = driver.findElement(By.cssSelector(("a[id='nav-cart']")));

        WebElement logoFooter = driver.findElement(By.cssSelector("div[class='nav-logo-base nav-sprite']"));

        WebElement privacyNotice = driver.findElement(By.xpath("//div/ul/li/a[@href='/gp/help/customer/display.html?nodeId=468496&ref_=footer_privacy']"));

        driver.quit();
    }
}