@jokerReuse
Feature: Reusing Jokers already present in board

  Background:
    Given 3 players joined the game
    And player 1 has "R10 B10 G10 R2 R5 G5 G6 O8 O9"
    And player 2 has "B11 O11 G11 R5 O5 B5"
    And player 3 has "O12 R12 B12 * R3 R4 * R6"
    And game starts
    And player 1 plays "R10 B10 G10"
    And player 1 ends turn
    And player 2 plays "B11 O11 G11"
    And player 2 plays "R5 O5 B5"
    And player 2 ends turn
    And player 3 plays "O12 R12 B12"

  Scenario Outline: Reusing Joker from board
    Given player 3 plays "R3 R4 * R6"
    And player 3 ends turn
    When player 1 executes "<firstCommand>"
    And  player 1 executes "<secondCommand>"
    And player 1 ends turn
    Then joker reuse game status should be "<status>"
    Examples:
      | firstCommand                 | secondCommand          | status  |
      | replace joker at 5 3 with R5 | add G5 G6 to 6 at tail | valid   |
      | break 5 at R4                | merge 3 with 4 at tail | invalid |
      | replace joker at 5 3 with O5 | add G5 G6 to 5 at tail | invalid |
      | replace joker at 5 3 with R5 | merge 3 with 6 at tail | invalid |

  Scenario Outline: Reusing both Jokers from board
    Given player 3 plays "* R3 R4 * R6"
    And player 3 ends turn
    When player 1 executes "<firstCommand>"
    And  player 1 executes "<secondCommand>"
    And  player 1 executes "<thirdCommand>"
    And  player 1 executes "<fourthCommand>"
    And player 1 ends turn
    Then joker reuse game status should be "<status>"
    Examples:
      | firstCommand                 | secondCommand                | thirdCommand                 | fourthCommand          | status  |
      | replace joker at 5 1 with R2 | replace joker at 5 4 with R5 | add G5 G6 to 6 at tail       | add O8 O9 to 7 at tail | valid   |
      | replace joker at 5 1 with R2 | break 5 at R4                | merge 3 with 4 at tail       | add O8 O9 to 5 at tail | invalid |
      | break 5 at R4                | merge 3 with 4 at tail       | replace joker at 5 1 with R2 | add O8 O9 to 5 at tail | invalid |