package com.epam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MobileCategoriesList {

    @Test
    @DisplayName("Verify Categories list is active(expanded) in when web page is in mobile size")
    public void mobileCategoriesList() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        Dimension d = new Dimension(480, 620);
        driver.manage().window().setSize(d);
        driver.findElement(By.xpath("//header/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/div[@class='cat-title']")).click();

        //to verify is the list is active we are checking style attribute. If it has value block == active if none == non active
        driver.findElement(By.xpath("//header/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[contains(@style, 'display: block;')]"));

        driver.quit();
    }
}