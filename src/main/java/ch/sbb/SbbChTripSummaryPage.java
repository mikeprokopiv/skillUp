package ch.sbb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SbbChTripSummaryPage {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 60);


    public SbbChTripSummaryPage(WebDriver driver) {
        this.driver = driver;
    }




//    int priceWithoutDiscount = Integer.parseInt(driver.findElement(By.xpath("//*/li/p[@class='mod_dates_summation_box_ticket_price']")).getText().substring(4, 6));
//
//    //5. Verify that the price is bigger than w/Halbtax
//        driver.findElement(By.xpath("//*/button[@id='buttonEditPassenger']")).click();
//    //TODO look for more sophisticated way to wait for particular element to be loaded/present on a page
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@data-traveler='birth_date']")).click();
//        driver.findElement(By.xpath("//input[@data-traveler='birth_date']")).sendKeys(Keys.TAB);
//        wait.until(ExpectedConditions.attributeToBe(By.xpath("//*/div[contains(@style, 'display: none;') and @id='j_idt1264_blocker']"), "display", "none"));
//        driver.findElement(By.xpath("//button[contains(@id, 'abonnement')]/span[@class='mod_multiselect_icon']")).click();
//        driver.findElement(By.xpath("//div/div/div/input[@value='HTA123']")).click();
//        driver.findElement(By.xpath("//button[@id='buttonAcceptPassenger']")).click();
//    //TODO look for more sophisticated way to wait for particular element to be loaded/present on a page
//        Thread.sleep(2000);
//    int priceWithDiscount = Integer.parseInt(driver.findElement(By.xpath("//*/li/p[@class='mod_dates_summation_box_ticket_price']")).getText().substring(4, 6));
//        Assertions.assertTrue(priceWithDiscount < priceWithoutDiscount);
//
//    //6. Verify the connection details are as expected(price, departure time, from and to stations)
//        Assertions.assertEquals("Zürich HB", driver.findElement(By.xpath("//*/h1/span[contains (@class, 'origin_destination')]")).getText().substring(13, 22));
//        Assertions.assertEquals("Genève", driver.findElement(By.xpath("//*/h1/span[contains (@class, 'target_destination')]")).getText().substring(5, 11));
//        Assertions.assertEquals(tomorrowsDate, driver.findElement(By.xpath("//*/li/p[contains(@class, 'ticket_date')]")).getText().substring(13, 23));
//        Assertions.assertEquals(trainDepartureTime, driver.findElement(By.xpath("//*/li/p[contains(@class, 'ticket_date')]")).getText().substring(27, 32));
//        Assertions.assertEquals(trainArrivalTime, driver.findElement(By.xpath("//*/li/p[contains(@class, 'ticket_validity')]")).getText().substring(20, 25));
//        Assertions.assertEquals("John Smith", driver.findElement(By.xpath("//*/div/ol[contains(@class,'travelers_list')]")).getText().substring(0, 10));
//        Assertions.assertEquals("Halbtax", driver.findElement(By.xpath("//*/span[@class='traveler_discounts']")).getText());
//
//        driver.quit();


}
