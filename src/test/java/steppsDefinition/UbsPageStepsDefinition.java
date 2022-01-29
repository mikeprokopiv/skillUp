package steppsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UbsPageStepsDefinition {
    WebDriver driver;

    @Given("user is on UBS home page")
    public void userIsOnUBSHomePage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.ubs.com/ch/en.html");
    }

    @Then("web Element {string} is present on a page")
    public void webElementIsPresentOnAPage(String arg0) {
        driver.findElement(By.cssSelector(("button[id='headerLoginToggleButton']")));
        driver.findElement(By.cssSelector(("button[aria-label='Search']")));
        driver.findElement(By.cssSelector(("li[aria-label='Select your language'] button[aria-label='Select your language']")));
        driver.findElement(By.cssSelector(("span.logo__forcedWidth img.logo__img--default")));
        driver.findElement(By.cssSelector(("div.gridcontrol2__cell div.basecomponent div.linklist__context div.linklist__wrapper--doormat ul.linklist__list li.basecomponent a[href='/ch/en/help/my-data/change.html']")));
        driver.findElement(By.cssSelector(("div.gridcontrol2__cell div.basecomponent div.linklist__context div.linklist__wrapper--doormat ul.linklist__list li.basecomponent a[href='/global/en/careers.html']")));
        driver.findElement(By.cssSelector(("a[href='/global/en/legal/country/switzerland/legalnotices.html']")));
    }

    @And("browser is being closed")
    public void browserIsBeingClosed() {
        driver.close();
    }
}
