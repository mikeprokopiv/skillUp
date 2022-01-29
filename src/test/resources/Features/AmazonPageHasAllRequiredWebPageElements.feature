Feature: Amazon page has all the required web page elements

  Scenario: Verify all web-elements are present on Amazon home page
    Given user is on Amazon home page
    Then Today's deal web element is present
    And Language selector web element is present
    And Orders menu web element is present
    And Shopping card web element is present
    And Footer logo web element is present
    And Privacy note web element is present
