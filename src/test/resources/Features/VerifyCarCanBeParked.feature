Feature: Car offer can be parked

  Scenario: Volkswagen Tiguan from 2020, up tp 50k with lowest price offer parked

    Given user is on mobile.de home page
    And Cookies are accepted
    When user changes language from German to English
    Then page header is changed to "Germany's biggest vehicle marketplace"
    And Car Make is set to "Volkswagen"
    And Car Model is set to "Tiguan"
    And Car Price is set up to 50000 EUR
    And Can Registration Date is from 2020
    Then user clicks "Search" button

    When user is on a Search Results page
    Then he sorts the result by price in acs order
    And Car offers are sorted accordingly
    And user select the offer with a lowest price

    Then on a offered car page Technical Specification is displayed
    And user click on Park button
    And Qty of Parked cars increments by 1

    Then user navigates to Car park
    And selected car is displayed

    And browser is closed