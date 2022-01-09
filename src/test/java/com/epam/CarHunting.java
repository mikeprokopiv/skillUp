package com.epam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarHunting {

    @Test @DisplayName("Verify car with lowest price was parked")
    public void carHunting() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //1. Open http://www.mobile.de website
        driver.get("https://www.mobile.de/");
        //Accept cookies
        driver.findElement(By.xpath("//button[contains (@class, 'mde-consent-accept-btn')]")).click();
        //2. Change the language to English
        driver.findElement(By.xpath("//span[@data-se='header-meta-action-toggle__language']")).click();
        driver.findElement(By.xpath("//ul[@aria-hidden='false']/li/a[@data-se='header-meta-action-toggle__language-en']")).click();
        //3. Search for a car using: "Make, Model, Price up to, 1st registration form" criteria
        driver.findElement(By.xpath("//select[@id='qsmakeBuy']/option[@value='25200']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//select[@id='qsmodelBuy']/option[@value='54']")).click();
        driver.findElement(By.xpath("//div[@id='qsprcwrp']/div/select/option[@value='50000']")).click();
        driver.findElement(By.xpath("//div[@id='qsfrgwrp']/div/select/option[@value='2018']")).click();
        //click search button
        driver.findElement(By.xpath("//button[@id='qssub']")).click();
        //4. Verify that the search results list is displayed
        driver.findElement(By.xpath("//h1[@data-testid='result-list-headline']"));
        //5. Sort results list by price ascending
        driver.findElement(By.xpath("//select[@id='so-sb']/option[@value='p-up']")).click();
        //6. Check that the results list is ordered accordingly
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='h3 u-block']"));
        int firstAdv = Integer.parseInt(prices.get(1).getText().replace(",", "").substring(1, 6));
        int secondAdv = Integer.parseInt(prices.get(2).getText().replace(",", "").substring(1, 6));
        int thirdAdv = Integer.parseInt(prices.get(3).getText().replace(",", "").substring(1, 6));
        if (firstAdv <= secondAdv) {
            boolean correctSort = secondAdv <= thirdAdv;
            Assertions.assertTrue(correctSort);
        }
        //7. Click on the item with the lowest price
        prices.get(1).click();
        //8. Verify the Technical specifications panel displayed
        driver.findElement(By.xpath("//div[@id='td-box']"));
        //9. "Park" the advertisement
        driver.findElement(By.xpath("//span[@id='park-link-top']")).click();
        Assertions.assertEquals("(1)", driver.findElement(By.xpath("//span[@class='header-meta-action-counter']")).getText());
        //10. Go to the 'Car park'
        driver.findElement(By.xpath("//a[@id='hdmysc2']")).click();
        //11. Verify that the saved advertisement is in the 'Car park'
        int priceParkedCar = Integer.parseInt(driver.findElement(By.xpath("//div[@class='parking__currentPrice']")).getText().replace(",", "").substring(1, 6));
        Assertions.assertEquals(firstAdv, priceParkedCar);

        driver.quit();
    }
}