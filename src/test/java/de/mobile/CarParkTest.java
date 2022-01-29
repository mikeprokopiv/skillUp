package de.mobile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CarParkTest {

    WebDriver driver;
    MobileDeHomePage mobileDeHomePage;
    MobileDeSearchResultsPage mobileDeSearchResultsPage;
    LowestPriceCarPage lowestPriceCarPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.mobile.de/");
        driver.manage().window().maximize();
    }


    @Test
    public void verifyCarWithLowestPriceCanBeParked() {
        mobileDeHomePage = new MobileDeHomePage(driver);
        mobileDeSearchResultsPage = new MobileDeSearchResultsPage(driver);
        lowestPriceCarPage = new LowestPriceCarPage(driver);

        mobileDeHomePage.acceptCookies();
        mobileDeHomePage.setLanguageToEnglish();
        assertEquals("Germany's biggest vehicle marketplace", mobileDeHomePage.pageHeaderText());
        mobileDeHomePage.setSearchedCarParameters();
        assertEquals("Volkswagen", mobileDeHomePage.getCarMake());
        assertEquals("Tiguan", mobileDeHomePage.getCarModel());
        assertEquals("50000", mobileDeHomePage.getCarPrice());
        assertEquals("2020", mobileDeHomePage.getCarRegistrationDateFrom());
        mobileDeHomePage.clickCarSearchButton();

        assertTrue(mobileDeSearchResultsPage.isSearchResultsDisplayed());
        mobileDeSearchResultsPage.sortResultsFromLowToHighPrice();
        assertTrue(mobileDeSearchResultsPage.isSearchResultsSorted());
        mobileDeSearchResultsPage.selectLowestPriceOffer();

        assertTrue(lowestPriceCarPage.isTechnicalSpecificationDisplayed());
        lowestPriceCarPage.addOfferToParkCar();
        assertTrue(lowestPriceCarPage.isCarParked());
        lowestPriceCarPage.navigateToCarParkPage();
        assertTrue(lowestPriceCarPage.isOfferParked());
    }

    @After
    public void terminateBrowser() {
        driver.close();
    }

}
