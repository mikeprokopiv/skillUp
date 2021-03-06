package ch.sbb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TrainTicketTest {

    @Test
    @DisplayName("Verify train ticket booking without any discount")
    public void trainTicket() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, 60);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        String tomorrowsDate = new SimpleDateFormat("dd.MM.yyyy").format(c.getTime());

        //1. Open http://sbb.ch website
        driver.get("https://www.sbb.ch/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*/button[@id='onetrust-accept-btn-handler']")).click();


        //2. Search for an inland train connection in the future(e.g. Zurich-Geneva tomorrow)
        driver.findElement(By.xpath("//div[@class='mod_textfield mod_timetable_input_form_gpsinput']/div[@class='mod_textfield_container']/input[@id='fromField']")).sendKeys("Zürich HB");
        driver.findElement(By.xpath("//div[@class='mod_textfield mod_timetable_input_form_gpsinput']/div[@class='mod_textfield_container']/input[@id='toField']")).sendKeys("Genève");
        driver.findElement(By.xpath("//button[@data-datepicker='button_next_day']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'mod_timetable_input_form_buttonwrapper')]/button[@data-sit-component='primary button']")).click();

        //3. Select the second search result
        List<WebElement> searchedResult = driver.findElements(By.xpath("//button[contains(@class, 'mod_timetable_buy_button')]"));
        List<WebElement> departureTimes = driver.findElements(By.xpath("//*/div[@class='mod_timetable_starttime']/span"));
        List<WebElement> arrivalTimes = driver.findElements(By.xpath("//*/div[@class='mod_timetable_endtime']/span"));
        searchedResult.get(1).click();
        String trainDepartureTime = departureTimes.get(1).getText();
        String trainArrivalTime = arrivalTimes.get(1).getText();

        //4. Fill in the details form w/ no discounts
//        wait.until(ExpectedConditions.textToBe(By.xpath("//*/div/h1[@class='mod_pagetitle']"), "Anmelden und profitieren."));
        driver.findElement(By.xpath("//button[@id='loginAsGuestButton']")).click();
//        wait.until(ExpectedConditions.attributeToBe(By.xpath("//input[@data-parsley-reisender_name='Vorname']"), "aria-invalid", "false"));
        driver.findElement(By.xpath("//input[@data-parsley-reisender_name='Vorname']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@data-parsley-reisender_name='Name']")).sendKeys("Smith");
        driver.findElement(By.xpath("//input[@data-traveler='birth_date']")).sendKeys("01.01.2004");
        driver.findElement(By.xpath("//input[@data-traveler='birth_date']")).sendKeys(Keys.TAB);
//        wait.until(ExpectedConditions.attributeToBe(By.xpath("//*/div[contains(@style, 'display: none;') and @id='j_idt1264_blocker']"), "display", "none"));
        driver.findElement(By.xpath("//button[contains(@id, 'abonnement')]/span[@class='mod_multiselect_icon']")).click();
        driver.findElement(By.xpath("//div[@aria-hidden='false']/div/div/input[@value='KEINE']")).click();
        driver.findElement(By.xpath("//button[@id='buttonAcceptPassenger']")).click();
        //TODO look for more sophisticated way to wait for particular element to be loaded/present on a page
        Thread.sleep(2000);
        int priceWithoutDiscount = Integer.parseInt(driver.findElement(By.xpath("//*/li/p[@class='mod_dates_summation_box_ticket_price']")).getText().substring(4, 6));

        //5. Verify that the price is bigger than w/Halbtax
        driver.findElement(By.xpath("//*/button[@id='buttonEditPassenger']")).click();
        //TODO look for more sophisticated way to wait for particular element to be loaded/present on a page
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@data-traveler='birth_date']")).click();
        driver.findElement(By.xpath("//input[@data-traveler='birth_date']")).sendKeys(Keys.TAB);
//        wait.until(ExpectedConditions.attributeToBe(By.xpath("//*/div[contains(@style, 'display: none;') and @id='j_idt1264_blocker']"), "display", "none"));
        driver.findElement(By.xpath("//button[contains(@id, 'abonnement')]/span[@class='mod_multiselect_icon']")).click();
        driver.findElement(By.xpath("//div/div/div/input[@value='HTA123']")).click();
        driver.findElement(By.xpath("//button[@id='buttonAcceptPassenger']")).click();
        //TODO look for more sophisticated way to wait for particular element to be loaded/present on a page
        Thread.sleep(2000);
        int priceWithDiscount = Integer.parseInt(driver.findElement(By.xpath("//*/li/p[@class='mod_dates_summation_box_ticket_price']")).getText().substring(4, 6));
        Assertions.assertTrue(priceWithDiscount < priceWithoutDiscount);

        //6. Verify the connection details are as expected(price, departure time, from and to stations)
        Assertions.assertEquals("Zürich HB", driver.findElement(By.xpath("//*/h1/span[contains (@class, 'origin_destination')]")).getText().substring(13, 22));
        Assertions.assertEquals("Genève", driver.findElement(By.xpath("//*/h1/span[contains (@class, 'target_destination')]")).getText().substring(5, 11));
        Assertions.assertEquals(tomorrowsDate, driver.findElement(By.xpath("//*/li/p[contains(@class, 'ticket_date')]")).getText().substring(13, 23));
        Assertions.assertEquals(trainDepartureTime, driver.findElement(By.xpath("//*/li/p[contains(@class, 'ticket_date')]")).getText().substring(27, 32));
        Assertions.assertEquals(trainArrivalTime, driver.findElement(By.xpath("//*/li/p[contains(@class, 'ticket_validity')]")).getText().substring(20, 25));
        Assertions.assertEquals("John Smith", driver.findElement(By.xpath("//*/div/ol[contains(@class,'travelers_list')]")).getText().substring(0, 10));
        Assertions.assertEquals("Halbtax", driver.findElement(By.xpath("//*/span[@class='traveler_discounts']")).getText());

        driver.quit();
    }
}