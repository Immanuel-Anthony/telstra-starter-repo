Feature: Is the SIM card activated?

  Scenario: A SIM card can be activated
    Given A working sim card is given
    When Request sent to activate sim card
    Then Sim card should be activated

  Scenario: A SIM card can not be activated
    Given A non working sim card is given
    When Request sent to activate sim card
    Then Sim card should not be activated