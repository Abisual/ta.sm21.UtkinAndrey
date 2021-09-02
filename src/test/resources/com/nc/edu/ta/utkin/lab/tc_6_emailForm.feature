Feature: I can't register with wrong Email
  All user can't register with wrong Email

  Scenario Outline: I can't register with an Email without "@" symbol, without ".", with number after "." and "." at the end of line
    Given I am on "Register" page
    When I enter Login in "registerForm:username" field
    And I enter "Password2+" in "registerForm:password" field
    And I enter "Password2+" in "registerForm:confirmPassword" field
    And I enter "<Email>" in "registerForm:email" field
    And I select "Admin" in "registerForm:role" dropdown field
    And I press button "registerForm:j_idt26"
    Then I should get error "EmailError" near "EmailField"
    Examples:
      | Email |
      |userr1testmail.com|
      |userr1@testmailcom|
      |userr1@testmailcom.123|
      |userr1@testmail.com.  |
