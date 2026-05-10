Feature: Login Feature
  @happyScenarios
  Scenario: Login with valid credentials
    Given User is on login page
    When User enters valid email and password
    Then User should be logged in successfully



#
#  Scenario: Login with invalid credentials
#    Given User is on login page
#    When User enters in-valid username and password
#    Then User shouldn't be logged in successfully
#
#
#  Scenario Outline: pla pla pla
#    Given User is on login page
#    When try with wrong "<username>" and "<password>"
#    Then User shouldn't be logged in successfully
#
#
#    Examples:
#    | username | password |
#    | ali      | 1234     |
#    | tomsmith | SuperSecretPassword!|