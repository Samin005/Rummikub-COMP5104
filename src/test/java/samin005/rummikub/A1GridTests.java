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

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // ensuring player 2 has R11 R12 R13 before playing
        assertTrue(player2.getInHand().toString().contains("R11, R12, R13"));
        // ensuring the board does not contain the meld R11 R12 R13
        assertFalse(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // player 2 playing the meld R11 R12 R13
        gameService.executeTurn("play R11 R12 R13");
        // ensuring player 2 does not have R11 R12 R13 anymore
        assertFalse(player2.getInHand().toString().contains("R11, R12, R13"));
        // ensuring the board contains the meld R11 R12 R13 now
        assertTrue(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());

        // player 2 ends turn
        gameService.executeTurn("end");
        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R13 B13 G13
        assertFalse(currentGame.getBoard().toString().contains("R13, B13, G13"));
        // player 3 playing the meld R13 B13 G13
        gameService.executeTurn("play R13 B13 G13");
        // ensuring player 3 does not have R13 B13 G13 anymore
        assertFalse(player3.getInHand().toString().contains("R13, B13, G13"));
        // ensuring the board contains the meld R13 B13 G13 now
        assertTrue(currentGame.getBoard().toString().contains("R13, B13, G13"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());

        // ensuring current player is still player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld G2 R2 O2
        assertFalse(currentGame.getBoard().toString().contains("G2, R2, O2"));
        // player 3 playing the meld G2 R2 O2
        gameService.executeTurn("play G2 R2 O2");
        // ensuring player 3 does not have G2 R2 O2 anymore
        assertFalse(player3.getInHand().toString().contains("G2, R2, O2"));
        // ensuring the board contains the meld G2 R2 O2 now
        assertTrue(currentGame.getBoard().toString().contains("G2, R2, O2"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R12 B12 O12
        assertFalse(currentGame.getBoard().toString().contains("R12, B12, O12"));
        // player 1 playing the meld R12 B12 O12
        gameService.executeTurn("play R12 B12 O12");
        // ensuring player 1 does not have R12 B12 O12 anymore
        assertFalse(player1.getInHand().toString().contains("R12, B12, O12"));
        // ensuring the board contains the meld R12 B12 O12 now
        assertTrue(currentGame.getBoard().toString().contains("R12, B12, O12"));
        // as a new meld has been added to board, it's size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row51Tests() {
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
        gameService.placeInHand(player1, "R11 R12 R13");
        
        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 62
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(62, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R11 R12 R13
        assertFalse(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // player 1 playing the meld R11 R12 R13
        gameService.executeTurn("play R11 R12 R13");
        // ensuring player 1 does not have R11 R12 R13 anymore
        assertFalse(player1.getInHand().toString().contains("R11, R12, R13"));
        // ensuring the board contains the meld R11 R12 R13 now
        assertTrue(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row52Tests() {
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
        gameService.placeInHand(player1, "R12 G12 B12");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 62
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(62, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R12 G12 B12
        assertFalse(currentGame.getBoard().toString().contains("R12, G12, B12"));
        // player 1 playing the meld R12 G12 B12
        gameService.executeTurn("play R12 G12 B12");
        // ensuring player 1 does not have R12 G12 B12 anymore
        assertFalse(player1.getInHand().toString().contains("R12, G12, B12"));
        // ensuring the board contains the meld R12 G12 B12 now
        assertTrue(currentGame.getBoard().toString().contains("R12, G12, B12"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row53Tests() {
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
        gameService.placeInHand(player1, "R9 R10 R11 R12 R13");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 62
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(62, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R9 R10 R11 R12 R13
        assertFalse(currentGame.getBoard().toString().contains("R9, R10, R11, R12, R13"));
        // player 1 playing the meld R9 R10 R11 R12 R13
        gameService.executeTurn("play R9 R10 R11 R12 R13");
        // ensuring player 1 does not have R9 R10 R11 R12 R13 anymore
        assertFalse(player1.getInHand().toString().contains("R9, R10, R11, R12, R13"));
        // ensuring the board contains the meld R9 R10 R11 R12 R13 now
        assertTrue(currentGame.getBoard().toString().contains("R9, R10, R11, R12, R13"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row54Tests() {
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
        gameService.placeInHand(player1, "R13 G13 B13 O13");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 62
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(62, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R13 G13 B13 O13
        assertFalse(currentGame.getBoard().toString().contains("R13, G13, B13, O13"));
        // player 1 playing the meld R13 G13 B13 O13
        gameService.executeTurn("play R13 G13 B13 O13");
        // ensuring player 1 does not have R13 G13 B13 O13 anymore
        assertFalse(player1.getInHand().toString().contains("R13, G13, B13, O13"));
        // ensuring the board contains the meld R13 G13 B13 O13 now
        assertTrue(currentGame.getBoard().toString().contains("R13, G13, B13, O13"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row55Tests() {
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
        gameService.placeInHand(player1, "R2 R3 R4");
        gameService.placeInHand(player1, "B7 B8 B9");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 62
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(62, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R2 R3 R4
        assertFalse(currentGame.getBoard().toString().contains("R2, R3, R4"));
        // player 1 playing the meld R2 R3 R4
        gameService.executeTurn("play R2 R3 R4");
        // ensuring player 1 does not have R2 R3 R4 anymore
        assertFalse(player1.getInHand().toString().contains("R2, R3, R4"));
        // ensuring the board contains the meld R2 R3 R4 now
        assertTrue(currentGame.getBoard().toString().contains("R2, R3, R4"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld B7 B8 B9
        assertFalse(currentGame.getBoard().toString().contains("B7, B8, B9"));
        // player 1 playing the meld B7 B8 B9
        gameService.executeTurn("play B7 B8 B9");
        // ensuring player 1 does not have B7 B8 B9 anymore
        assertFalse(player1.getInHand().toString().contains("B7, B8, B9"));
        // ensuring the board contains the meld B7 B8 B9 now
        assertTrue(currentGame.getBoard().toString().contains("B7, B8, B9"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row56Tests() {
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
        gameService.placeInHand(player1, "R2 O2 B2");
        gameService.placeInHand(player1, "G4 O4 B4 R4");
        gameService.placeInHand(player1, "O5 B5 R5");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 62
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(62, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R2 O2 B2
        assertFalse(currentGame.getBoard().toString().contains("R2, O2, B2"));
        // player 1 playing the meld R2 O2 B2
        gameService.executeTurn("play R2 O2 B2");
        // ensuring player 1 does not have R2 O2 B2 anymore
        assertFalse(player1.getInHand().toString().contains("R2, O2, B2"));
        // ensuring the board contains the meld R2 O2 B2 now
        assertTrue(currentGame.getBoard().toString().contains("R2, O2, B2"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld G4 O4 B4 R4
        assertFalse(currentGame.getBoard().toString().contains("G4, O4, B4, R4"));
        // player 1 playing the meld G4 O4 B4 R4
        gameService.executeTurn("play G4 O4 B4 R4");
        // ensuring player 1 does not have G4 O4 B4 R4 anymore
        assertFalse(player1.getInHand().toString().contains("G4, O4, B4, R4"));
        // ensuring the board contains the meld G4 O4 B4 R4 now
        assertTrue(currentGame.getBoard().toString().contains("G4, O4, B4, R4"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O5 B5 R5
        assertFalse(currentGame.getBoard().toString().contains("O5, B5, R5"));
        // player 1 playing the meld O5 B5 R5
        gameService.executeTurn("play O5 B5 R5");
        // ensuring player 1 does not have O5 B5 R5 anymore
        assertFalse(player1.getInHand().toString().contains("O5, B5, R5"));
        // ensuring the board contains the meld O5 B5 R5 now
        assertTrue(currentGame.getBoard().toString().contains("O5, B5, R5"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row57Tests() {
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
        gameService.placeInHand(player1, "R8 G8 O8");
        gameService.placeInHand(player1, "R2 R3 R4");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 62
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(62, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R8 G8 O8
        assertFalse(currentGame.getBoard().toString().contains("R8, G8, O8"));
        // player 1 playing the meld R8 G8 O8
        gameService.executeTurn("play R8 G8 O8");
        // ensuring player 1 does not have R8 G8 O8 anymore
        assertFalse(player1.getInHand().toString().contains("R8, G8, O8"));
        // ensuring the board contains the meld R8 G8 O8 now
        assertTrue(currentGame.getBoard().toString().contains("R8, G8, O8"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R2 R3 R4
        assertFalse(currentGame.getBoard().toString().contains("R2, R3, R4"));
        // player 1 playing the meld R2 R3 R4
        gameService.executeTurn("play R2 R3 R4");
        // ensuring player 1 does not have R2 R3 R4 anymore
        assertFalse(player1.getInHand().toString().contains("R2, R3, R4"));
        // ensuring the board contains the meld R2 R3 R4 now
        assertTrue(currentGame.getBoard().toString().contains("R2, R3, R4"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row58Tests() {
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
        gameService.placeInHand(player1, "R2 O2 B2");
        gameService.placeInHand(player1, "G2 G3 G4");
        gameService.placeInHand(player1, "R3 B3 O3");
        gameService.placeInHand(player1, "B5 B6 B7");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 62
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(62, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R2 O2 B2
        assertFalse(currentGame.getBoard().toString().contains("R2, O2, B2"));
        // player 1 playing the meld R2 O2 B2
        gameService.executeTurn("play R2 O2 B2");
        // ensuring player 1 does not have R2 O2 B2 anymore
        assertFalse(player1.getInHand().toString().contains("R2, O2, B2"));
        // ensuring the board contains the meld R2 O2 B2 now
        assertTrue(currentGame.getBoard().toString().contains("R2, O2, B2"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld G2 G3 G4
        assertFalse(currentGame.getBoard().toString().contains("G2, G3, G4"));
        // player 1 playing the meld G2 G3 G4
        gameService.executeTurn("play G2 G3 G4");
        // ensuring player 1 does not have G2 G3 G4 anymore
        assertFalse(player1.getInHand().toString().contains("G2, G3, G4"));
        // ensuring the board contains the meld G2 G3 G4 now
        assertTrue(currentGame.getBoard().toString().contains("G2, G3, G4"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R3 B3 O3
        assertFalse(currentGame.getBoard().toString().contains("R3, B3, O3"));
        // player 1 playing the meld R3 B3 O3
        gameService.executeTurn("play R3 B3 O3");
        // ensuring player 1 does not have R3 B3 O3 anymore
        assertFalse(player1.getInHand().toString().contains("R3, B3, O3"));
        // ensuring the board contains the meld R3 B3 O3 now
        assertTrue(currentGame.getBoard().toString().contains("R3, B3, O3"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld B5 B6 B7
        assertFalse(currentGame.getBoard().toString().contains("B5, B6, B7"));
        // player 1 playing the meld B5 B6 B7
        gameService.executeTurn("play B5 B6 B7");
        // ensuring player 1 does not have B5 B6 B7 anymore
        assertFalse(player1.getInHand().toString().contains("B5, B6, B7"));
        // ensuring the board contains the meld B5 B6 B7 now
        assertTrue(currentGame.getBoard().toString().contains("B5, B6, B7"));
        // as a new meld has been added to board, it's size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }
}
