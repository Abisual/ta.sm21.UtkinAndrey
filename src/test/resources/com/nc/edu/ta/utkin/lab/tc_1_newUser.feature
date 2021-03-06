Feature: I can register on site
    All user can register on site

  Scenario: I can register on site with valid data
    Given I am on "Register" page
    When I enter "TestUser127" in "registerForm:username" field
    And I enter "Password2+" in "registerForm:password" field
    And I enter "Password2+" in "registerForm:confirmPassword" field
    And I enter "userr1@testmail.com" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get a page "SuccessfulRegistered"
