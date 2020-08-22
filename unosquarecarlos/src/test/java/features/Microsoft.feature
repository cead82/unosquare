Feature: Create user on IMDb Web Page

  Scenario: Validate al menu items are present
    Then I validate all menu items are present

  Scenario: Verify Visual Studio prices
    When I print all elements in Windows10 menu
    And Search Visual Studio
    ##And I choose the first item
    ##Then I validate the price
