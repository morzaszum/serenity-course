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

    Scenario: User tries to log in with incorrect credentials
      Given Helmut is a user with active account
      When he tries to login with incorrect credentials
      Then he is not logged in