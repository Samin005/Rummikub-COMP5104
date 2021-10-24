@finalScoreCalculationWithoutJokers
Feature: Final Score Calculation Without Jokers

  Background:
    Given 3 players joined the game
    And player 1 has "O2 O3 O4 O5 O6 O7 O8 O9 R11 B11 G11 R13 B13 G13"
    And player 2 has "B2 B3 B4 B5 B6 B7 B8 B9 R12 O12 G12 R2 G2 O2"
    And player 3 has "G2 G3 G4 G5 G6 G7 G8 G9 B5 R5 O5 R6 O6 B6"
    And game starts
    And player 1 plays "R11 B11 G11"
    And player 1 ends turn
    And player 2 plays "R12 O12 G12"
    And player 2 ends turn
    And player 3 plays "G2 G3 G4 G5 G6 G7 G8 G9"
    And player 3 ends turn

  Scenario Outline: player 1 wins
    Given player 1 plays "O2 O3 O4 O5 O6 O7 O8 O9"
    And  player 1 plays "R13 B13 G13"
    When player 1 ends turn
    Then game scores should be "<p1Score>", "<p2Score>", "<p3Score>", "<status>"
    Examples:
      | p1Score | p2Score | p3Score | status  |
      | 0       | -50     | -33     | valid   |
      | 1       | -48     | -34     | invalid |

  Scenario Outline: player 2 wins
    Given player 1 draws tile "R9"
    And player 1 ends turn
    When player 2 plays "B2 B3 B4 B5 B6 B7 B8 B9"
    And player 2 plays "R2 G2 O2"
    And player 2 ends turn
    Then game scores should be "<p1Score>", "<p2Score>", "<p3Score>", "<status>"
    Examples:
      | p1Score | p2Score | p3Score | status  |
      | -83     | 0       | -33     | valid   |
      | -73     | -5      | -43     | invalid |

  Scenario Outline: player 3 wins
    Given player 1 draws tile "R9"
    And player 1 ends turn
    And player 2 draws tile "R7"
    And player 2 ends turn
    When player 3 plays "B5 R5 O5"
    And player 3 plays "R6 O6 B6"
    And player 3 ends turn
    Then game scores should be "<p1Score>", "<p2Score>", "<p3Score>", "<status>"
    Examples:
      | p1Score | p2Score | p3Score | status  |
      | -83     | -57     | 0       | valid   |
      | 0       | -83     | -57     | invalid |