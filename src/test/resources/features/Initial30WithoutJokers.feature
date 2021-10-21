@initial30WithoutJokers
Feature: Initial 30 without Jokers

  Background:
    Given 3 players joined the game

  Scenario Outline: Initial 30 with 1 run
    Given player 1 has "<run>"
    And game starts
    When player 1 plays "<run>"
    And player 1 ends turn
    Then game status should be "<status>"
    Examples:
      | run            | status  |
      | R9 R10 R11     | invalid |
      | R10 R11 R12    | valid   |
      | R9 R10 R11 R12 | valid   |

  Scenario Outline: Initial 30 with 1 set
    Given player 1 has "<set>"
    And game starts
    When player 1 plays "<set>"
    And player 1 ends turn
    Then game status should be "<status>"
    Examples:
      | set             | status  |
      | O9 B9 G9        | invalid |
      | O10 B10 G10     | valid   |
      | O12 B12 G12     | valid   |
      | R11 O11 B11 G11 | valid   |

  Scenario Outline: Initial 30 with multiple runs
    Given player 1 has "<run1>"
    And player 1 has "<run2>"
    And game starts
    When player 1 plays "<run1>"
    And player 1 plays "<run2>"
    And player 1 ends turn
    Then game status should be "<status>"
    Examples:
      | run1        | run2        | status  |
      | B1 B2 B3    | G4 G5 G6 G7 | invalid |
      | B1 B2 B3 B4 | G4 G5 G6 G7 | valid   |
      | B6 B7 B8    | G6 G7 G8    | valid   |

  Scenario Outline: Initial 30 with multiple sets
    Given player 1 has "<set1>"
    And player 1 has "<set2>"
    And game starts
    When player 1 plays "<set1>"
    And player 1 plays "<set2>"
    And player 1 ends turn
    Then game status should be "<status>"
    Examples:
      | set1     | set2        | status  |
      | O3 R3 B3 | R5 G5 B5 O5 | invalid |
      | O4 R4 B4 | R5 G5 B5 O5 | valid   |
      | O7 R7 B7 | R6 G6 O6    | valid   |

  Scenario Outline: Initial 30 with runs and sets
    Given player 1 has "<run>"
    And player 1 has "<set>"
    And game starts
    When player 1 plays "<run>"
    And player 1 plays "<set>"
    And player 1 ends turn
    Then game status should be "<status>"
    Examples:
      | run            | set         | status  |
      | R4 R5 R6 R7    | B2 O2 R2    | invalid |
      | R4 R5 R6 R7    | B2 O2 R2 G2 | valid   |
      | R4 R5 R6 R7 R8 | B2 O2 R2 G2 | valid   |