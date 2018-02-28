Feature: Account

  Scenario: Deposit some Money
    Given i have a new account
    When i make a deposit of 1000 at the date of 2012-01-10
    And make a deposit of 2000 at the date of 2012-01-13
    And a withdrawal of 500  at the date of 2012-01-14
    Then i should have a statement like this "date || credit || debit || balance""2012-01-14 || || 500.00 || 2500.00""2012-01-13 || 2000.00 || || 3000.00""2012-01-10 || 1000.00 || || 1000.00"