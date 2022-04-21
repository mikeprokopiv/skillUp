package stepDefinition.com.automationpractice;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPracticePageStepsDefinition {
    WebDriver driver;

    @Given("user is on Automation practice home page")
    public void userIsOnAutomationPracticeHomePage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver99.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @When("user clicks on T-SHIRT tab in top bar")
    public void userClicksOnTSHIRTTabInTopBar() {
        driver.findElement(By.xpath("//ul[@class]/li/a[@title='T-shirts']")).click();
    }

    @Then("he will be redirected to T-SHIRT web page")
    public void heWillBeRedirectedToTSHIRTWebPage() {
        driver.findElements(By.xpath("//span[@class='cat-name']"));
    }


    @And("T-SHIRT web page loads successfully")
    public void tSHIRTWebPageLoadsSuccessfully() {
        if (driver.findElements(By.xpath("//span[@class='cat-name']")).size() == 1) {
            System.out.println("Element exists, test pass");
        } else {
            System.out.println("Element can not be found, test fails");
        }

        driver.quit();
    }

    @When("user clicks on Dresses tab in a top bar")
    public void userClicksOnDressesTabInATopBar() {
        driver.findElement(By.xpath("//div[@id='block_top_menu']/ul[@class]/li/a[@title='Dresses']")).click();
    }

    @Then("he will be redirected to Dresses page")
    public void heWillBeRedirectedToDressesPage() {
        driver.findElements(By.xpath("//div[@class='product-image-container']"));
    }

    @And("Dresses web page loads successfully")
    public void dressesWebPageLoadsSuccessfully() {
        driver.findElement(By.xpath("//span[@class='heading-counter']"));
    }

    @And("each item has an image and price")
    public void eachItemHasAnImageAndPrice() {
        int countDressesImg = driver.findElements(By.xpath("//div[@class='product-image-container']")).size();

        int expectedResultsCount;
        if (driver.findElement(By.xpath("//span[@class='heading-counter']")).getText().charAt(11) == ' ') {
            expectedResultsCount = Integer.parseInt(driver.findElement(By.xpath("//span[@class='heading-counter']")).getText().substring(10, 11));
        } else {
            expectedResultsCount = Integer.parseInt(driver.findElement(By.xpath("//span[@class='heading-counter']")).getText().substring(10, 12));
        }

        int countElementsWithPrice = driver.findElements(By.xpath("//div[@class='right-block']/div[@class='content_price']/span[@itemprop='price']")).size();

        if (expectedResultsCount == countDressesImg && expectedResultsCount == countElementsWithPrice) {
            System.out.println("All the images and prices are present, test pass");
        } else
            System.out.println("there are discrepancy between actual and expected img qty and/or prices, test failed");
        driver.quit();
    }
}
