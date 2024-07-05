Feature: Login
  Scenario: Login realizado com sucesso
    Given User is on Login Page
    When User enter the correct name in Name Field
    And User enter the correct password in Password Field
    And User click in the Login Button
    Then User should be redirectioned to Safe Space Page

  Scenario: Login Falhou
    Given User is on Login Page
    When User enter the correct name in Name Field
    And User enter a wrong password in Password Field
    And User click in the Login Button
    Then User should not be able to pass out