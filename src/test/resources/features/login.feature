Feature: Login feature

  @Test
  Scenario: UI002.SuccessfulLogin
    When "aaa" and "aaa" are entered.

  @Test
  Scenario: UI003.UnsuccessfulLogin
    When "rgm44198@boofx.com" and "Test12345" are entered.

  @Test
  Scenario Outline: UI004.CheckPasswordWrong
    When "<username>" and "<password>" are entered.
    Then Error message is "<errorMessage>"
    Examples:
      | username             | password  | errorMessage                  |
      |                      |           | Invalid username or password. |
      | rgm44198@            |           | Invalid username or password. |
      | rgm441981@gmail.com  |           | Invalid username or password. |
      | rgm441981@gmai@l.com |           | Invalid username or password. |
      | rgm44198@gmail       |           | Invalid username or password. |
      | rgm44198@gmail.co    |           | Invalid username or password. |
      | rgm44198@gmail.co    | 1         | Invalid username or password. |
      | rgm44198@boofx.com   | Kaan12345 | Invalid username or password. |