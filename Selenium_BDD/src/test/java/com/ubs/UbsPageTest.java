package com.ubs;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UbsPageTest {

    @Test
    public void UbsPageLocators() {
        System.setProperty("webdriver.chrome.driver", "chromedriver99.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ubs.com/ch/en.html");

        WebElement privacyAgreement = driver.findElement(By.cssSelector("button.privacysettings--singleStepElement span span span span[class='actionbutton__txtbody']"));
        privacyAgreement.click();

        WebElement accountLoginButton = driver.findElement(By.cssSelector(("button[id='headerLoginToggleButton']")));

        WebElement searchButton = driver.findElement(By.cssSelector(("button[aria-label='Search']")));

        WebElement countrySelectorLabel = driver.findElement(By.cssSelector(("li[aria-label='Select your language'] button[aria-label='Select your language']")));

        WebElement ubsLogo = driver.findElement(By.cssSelector(("span.logo__forcedWidth img.logo__img--default")));

        WebElement changingAddress = driver.findElement(By.cssSelector(("div.gridcontrol2__cell div.basecomponent div.linklist__context div.linklist__wrapper--doormat ul.linklist__list li.basecomponent a[href='/ch/en/help/my-data/change.html']")));

        WebElement careersMenu = driver.findElement(By.cssSelector(("div.gridcontrol2__cell div.basecomponent div.linklist__context div.linklist__wrapper--doormat ul.linklist__list li.basecomponent a[href='/global/en/careers.html']")));

        WebElement legalNotice = driver.findElement(By.cssSelector(("a[href='/global/en/legal/country/switzerland/legalnotices.html']")));

        driver.quit();
    }
}