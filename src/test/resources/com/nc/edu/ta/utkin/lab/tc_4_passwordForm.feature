Feature: I can't register with wrong password
  All user can't register with wrong password

  Scenario Outline: I can't register with a password less than 8 characters, without numbers, without lowercase and capital letters
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "<Password>" in "registerForm:password" field
    And I enter "<Password>" in "registerForm:confirmPassword" field
    And I enter "userr1@testmail.com" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get error "<PasswordError>" near "PasswordField"
    Examples:
      | Password | PasswordError|
      |Psswd2+   | PasswordLengthError|
      |Password+ | PasswordNumError   |
      |PASSWORD2+| PasswordLowError   |
      |password2+| PasswordCapError   |

