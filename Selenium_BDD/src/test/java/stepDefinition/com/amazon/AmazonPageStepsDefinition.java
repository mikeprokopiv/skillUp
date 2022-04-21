package stepDefinition.com.amazon;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPageStepsDefinition {
    WebDriver driver;

    @Given("user is on Amazon home page")
    public void user_is_on_home_page() {
        System.setProperty("webdriver.chrome.driver", "chromedriver99.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
    }

    @Then("Today's deal web element is present")
    public void today_s_deal_web_element_is_present() {
        driver.findElement(By.xpath(("//div[@id='nav-xshop']/a[@href='/gp/goldbox?ref_=nav_cs_gb']")));
    }

    @And("Language selector web element is present")
    public void language_selector_web_element_is_present() {
        driver.findElement(By.cssSelector(("a[id='icp-nav-flyout']")));
    }

    @And("Orders menu web element is present")
    public void orders_menu_web_element_is_present() {
        driver.findElement(By.cssSelector(("a[id='nav-orders']")));
    }

    @And("Shopping card web element is present")
    public void shopping_card_web_element_is_present() {
        driver.findElement(By.cssSelector(("a[id='nav-cart']")));
    }

    @And("Footer logo web element is present")
    public void footer_logo_web_element_is_present() {
        driver.findElement(By.cssSelector("div[class='nav-logo-base nav-sprite']"));
    }

    @And("Privacy note web element is present")
    public void privacy_note_web_element_is_present() {
        driver.findElement(By.xpath("//div/ul/li/a[@href='/gp/help/customer/display.html?nodeId=468496&ref_=footer_privacy']"));
        driver.quit();
    }
}
