Feature: I can't register with wrong Username
  All user can't register with wrong password

  Scenario: I can't register with a username only from numbers
    Given I am on "Register" page
    When I enter Numerical Login in "registerForm:username" field
    And I enter "Password2+" in "registerForm:password" field
    And I enter "Password2+" in "registerForm:confirmPassword" field
    And I enter "userr1@testmail.com" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get error "LoginError" near "LoginField"

  Scenario: I can't register with a username of less than 6 characters
    Given I am on "Register" page
    When I enter "us1r" in "registerForm:username" field
    And I enter "Password2+" in "registerForm:password" field
    And I enter "Password2+" in "registerForm:confirmPassword" field
    And I enter "userr1@testmail.com" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get error "LoginError" near "LoginField"