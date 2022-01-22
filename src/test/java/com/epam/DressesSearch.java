package com.epam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DressesSearch {

    @Test
    @DisplayName("Verify corresponding dress details page showing after search")
    public void dressesSearch() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        driver.findElement(By.xpath("//form/input[contains (@class, 'search_query')]")).sendKeys("dresses");
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        String dressTitle = driver.findElement(By.xpath("//ul[contains (@class, 'product_list')]/li/div[@class='product-container']/div/h5/a")).getText();
        driver.findElement(By.xpath("//ul[contains (@class, 'product_list')]/li/div[@class='product-container']")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//div/div[@class='columns-container']/div/div[@class='row']/div[@id='center_column']/div/div/div/h1")).getText(), dressTitle);

        driver.quit();
    }
}