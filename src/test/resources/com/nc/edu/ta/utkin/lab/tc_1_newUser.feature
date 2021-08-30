Feature: I can register on site
    All user can register on site

  Scenario: I can register on site with valid data
    Given I am on "Registration" page
    When I enter "LoginData" in "registerForm:username" field
    And I enter "PasswordData" in "registerForm:password" field
    And I enter "PasswordData" in "registerForm:confirmPassword" field
    And I enter "EmailData" in "registerForm:email" field
    And I select "Role" in "registerForm:role" dropdown field
    And I press button "Registration"
    Then I should get a message "New user has been registered."
