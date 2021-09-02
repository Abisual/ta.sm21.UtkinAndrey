Feature: I can see the description of the fields
  All users can see the description of the fields

  Scenario: I can see the description of the login field
    Given I am on "Register" page
    When I click on "UsernameDescription"
    Then I should get "InfoAboutUsername"
    
  Scenario: I can see the description of the password field
    Given I am on "Register" page
    When I click on "PasswordDescription"
    Then I should get "InfoAboutPassword"

  Scenario: I can see the description of the password field
    Given I am on "Register" page
    When I click on "RepeatPasswordDescription"
    Then I should get "InfoAboutRepeatPassword"

  Scenario: I can see the description of the password field
    Given I am on "Register" page
    When I click on "EmailDescription"
    Then I should get "InfoAboutEmail"

  Scenario: I can see the description of the password field
    Given I am on "Register" page
    When I click on "RoleDescription"
    Then I should get "InfoAboutRole"
