package samin005.rummikub.cucumber;
import io.cucumber.java.en.*;
import samin005.rummikub.model.Game;
import samin005.rummikub.model.Player;
import samin005.rummikub.service.GameService;

import static org.junit.Assert.*;

public class StepDefinitions {
    GameService gameService = new GameService();
    Game currentGame = gameService.getCurrentGame();
    Player player = new Player();

    @Given("{int} players joined the game")
    public void playersJoinedTheGame(int numberOfPlayers) {
        // Creating a new Game
        gameService = new GameService();
        // player 1 joins
        gameService.joinGame();
        // player 2 joins
        gameService.joinGame();
        // player 3 joins
        gameService.joinGame();

        currentGame = gameService.getCurrentGame();
    }

    @Given("player {int} has {string}")
    public void playerHas(int playerNo, String meld) {
        Player currentPlayer = currentGame.getPlayerByNumber(playerNo);
        gameService.placeInHand(currentPlayer, meld);
    }

    @Given("game starts")
    public void gameStarts() {
        gameService.startGame();

        assertEquals(14, currentGame.getPlayerByNumber(1).getInHand().size());
        assertEquals(14, currentGame.getPlayerByNumber(2).getInHand().size());
        assertEquals(14, currentGame.getPlayerByNumber(3).getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());
    }

    @When("player {int} plays {string}")
    public void playerPlays(int playerNo, String meld) {
        player = currentGame.getPlayerByNumber(playerNo);
        gameService.executeTurn("play " + meld);
    }

    @When("player {int} executes {string}")
    public void playerExecutes(int playerNo, String command) {
        player = currentGame.getPlayerByNumber(playerNo);
        gameService.executeTurn(command);
    }

    @And("player {int} ends turn")
    public void playerEndsTurn(int playerNo) {
        gameService.executeTurn("end");
    }

    @Then("game status should be {string}")
    public void gameStatusShouldBe(String status) {
        // invalid move
        if(currentGame.getStatus().startsWith("INVALID")) {
            assertEquals(status, "invalid");
            // as no melds were added to the board, the size should remain 0
            assertEquals(0, currentGame.getBoard().size());
            // the player drew 3 tiles for an invalid move, so in hand tiles should be 14+3=17
            assertEquals(17, player.getInHand().size());
        }
        // valid move
        else {
            assertEquals(status, "valid");
            // as melds were added to the board, the size should not remain 0
            assertTrue(currentGame.getBoard().size() > 0);
            // the player played melds and the minimum valid meld size is 3, so in hand tiles should be <= 14-3 = 11
            assertTrue(player.getInHand().size() <= 11);
        }
    }

    @Then("break board game status should be {string}")
    public void breakBoardGameStatusShouldBe(String status) {
        // invalid move
        if(currentGame.getStatus().startsWith("INVALID")) {
            assertEquals(status, "invalid");
            // as no melds were added to the board, the size should remain 6
            assertEquals(6, currentGame.getBoard().size());
            // the player drew 3 tiles for an invalid move, so in hand tiles should be 11+3=14
            assertEquals(14, player.getInHand().size());
        }
        // valid move
        else {
            assertEquals(status, "valid");
            // as melds were added to the board, the size should not remain 6
            assertTrue(currentGame.getBoard().size() != 6);
            // the player played at least 1 valid tile from hand, so in hand tiles should be <11
            assertTrue(player.getInHand().size() < 11);
        }
    }

    @Then("add board game status should be {string}")
    public void addBoardGameStatusShouldBe(String status) {
        // invalid move
        if(currentGame.getStatus().startsWith("INVALID")) {
            assertEquals(status, "invalid");
            // as no melds were added to the board, the size should remain 6
            assertEquals(6, currentGame.getBoard().size());
            // the player drew 3 tiles for an invalid move, so in hand tiles should be 11+3=14
            assertEquals(14, player.getInHand().size());
        }
        // valid move
        else {
            assertEquals(status, "valid");
            // as melds were added to the board, the size should not remain 6
            assertTrue(currentGame.getBoard().size() == 6);
            // the player played at least 1 valid tile from hand, so in hand tiles should be <11
            assertTrue(player.getInHand().size() < 11);
        }
    }

