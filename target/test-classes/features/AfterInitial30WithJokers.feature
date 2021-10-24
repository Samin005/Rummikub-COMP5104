@afterInitial30WithJokers
Feature: After Initial 30 with Jokers

  Background:
    Given 3 players joined the game
    And player 1 has "R11 R12 R13"
    And player 2 has "B11 B12 B13"
    And player 3 has "O11 O12 O13"

  Scenario Outline: After Initial 30 with 1 run including Jokers
    Given player 1 has "<run>"
    And game starts
    And player 1 plays "R11 R12 R13"
    And player 1 ends turn
    And player 2 plays "B11 B12 B13"
    And player 2 ends turn
    And player 3 plays "O11 O12 O13"
    And player 3 ends turn
    When player 1 plays "<run>"
    And player 1 ends turn
    Then game status without penalty should be "<status>"
    Examples:
      | run                              | status  |
      | * R2                             | invalid |
      | R1 * R3                          | valid   |
      | R1 R2 R3 R4 R5 R6 R7 R8 R9 R10 * | valid   |
      | * *                              | invalid |
      | * R2 *                           | valid   |
      | R1 * R3 R4 R5 R6 R7 R8 R9 * R11  | valid   |

  Scenario Outline: After Initial 30 with 1 set including Jokers
    Given player 1 has "<set>"
    And game starts
    And player 1 plays "R11 R12 R13"
    And player 1 ends turn
    And player 2 plays "B11 B12 B13"
    And player 2 ends turn
    And player 3 plays "O11 O12 O13"
    And player 3 ends turn
    When player 1 plays "<set>"
    And player 1 ends turn
    Then game status without penalty should be "<status>"
    Examples:
      | set           | status  |
      | O2 *          | invalid |
      | * R2 G2       | valid   |
      | O2 R2 * B2    | valid   |
      | O2 R2 G2 B2 * | invalid |
      | * *           | invalid |
      | O2 * *        | valid   |
      | * R2 G2 *     | valid   |
      | O2 * G2 B2 *  | invalid |

  Scenario Outline: After Initial 30 with multiple runs including Jokers
    Given player 1 has "<run1>"
    And player 1 has "<run2>"
    And game starts
    And player 1 plays "R11 R12 R13"
    And player 1 ends turn
    And player 2 plays "B11 B12 B13"
    And player 2 ends turn
    And player 3 plays "O11 O12 O13"
    And player 3 ends turn
    When player 1 plays "<run1>"
    And player 1 plays "<run2>"
    And player 1 ends turn
    Then game status without penalty should be "<status>"
    Examples:
      | run1                   | run2             | status  |
      | * R2                   | B1 B2            | invalid |
      | R1 R2 R3               | B1 * B3          | valid   |
      | * R2 R3 R4 R5 R6 R7 R8 | B1 B2 B3         | valid   |
      | R1 R2 R3 R4 R5         | B1 B2 B3 * B5 B6 | valid   |
      | * R2                   | B1 *             | invalid |
      | R1 R2 *                | B1 * B3          | valid   |
      | * R2 R3 R4 R5 R6 R7 R8 | B1 B2 *          | valid   |
      | R3 R4 R5 R6 R7 *       | B2 B3 * B5 B6 | valid   |

  Scenario Outline: After Initial 30 with multiple sets including Jokers
    Given player 1 has "<set1>"
    And player 1 has "<set2>"
    And game starts
    And player 1 plays "R11 R12 R13"
    And player 1 ends turn
    And player 2 plays "B11 B12 B13"
    And player 2 ends turn
    And player 3 plays "O11 O12 O13"
    And player 3 ends turn
    When player 1 plays "<set1>"
    And player 1 plays "<set2>"
    And player 1 ends turn
    Then game status without penalty should be "<status>"
    Examples:
      | set1          | set2           | status  |
      | O6 R6         | G7 *           | invalid |
      | O6 * G6       | G7 B7 R7       | valid   |
      | O6 R6 G6 B6   | * B7 R7 B7     | valid   |
      | * O6 R6 G6 B6 | G7 B7 R7 R7 B7 | invalid |
      | * R6          | G7 *           | invalid |
      | O6 * G6       | G7 * R7        | valid   |
      | O6 R6 G6 *    | * B7 R7 B7     | valid   |
      | * O6 R6 G6 B6 | G7 B7 R7 * B7  | invalid |

  Scenario Outline: After Initial 30 with runs and sets including Jokers
    Given player 1 has "<run>"
    And player 1 has "<set>"
    And game starts
    And player 1 plays "R11 R12 R13"
    And player 1 ends turn
    And player 2 plays "B11 B12 B13"
    And player 2 ends turn
    And player 3 plays "O11 O12 O13"
    And player 3 ends turn
    When player 1 plays "<run>"
    And player 1 plays "<set>"
    And player 1 ends turn
    Then game status without penalty should be "<status>"
    Examples:
      | run                     | set        | status  |
      | B1 B2                   | * B7       | invalid |
      | R1 R2 *                 | G7 B7 R7   | valid   |
      | B3 B4 B5 B6 B7 B8 | G7 * R7 B7 | valid   |
      | * B2                    | * B7       | invalid |
      | R1 R2 *                 | * B7 R7    | valid   |
      | B1 B2 B3 * B5 B6 B7  | G7 * R7 B7 | valid   |

  Scenario Outline: After Initial including Joker 30 with tiles not in hand
    Given player 1 has "* O3 O4 O5 O6 O7 O8 O9 O10 R3 B3"
    And game starts
    And player 1 plays "R11 R12 R13"
    And player 1 ends turn
    And player 2 plays "B11 B12 B13"
    And player 2 ends turn
    And player 3 plays "O11 O12 O13"
    And player 3 ends turn
    When player 1 plays "<meld>"
    And player 1 ends turn
    Then game status without penalty should be "<status>"
    Examples:
      | meld       | status  |
      | * R4 R5    | invalid |
      | O1 O2 *    | invalid |
      | * O3 O4    | valid   |
      | * R1 B1    | invalid |
      | O2 * B2    | invalid |
      | * R3 G3    | invalid |
      | O3 R3 *    | valid   |
      | O3 R3 * B3 | valid   |
