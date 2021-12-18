Feature: Automation practice page has all web elements loaded correctly

  Scenario: Verify T-Shirt web page is loaded correctly from Automation practice home page
    Given user is on Automation practice home page
    When user clicks on T-SHIRT tab in top bar
    Then he will be redirected to T-SHIRT web page
    And T-SHIRT web page loads successfully

  Scenario: Verify Dresses web page is loaded correctly from Automation practice home page
    Given user is on Automation practice home page
    When user clicks on Dresses tab in a top bar
    Then he will be redirected to Dresses page
    And Dresses web page loads successfully
    And each item has an image and price