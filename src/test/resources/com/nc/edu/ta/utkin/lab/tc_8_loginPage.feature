Feature: I can login to site
  All users can login to site

  Scenario: I can login to site with valid data
    Given I am on "Login" page
    When I enter "TestUser123" in "j_username"
    And I enter "Password2+" in "j_password" field
    And I press button "submit"
    Then I should get a page "Startpage"

  Scenario:  I can't login to site with invalid data
    Given I am on "Login" page
    When I enter "TestUser" in "j_username"
    And I enter "Password2+" in "j_password" field
    And I press button "submit"
    Then I should get a page "LoginError"