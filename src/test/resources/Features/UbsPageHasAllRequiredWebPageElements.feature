Feature: UBS page has all the required web page elements

  Scenario Outline: Verify all web-elements are present on UBS home page
    Given user is on UBS home page
    Then  web Element "<web element>" is present on a page
    And browser is being closed
    Examples:
      | web element          |
      | accountLoginButton   |
      | searchButton         |
      | countrySelectorLabel |
      | ubsLogo              |
      | changingAddress      |
      | careersMenu          |
      | legalNotice          |