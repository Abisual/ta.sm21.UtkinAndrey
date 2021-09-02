Feature: I can see the description of the fields
  All users can see the description of the fields

  Scenario Outline: I can see the description of the login field
    Given I am on "Register" page
    When I click on "<Description>"
    Then I should get "<Information>"
    Examples:
      |Description              | Information             |
      |UsernameDescription      | InfoAboutUsername       |
      |PasswordDescription      | InfoAboutPassword       |
      |RepeatPasswordDescription| InfoAboutRepeatPassword |
      |EmailDescription         | InfoAboutEmail          |
      |RoleDescription          | InfoAboutRole           |

