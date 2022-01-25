package de.mobile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void carParkTest() {
        mobileDeHomePage = new MobileDeHomePage(driver);
        mobileDeSearchResultsPage = new MobileDeSearchResultsPage(driver);
        lowestPriceCarPage = new LowestPriceCarPage(driver);
        mobileDeHomePage.getCookiesAccepted();
        mobileDeHomePage.setEnglishLanguage();
        mobileDeHomePage.searchForaCar();
        assertTrue(mobileDeSearchResultsPage.searchResultsIsDisplayed());
        mobileDeSearchResultsPage.sortResultsFromLowToHighPrice();
        assertTrue(mobileDeSearchResultsPage.searchResultsSortCheck());
        mobileDeSearchResultsPage.getLowestPriceOffer();
        assertTrue(lowestPriceCarPage.technicalSpecificationIsDisplayed());
        assertTrue(lowestPriceCarPage.parkCar());
        lowestPriceCarPage.goToCarPark();
        assertTrue(lowestPriceCarPage.offerIsParked());
    }


    @After
    public void terminateBrowser() {
        driver.close();
    }


}
