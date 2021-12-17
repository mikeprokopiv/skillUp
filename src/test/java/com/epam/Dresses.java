package com.epam;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dresses {

    @Test
    public void dressesCount() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        WebElement dressesTab = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul[@class]/li/a[@title='Dresses']"));
        dressesTab.click();

        int countDressesImg = driver.findElements(By.xpath("//div[@class='product-image-container']")).size();

        int expectedResultsCount;
        if (driver.findElement(By.xpath("//span[@class='heading-counter']")).getText().charAt(11) == ' ') {
            expectedResultsCount = Integer.parseInt(driver.findElement(By.xpath("//span[@class='heading-counter']")).getText().substring(10, 11));
        } else {
            expectedResultsCount = Integer.parseInt(driver.findElement(By.xpath("//span[@class='heading-counter']")).getText().substring(10, 12));
        }

        int countElementsWithPrice = driver.findElements(By.xpath("//div[@class='right-block']/div[@class='content_price']/span[@itemprop='price']")).size();

        if (expectedResultsCount == countDressesImg && expectedResultsCount == countElementsWithPrice) {
            System.out.println("All the images and prices are present, test pass");
        } else
            System.out.println("there are discrepancy between actual and expected img qty and/or prices, test failed");
        driver.quit();
    }
}