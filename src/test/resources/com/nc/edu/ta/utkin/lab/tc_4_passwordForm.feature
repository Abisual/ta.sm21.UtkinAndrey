Feature: I can't register with wrong password
  All user can't register with wrong password

  Scenario: I can't register with a password less than 8 characters
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "Pwrd2+" in "registerForm:password" field
    And I enter "Pwrd2+" in "registerForm:confirmPassword" field
    And I enter "userr1@testmail.com" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get error "PasswordLengthError" near "PasswordField"

  Scenario: I can't register with a password without numbers
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "Password+" in "registerForm:password" field
    And I enter "Password+" in "registerForm:confirmPassword" field
    And I enter "userr1@testmail.com" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get error "PasswordNumError" near "PasswordField"

  Scenario: I can't register with a password without lowercase letters
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "PASSWORD2+" in "registerForm:password" field
    And I enter "PASSWORD2+" in "registerForm:confirmPassword" field
    And I enter "userr1@testmail.com" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get error "PasswordLowError" near "PasswordField"

  Scenario: I can't register with a password without capital letters
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "password2+" in "registerForm:password" field
    And I enter "password2+" in "registerForm:confirmPassword" field
    And I enter "userr1@testmail.com" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get error "PasswordCapError" near "PasswordField"