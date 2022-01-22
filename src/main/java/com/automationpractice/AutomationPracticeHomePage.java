package com.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomationPracticeHomePage {
    WebDriver driver;
By searchButton = By.xpath("//form/input[contains (@class, 'search_query')]");
By submitButton = By.xpath("//button[@name='submit_search']");



    public AutomationPracticeHomePage(WebDriver driver) {
        this.driver = driver;
    }



}
