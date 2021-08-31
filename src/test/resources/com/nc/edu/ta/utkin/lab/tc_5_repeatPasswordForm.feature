Feature: I can't register with different passwords
  All user can't register with different passwords

  Scenario: I can't register with different passwords
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "Password2+" in "registerForm:password" field
    And I enter "Pasword2+" in "registerForm:confirmPassword" field
    And I enter "userr1@testmail.com" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get error "PasswordMatchError" near "PasswordField"