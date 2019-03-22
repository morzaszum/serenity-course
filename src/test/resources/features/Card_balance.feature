Feature: Card balance

  Scenario: Card user can check his debit card balance

    Given Carl is a debit card user with active account
    And he is logged in his account
    When Carl checks his card balance
    Then correct balance is presented

  Scenario: Card user can check his credit card balance
    Given Adam is a credit card user with active account
    And he is logged in his account
    When Adam checks his card balance
    Then correct balance is presented