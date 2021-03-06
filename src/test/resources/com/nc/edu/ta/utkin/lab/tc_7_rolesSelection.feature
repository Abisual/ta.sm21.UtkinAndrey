Feature: I can register with different roles
  All user can register with different roles

  Scenario: I can register with Admin Role
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "Password2+" in "registerForm:password" field
    And I enter "Password2+" in "registerForm:confirmPassword" field
    And I enter "userr1@testmail.com" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get a page "SuccessfulRegistered"

  Scenario: I can register with Read Only Role
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "Password2+" in "registerForm:password" field
    And I enter "Password2+" in "registerForm:confirmPassword" field
    And I enter "userr1@testmail.com" in "registerForm:email" field
    And I select "RO" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get a page "SuccessfulRegistered"

  Scenario: I can register with Read/Write Role
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "Password2+" in "registerForm:password" field
    And I enter "Password2+" in "registerForm:confirmPassword" field
    And I enter "userr1@testmail.com" in "registerForm:email" field
    And I select "RW" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get a page "SuccessfulRegistered"