package de.mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VerifyCarCanBeParkedStepsDefinition {

    WebDriver driver = new ChromeDriver();
    MobileDeHomePage mobileDeHomePage = new MobileDeHomePage(driver);
    MobileDeSearchResultsPage mobileDeSearchResultsPage = new MobileDeSearchResultsPage(driver);
    LowestPriceCarPage lowestPriceCarPage = new LowestPriceCarPage(driver);

    @Given("user is on mobile.de home page")
    public void user_is_on_mobile_de_home_page() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("https://www.mobile.de/");
        driver.manage().window().maximize();
    }

    @Given("Cookies are accepted")
    public void cookies_are_accepted() {
        mobileDeHomePage.acceptCookies();
    }

    @When("user changes language from German to English")
    public void user_changes_language_from_german_to_english() {
        mobileDeHomePage.setLanguageToEnglish();
    }

    @Then("page header is changed to {string}")
    public void page_header_is_changed_to(String string) {
        assertEquals("Germany's biggest vehicle marketplace", mobileDeHomePage.pageHeaderText());
    }

    @Then("Car Make is set to {string}")
    public void car_make_is_set_to(String string) {
        mobileDeHomePage.setCarMake();
        assertEquals("Volkswagen", mobileDeHomePage.getCarMake());
    }

    @Then("Car Model is set to {string}")
    public void car_model_is_set_to(String string) {
        mobileDeHomePage.setCarModel();
        assertEquals("Tiguan", mobileDeHomePage.getCarModel());
    }

    @Then("Car Price is set up to {int} EUR")
    public void car_price_is_set_up_to_eur(Integer int1) {
        mobileDeHomePage.setCarPrice();
        assertEquals("50000", mobileDeHomePage.getCarPrice());
    }

    @Then("Can Registration Date is from {int}")
    public void can_registration_date_is_from(Integer int1) {
        mobileDeHomePage.setCarRegistrationDateFrom();
        assertEquals("2020", mobileDeHomePage.getCarRegistrationDateFrom());
    }

    @Then("user clicks {string} button")
    public void user_clicks_button(String string) {
        mobileDeHomePage.clickCarSearchButton();
    }

    @When("user is on a Search Results page")
    public void user_is_on_a_search_results_page() {
        assertTrue(mobileDeSearchResultsPage.isSearchResultsDisplayed());
    }

    @Then("he sorts the result by price in acs order")
    public void he_sorts_the_result_by_price_in_acs_order() {
        mobileDeSearchResultsPage.sortResultsFromLowToHighPrice();
    }

    @Then("Car offers are sorted accordingly")
    public void car_offers_are_sorted_accordingly() {
        assertTrue(mobileDeSearchResultsPage.isSearchResultsSorted());
    }

    @Then("user select the offer with a lowest price")
    public void user_select_the_offer_with_a_lowest_price() {
        mobileDeSearchResultsPage.selectLowestPriceOffer();
    }

    @Then("on a offered car page Technical Specification is displayed")
    public void on_a_offered_car_page_technical_specification_is_displayed() {
        assertTrue(lowestPriceCarPage.isTechnicalSpecificationDisplayed());
    }

    @Then("user click on Park button")
    public void user_click_on_park_button() {
        lowestPriceCarPage.addOfferToParkCar();
    }

    @Then("Qty of Parked cars increments by {int}")
    public void qty_of_parked_cars_increments_by(Integer int1) {
        assertTrue(lowestPriceCarPage.isCarParked());
    }

    @Then("user navigates to Car park")
    public void user_navigates_to_car_park() {
        lowestPriceCarPage.navigateToCarParkPage();
    }

    @Then("selected car is displayed")
    public void selected_car_is_displayed() {
        assertTrue(lowestPriceCarPage.isOfferParked());
    }

    @And("browser is closed")
    public void browserIsClosed() {
        driver.close();
    }

}
