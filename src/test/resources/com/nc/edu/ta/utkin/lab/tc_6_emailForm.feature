Feature: I can't register with wrong Email
  All user can't register with wrong Email

  Scenario: I can't register with an Email without "@" symbol, without ".", with number after "." and "." at the end of line
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "Password2+" in "registerForm:password" field
    And I enter "Password2+" in "registerForm:confirmPassword" field
    And I enter "userr1testmail.com" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get error "EmailError" near "EmailField"

  Scenario: I can't register with an Email without "."
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "Password2+" in "registerForm:password" field
    And I enter "Password2+" in "registerForm:confirmPassword" field
    And I enter "userr1@testmailcom" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get error "EmailError" near "EmailField"

  Scenario: I can't register with an Email with number after "."
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "Password2+" in "registerForm:password" field
    And I enter "Password2+" in "registerForm:confirmPassword" field
    And I enter "userr1testmailcom.123" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get error "EmailError" near "EmailField"

  Scenario: I can't register with an Email with "." at the end of line
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "Password2+" in "registerForm:password" field
    And I enter "Password2+" in "registerForm:confirmPassword" field
    And I enter "userr1testmail.com." in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get error "EmailError" near "EmailField"

