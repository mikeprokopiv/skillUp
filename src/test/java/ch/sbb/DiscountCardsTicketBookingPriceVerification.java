package ch.sbb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class DiscountCardsTicketBookingPriceVerification {
    WebDriver driver;
    SbbChHomePage sbbChHomePage;
    SbbChSearchResultPage sbbChSearchResultPage;
    SbbChPassengerDetailsPage sbbChPassengerDetailsPage;
    SbbChTripSummaryPage sbbChTripSummaryPage;
    SbbChLoginPage sbbChLoginPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 60);
    }

    @Test
    public void verifyCarWithLowestPriceCanBeParked() {
        sbbChHomePage.navigateToSbbSite();
        sbbChHomePage.acceptCookies();
        sbbChHomePage.setDepartureStation();
        sbbChHomePage.setArrivalStationStation();
        sbbChHomePage.setTravelDateToNextDay();
        sbbChHomePage.clickConnectionSearchButton();

        sbbChSearchResultPage.getDepartureTime();
        sbbChSearchResultPage.getArrivalTime();
        sbbChSearchResultPage.getSearchResultsOption().get(1).click();

        sbbChLoginPage.waitForLoginPageToLoad();
        sbbChLoginPage.loginAsGuest();

        sbbChPassengerDetailsPage.setWaitForPassengerPageToBeLoaded();
        sbbChPassengerDetailsPage.setPassengerName();
        assertEquals("John", sbbChPassengerDetailsPage.getPassengerName());
        sbbChPassengerDetailsPage.setPassengerSurname();
        assertEquals("Smith", sbbChPassengerDetailsPage.getPassengerSurname());
        sbbChPassengerDetailsPage.setPassengerBirthDate();
        assertEquals("01.01.2004", sbbChPassengerDetailsPage.getPassengerBirthDate());
        sbbChPassengerDetailsPage.setWaitForDiscountCalculation();
        sbbChPassengerDetailsPage.setDiscountOptionToNone();
        sbbChPassengerDetailsPage.acceptPassenger();
//        Thread.sleep(2000);
        sbbChTripSummaryPage.priceWithoutDiscount();
        sbbChTripSummaryPage.editPassengerData();
//        Thread.sleep(1000);
        sbbChPassengerDetailsPage.setDiscountOptionToHalfTax();
        sbbChPassengerDetailsPage.acceptPassenger();
//        Thread.sleep(2000);
        sbbChTripSummaryPage.priceWithDiscount();

        Assertions.assertEquals(sbbChHomePage.getDepartureStation(), sbbChTripSummaryPage.getTripsDepartureStation());
        Assertions.assertEquals(sbbChHomePage.getArrivalStationStation(), sbbChTripSummaryPage.getTripsArrivalStation());
        Assertions.assertEquals(sbbChTripSummaryPage.tomorrowsDate(), sbbChTripSummaryPage.getTripTomorrowsDate());
        Assertions.assertEquals(sbbChSearchResultPage.getDepartureTime(), sbbChTripSummaryPage.getTripsDepartureTime());
        Assertions.assertEquals(sbbChSearchResultPage.getArrivalTime(), sbbChTripSummaryPage.getTripsArrivalTime());
        Assertions.assertEquals(sbbChPassengerDetailsPage.getPassengerName() + " " + sbbChPassengerDetailsPage.getPassengerSurname(), sbbChTripSummaryPage.getTripsPassengerNameAndSurname());
        Assertions.assertEquals(sbbChPassengerDetailsPage.getDiscountOptionChosen(), sbbChTripSummaryPage.getTaxOption());

    }

    @After
    public void terminateBrowser() {
        driver.close();
    }
}


