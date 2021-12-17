package com.epam;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ShirtPageTest {
    private final WebDriver driver = new ChromeDriver();

    @Test
    public void ShirtPageNavigation() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("http://automationpractice.com/index.php");

        WebElement shirt = driver.findElement(By.xpath("//ul[@class]/li/a[@title='T-shirts']"));
        shirt.click();

        if (driver.findElements(By.xpath("//span[@class='cat-name']")).size() == 1) {
            System.out.println("Element exists, test pass");
        } else {
            System.out.println("Element can not be found, test fails");
        }

        driver.quit();
    }
}

