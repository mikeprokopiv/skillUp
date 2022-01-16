package com.epam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TrainTicketTest {

    @Test
    @DisplayName("Verify train ticket booking without any discount")
    public void trainTicket() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //1. Open http://sbb.ch website
        driver.get("https://www.sbb.ch/");
        driver.manage().window().maximize();

        //2. Search for an inland train connection in the future(e.g. Zurich-Geneva tomorrow)
        driver.findElement(By.xpath("//div[@class='mod_textfield mod_timetable_input_form_gpsinput']/div[@class='mod_textfield_container']/input[@id='fromField']")).sendKeys("Zürich HB");
        driver.findElement(By.xpath("//div[@class='mod_textfield mod_timetable_input_form_gpsinput']/div[@class='mod_textfield_container']/input[@id='toField']")).sendKeys("Genève");
        driver.findElement(By.xpath("//button[@data-datepicker='button_next_day']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'mod_timetable_input_form_buttonwrapper')]/button[@data-sit-component='primary button']")).click();
        //3. Select the second search result
        List<WebElement> searchedResult = driver.findElements(By.xpath("//button[contains(@class, 'mod_timetable_buy_button')]"));
        searchedResult.get(1).click();
        //4. Fill in the details form w/ no discounts
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@id='loginAsGuestButton']")).click();
        driver.findElement(By.xpath("//input[@data-parsley-reisender_name='Vorname']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@data-parsley-reisender_name='Name']")).sendKeys("Smith");
        driver.findElement(By.xpath("//input[@data-traveler='birth_date']")).sendKeys("01.01.2004");

        driver.findElement(By.xpath("//button[contains(@id, 'abonnement')]/span[@class='mod_multiselect_icon']")).click();
        driver.findElement(By.xpath("//div[@aria-hidden='false']/div/div/input[@value='KEINE']")).click();
        driver.findElement(By.xpath("//button[@id='buttonAcceptPassenger']")).click();


        //5. Verify that the price is bigger than w/Halbtax
        //6. Verify the connection details are as expected(price, departure time, from and to stations)


//        driver.quit();
    }
}