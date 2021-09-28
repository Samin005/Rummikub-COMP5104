package samin005.rummikub;

import org.junit.Test;
import samin005.rummikub.model.Game;
import samin005.rummikub.model.Player;
import samin005.rummikub.service.GameService;

import static org.junit.Assert.*;

public class A1GridTests {

    @Test
    public void row45to48Tests() {
        // Creating a new Game
        GameService gameService = new GameService();
        // player 1 joins
        gameService.joinGame();
        // player 2 joins
        gameService.joinGame();
        // player 3 joins
        gameService.joinGame();

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);
        Player player2 = currentGame.getPlayerByNumber(2);
        Player player3 = currentGame.getPlayerByNumber(3);

        // setting the tiles players are supposed to play
        gameService.placeInHand(player2, "R11 R12 R13");
        gameService.placeInHand(player3, "R13 B13 G13");
        gameService.placeInHand(player3, "G2 R2 O2");
        gameService.placeInHand(player1, "R12 B12 O12");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 62
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(62, currentGame.getTilesRemaining().size());

        // player 1 draws
        gameService.executeTurn("draw");
        // ensuring player 1 has 15 tiles and the remaining tiles are 61
        assertEquals(15, player1.getInHand().size());
        assertEquals(61, currentGame.getTilesRemaining().size());
        // ensuring board is empty
        assertEquals(0, currentGame.getBoard().size());
    }
}
