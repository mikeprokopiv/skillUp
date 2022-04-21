package com.automationpractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DressesSubMenuTest {

    @Test
    @DisplayName("Verify Dresses tab has correct sub-menu items")
    public void dressesSubMenu() {
        System.setProperty("webdriver.chrome.driver", "chromedriver99.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        WebElement dressesTab = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul[@class]/li/a[@title='Dresses']"));
        new Actions(driver).moveToElement(dressesTab).perform();

        driver.findElement(By.xpath("//ul[contains(@style,'display: block;')]/li/a[@title='Casual Dresses']"));
        driver.findElement(By.xpath("//ul[contains(@style,'display: block;')]/li/a[@title='Evening Dresses']"));
        driver.findElement(By.xpath("//ul[contains(@style,'display: block;')]/li/a[@title='Summer Dresses']"));

        driver.quit();
    }
}