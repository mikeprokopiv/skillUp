package com.epam;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCart {

    @Test
    @DisplayName("Verify shopping cart is empty & summary steps are displayed")

    public void dressesCount() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        driver.findElement(By.xpath("//div/a[@title='View my shopping cart']")).click();
        Assertions.assertEquals("Your shopping cart is empty.", driver.findElement(By.xpath("//div/p[contains (@class, 'alert-warning')]")).getText());

        driver.findElement(By.xpath("//ul/li[contains (@class, 'first')]"));
        driver.findElement(By.xpath("//ul/li[contains (@class, 'second')]"));
        driver.findElement(By.xpath("//ul/li[contains (@class, 'third')]"));
        driver.findElement(By.xpath("//ul/li[contains (@class, 'four')]"));
        driver.findElement(By.xpath("//ul/li[contains (@class, 'last')]"));

        driver.quit();
    }
}