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
      | R12 O12 B12 G12 | valid   |

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
      | B11 B12 B13 | G11 G12 G13 | valid   |

  Scenario Outline: Initial 30 with multiple sets
    Given player 1 has "<set1>"
    And player 1 has "<set2>"
    And game starts
    When player 1 plays "<set1>"
    And player 1 plays "<set2>"
    And player 1 ends turn
    Then game status should be "<status>"
    Examples:
      | set1            | set2            | status  |
      | O3 R3 B3        | R5 G5 B5 O5     | invalid |
      | O4 R4 B4        | R5 G5 B5 O5     | valid   |
      | O13 R13 B13 G13 | R12 G12 B12 O12 | valid   |

  Scenario Outline: Initial 30 with runs and sets
    Given player 1 has "<run>"
    And player 1 has "<set>"
    And game starts
    When player 1 plays "<run>"
    And player 1 plays "<set>"
    And player 1 ends turn
    Then game status should be "<status>"
    Examples:
      | run                            | set             | status  |
      | R4 R5 R6 R7                    | B2 O2 R2        | invalid |
      | R4 R5 R6 R7                    | B2 O2 R2 G2     | valid   |
      | R1 R2 R3 R4 R5 R6 R7 R8 R9 R10 | B13 O13 R13 G13 | valid   |

  Scenario Outline: Initial 30 with tiles not in hand
    Given player 1 has "O2 O3 O4 O5 O6 O7 O8 O9 O10 O11 O12 O13 R13 B13"
    And game starts
    When player 1 plays "<meld>"
    And player 1 ends turn
    Then game status should be "<status>"
    Examples:
      | meld           | status  |
      | R10 R11 R12    | invalid |
      | R11 R12 R13    | invalid |
      | O11 O12 O13 O1 | invalid |
      | O11 O12 O13    | valid   |
      | B11 G11 R11    | invalid |
      | O11 G11 R11    | invalid |
      | O13 R13 G13    | invalid |
      | O13 R13 B13    | valid   |