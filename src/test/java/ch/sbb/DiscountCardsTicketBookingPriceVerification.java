package ch.sbb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DiscountCardsTicketBookingPriceVerification {
    WebDriver driver;
    SbbChHomePage sbbChHomePage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        String tomorrowsDate = new SimpleDateFormat("dd.MM.yyyy").format(c.getTime());
    }

    @Test
    public void verifyCarWithLowestPriceCanBeParked() {


    }

    @After
    public void terminateBrowser() {
        driver.close();
    }
}