    @Then("merge board game status should be {string}")
    public void mergeBoardGameStatusShouldBe(String status) {
        // invalid move
        if(currentGame.getStatus().startsWith("INVALID")) {
            assertEquals(status, "invalid");
            // as no melds were added to the board, the size should remain 5
            assertEquals(6, currentGame.getBoard().size());
            // the player drew 3 tiles for an invalid move, so in hand tiles should be 11+3=14
            assertEquals(14, player.getInHand().size());
        }
        // valid move
        else {
            assertEquals(status, "valid");
            // as melds were added to the board, the size should less than 6
            assertTrue(currentGame.getBoard().size() < 6);
            // the player played at least 1 valid tile from hand, so in hand tiles should be <11
            assertTrue(player.getInHand().size() < 11);
        }
    }

    @Then("joker reuse game status should be {string}")
    public void jokerReuseGameStatusShouldBe(String status) {
        // invalid move
        if(currentGame.getStatus().startsWith("INVALID")) {
            assertEquals(status, "invalid");
            // as no new melds were added to the board, the size should remain 5
            assertEquals(5, currentGame.getBoard().size());
            // the player drew 3 tiles for an invalid move, so in hand tiles should be 11+3=14
            assertEquals(14, player.getInHand().size());
        }
        // valid move
        else {
            assertEquals(status, "valid");
            // as melds were added to the board, the size should not remain 0
            assertTrue(currentGame.getBoard().size() > 0);
            // the player played melds and the minimum valid meld size is 3, so in hand tiles should be <= 14-3 = 11
            assertTrue(player.getInHand().size() <= 11);
        }
    }

    @Then("game status without penalty should be {string}")
    public void gameStatusWithoutPenaltyShouldBe(String status) {
        // invalid move
        if(currentGame.getStatus().startsWith("INVALID")) {
            assertEquals(status, "invalid");
            // each player added 1 meld in initial 30 to the board, the size should remain 3
            assertEquals(3, currentGame.getBoard().size());
            // player played an invalid move without the 3 tile penalty, so in hand tiles should remain 11
            assertEquals(11, player.getInHand().size());
        }
        // valid move
        else {
            assertEquals(status, "valid");
            // as melds were added to the board, the size should not remain 0
            assertTrue(currentGame.getBoard().size() > 0);
            // the player played melds and the minimum valid meld size is 3, so in hand tiles should be <= 14-3 = 11
            assertTrue(player.getInHand().size() <= 11);
        }
    }

    @Then("game scores should be {string}, {string}, {string}, {string}")
    public void gameScoresShouldBe(String p1Score, String p2Score, String p3Score, String status) {
        if(status.equals("valid")) {
            assertEquals(Integer.parseInt(p1Score), currentGame.getPlayerByNumber(1).getScore());
            assertEquals(Integer.parseInt(p2Score), currentGame.getPlayerByNumber(2).getScore());
            assertEquals(Integer.parseInt(p3Score), currentGame.getPlayerByNumber(3).getScore());
        }
        else {
            assertNotEquals(Integer.parseInt(p1Score), currentGame.getPlayerByNumber(1).getScore());
            assertNotEquals(Integer.parseInt(p2Score), currentGame.getPlayerByNumber(2).getScore());
            assertNotEquals(Integer.parseInt(p3Score), currentGame.getPlayerByNumber(3).getScore());
        }
    }

    @Given("player {int} draws tile {string}")
    public void playerDrawsTile(int playerNo, String tile) {
        gameService.drawSpecificTile(currentGame.getPlayerByNumber(playerNo), tile);
    }
}
