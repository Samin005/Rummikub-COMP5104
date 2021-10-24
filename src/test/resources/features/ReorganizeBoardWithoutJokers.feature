@reorganizeBoardWithoutJokers
Feature: Reorganize Board without Jokers

  Background:
    Given 3 players joined the game
    And player 1 has "R11 R12 R13 O3 O4 O6 G8 G9 G10 R7"
    And player 2 has "B11 B12 B13 O5 B5 G5 R5 O7 O8 O9 O10"
    And player 3 has "O11 O12 O13 O7 B7 G7"
    And game starts
    And player 1 plays "R11 R12 R13"
    And player 1 ends turn
    And player 2 plays "B11 B12 B13"
    And player 2 plays "O5 B5 G5 R5"
    And player 2 plays "O7 O8 O9 O10"
    And player 2 ends turn
    And player 3 plays "O11 O12 O13"
    And player 3 plays "O7 B7 G7"
    And player 3 ends turn

  Scenario Outline: Add tile from hand to existing meld in board
    Given  player 1 executes "<addCommand>"
    When player 1 ends turn
    Then add board game status should be "<status>"
    Examples:
      | addCommand          | status  |
      | add R7 to 6 at tail | valid   |
      | add R7 to 6 at head | valid   |
      | add R7 to 4 at head | invalid |
      | add R7 to 1 at tail | invalid |

  Scenario Outline: Break existing meld into two and add from hand
    Given player 1 executes "<breakCommand>"
    And  player 1 executes "<addCommand>"
    When player 1 ends turn
    Then break board game status should be "<status>"
    Examples:
      | breakCommand  | addCommand             | status  |
      | break 3 at O5 | add O3 O4 to 6 at head | valid   |
      | break 1 at O5 | add O3 O4 to 6 at head | invalid |
      | break 3 at O6 | add O3 O4 to 6 at tail | invalid |
      | break 3 at O5 | add O3 O5 to 6 at head | invalid |
      | break 3 at O5 | add O3 O4 to 3 at head | invalid |

  Scenario Outline: Merge existing melds into one and add from hand
    Given player 1 executes "<mergeCommand>"
    And  player 1 executes "<addCommand>"
    When player 1 ends turn
    Then merge board game status should be "<status>"
    Examples:
      | mergeCommand           | addCommand          | status  |
      | merge 4 with 5 at tail | add O6 to 4 at head | valid   |
      | merge 4 with 6 at tail | add O6 to 4 at head | invalid |
      | merge 2 with 5 at tail | add O6 to 4 at tail | invalid |
      | merge 4 with 5 at head | add O6 to 4 at head | invalid |
      | merge 4 with 5 at tail | add O6 to 3 at head | invalid |