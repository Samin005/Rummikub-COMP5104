package samin005.rummikub.junit;

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

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // player 1 draws
        gameService.executeTurn("draw");
        // ensuring player 1 has 15 tiles and the remaining tiles are 63 
        assertEquals(15, player1.getInHand().size());
        assertEquals(63, currentGame.getTilesRemaining().size());
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

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

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

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

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

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

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

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

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

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

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

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

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

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

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

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

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

    @Test
    public void row59Tests() {
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
        gameService.placeInHand(player1, "R2 B2 G2 O2");
        gameService.placeInHand(player1, "G3 G4 G5 G6 G7");
        gameService.placeInHand(player1, "O4 O5 O6 O7 O8");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R2 B2 G2 O2
        assertFalse(currentGame.getBoard().toString().contains("R2, B2, G2, O2"));
        // player 1 playing the meld R2 B2 G2 O2
        gameService.executeTurn("play R2 B2 G2 O2");
        // ensuring player 1 does not have R2 B2 G2 O2 anymore
        assertFalse(player1.getInHand().toString().contains("R2, B2, G2, O2"));
        // ensuring the board contains the meld R2 B2 G2 O2 now
        assertTrue(currentGame.getBoard().toString().contains("R2, B2, G2, O2"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld G3 G4 G5 G6 G7
        assertFalse(currentGame.getBoard().toString().contains("G3, G4, G5, G6, G7"));
        // player 1 playing the meld G3 G4 G5 G6 G7
        gameService.executeTurn("play G3 G4 G5 G6 G7");
        // ensuring player 1 does not have G3 G4 G5 G6 G7 anymore
        assertFalse(player1.getInHand().toString().contains("G3, G4, G5, G6, G7"));
        // ensuring the board contains the meld G3 G4 G5 G6 G7 now
        assertTrue(currentGame.getBoard().toString().contains("G3, G4, G5, G6, G7"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O4 O5 O6 O7 O8
        assertFalse(currentGame.getBoard().toString().contains("O4, O5, O6, O7, O8"));
        // player 1 playing the meld O4 O5 O6 O7 O8
        gameService.executeTurn("play O4 O5 O6 O7 O8");
        // ensuring player 1 does not have O4 O5 O6 O7 O8 anymore
        assertFalse(player1.getInHand().toString().contains("O4, O5, O6, O7, O8"));
        // ensuring the board contains the meld O4 O5 O6 O7 O8 now
        assertTrue(currentGame.getBoard().toString().contains("O4, O5, O6, O7, O8"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row63Tests() {
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
        gameService.placeInHand(player2, "B11 B12 B13");
        gameService.placeInHand(player3, "O11 O12 O13");
        gameService.placeInHand(player1, "G2 G3 G4");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R11 R12 R13
        assertFalse(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // player 1 playing the meld R11 R12 R13
        gameService.executeTurn("play R11 R12 R13");
        // ensuring player 1 does not have R11 R12 R13 anymore
        assertFalse(gameService.existsInHand(player1, "R11 R12 R13".split(" ")));
        // ensuring the board contains the meld R11 R12 R13 now
        assertTrue(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld B11 B12 B13
        assertFalse(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // player 2 playing the meld B11 B12 B13
        gameService.executeTurn("play B11 B12 B13");
        // ensuring player 2 does not have B11 B12 B13 anymore
        assertFalse(gameService.existsInHand(player2, "B11 B12 B13".split(" ")));
        // ensuring the board contains the meld B11 B12 B13 now
        assertTrue(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O11 O12 O13
        assertFalse(currentGame.getBoard().toString().contains("O11, O12, O13"));
        // player 3 playing the meld O11 O12 O13
        gameService.executeTurn("play O11 O12 O13");
        // ensuring player 3 does not have O11 O12 O13 anymore
        assertFalse(player3.getInHand().toString().contains("O11, O12, O13"));
        // ensuring the board contains the meld O11 O12 O13 now
        assertTrue(currentGame.getBoard().toString().contains("O11, O12, O13"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld G2 G3 G4
        assertFalse(currentGame.getBoard().toString().contains("G2, G3, G4"));
        // player 1 playing the meld G2 G3 G4
        gameService.executeTurn("play G2 G3 G4");
        // ensuring player 1 does not have G2 G3 G4 anymore
        assertFalse(gameService.existsInHand(player1, "G2 G3 G4".split(" ")));
        // ensuring the board contains the meld G2 G3 G4 now
        assertTrue(currentGame.getBoard().toString().contains("G2, G3, G4"));
        // as a new meld has been added to board, it's size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row64Tests() {
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
        gameService.placeInHand(player2, "B11 B12 B13");
        gameService.placeInHand(player3, "O11 O12 O13");
        gameService.placeInHand(player1, "G2 G3 G4");
        gameService.placeInHand(player1, "O8 O9 O10");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R11 R12 R13
        assertFalse(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // player 1 playing the meld R11 R12 R13
        gameService.executeTurn("play R11 R12 R13");
        // ensuring player 1 does not have R11 R12 R13 anymore
        assertFalse(gameService.existsInHand(player1, "R11 R12 R13".split(" ")));
        // ensuring the board contains the meld R11 R12 R13 now
        assertTrue(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld B11 B12 B13
        assertFalse(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // player 2 playing the meld B11 B12 B13
        gameService.executeTurn("play B11 B12 B13");
        // ensuring player 2 does not have B11 B12 B13 anymore
        assertFalse(gameService.existsInHand(player2, "B11 B12 B13".split(" ")));
        // ensuring the board contains the meld B11 B12 B13 now
        assertTrue(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O11 O12 O13
        assertFalse(currentGame.getBoard().toString().contains("O11, O12, O13"));
        // player 3 playing the meld O11 O12 O13
        gameService.executeTurn("play O11 O12 O13");
        // ensuring player 3 does not have O11 O12 O13 anymore
        assertFalse(player3.getInHand().toString().contains("O11, O12, O13"));
        // ensuring the board contains the meld O11 O12 O13 now
        assertTrue(currentGame.getBoard().toString().contains("O11, O12, O13"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld G2 G3 G4
        assertFalse(currentGame.getBoard().toString().contains("G2, G3, G4"));
        // player 1 playing the meld G2 G3 G4
        gameService.executeTurn("play G2 G3 G4");
        // ensuring player 1 does not have G2 G3 G4 anymore
        assertFalse(gameService.existsInHand(player1, "G2 G3 G4".split(" ")));
        // ensuring the board contains the meld G2 G3 G4 now
        assertTrue(currentGame.getBoard().toString().contains("G2, G3, G4"));
        // as a new meld has been added to board, it's size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());

        // ensuring current player is still player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O8 O9 O10
        assertFalse(currentGame.getBoard().toString().contains("O8, O9, O10"));
        // player 1 playing the meld O8 O9 O10
        gameService.executeTurn("play O8 O9 O10");
        // ensuring player 1 does not have O8 O9 O10 anymore
        assertFalse(gameService.existsInHand(player1, "O8 O9 O10".split(" ")));
        // ensuring the board contains the meld O8 O9 O10 now
        assertTrue(currentGame.getBoard().toString().contains("O8, O9, O10"));
        // as a new meld has been added to board, it's size should increase from 4 to 5
        assertEquals(5, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row65Tests() {
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
        gameService.placeInHand(player2, "B11 B12 B13");
        gameService.placeInHand(player3, "O11 O12 O13");
        gameService.placeInHand(player1, "G2 R2 O2");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R11 R12 R13
        assertFalse(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // player 1 playing the meld R11 R12 R13
        gameService.executeTurn("play R11 R12 R13");
        // ensuring player 1 does not have R11 R12 R13 anymore
        assertFalse(gameService.existsInHand(player1, "R11 R12 R13".split(" ")));
        // ensuring the board contains the meld R11 R12 R13 now
        assertTrue(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld B11 B12 B13
        assertFalse(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // player 2 playing the meld B11 B12 B13
        gameService.executeTurn("play B11 B12 B13");
        // ensuring player 2 does not have B11 B12 B13 anymore
        assertFalse(gameService.existsInHand(player2, "B11 B12 B13".split(" ")));
        // ensuring the board contains the meld B11 B12 B13 now
        assertTrue(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O11 O12 O13
        assertFalse(currentGame.getBoard().toString().contains("O11, O12, O13"));
        // player 3 playing the meld O11 O12 O13
        gameService.executeTurn("play O11 O12 O13");
        // ensuring player 3 does not have O11 O12 O13 anymore
        assertFalse(player3.getInHand().toString().contains("O11, O12, O13"));
        // ensuring the board contains the meld O11 O12 O13 now
        assertTrue(currentGame.getBoard().toString().contains("O11, O12, O13"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld G2 R2 O2
        assertFalse(currentGame.getBoard().toString().contains("G2, R2, O2"));
        // player 1 playing the meld G2 R2 O2
        gameService.executeTurn("play G2 R2 O2");
        // ensuring player 1 does not have G2 R2 O2 anymore
        assertFalse(gameService.existsInHand(player1, "G2 R2 O2".split(" ")));
        // ensuring the board contains the meld G2 R2 O2 now
        assertTrue(currentGame.getBoard().toString().contains("G2, R2, O2"));
        // as a new meld has been added to board, it's size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row66Tests() {
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
        gameService.placeInHand(player2, "B11 B12 B13");
        gameService.placeInHand(player3, "O11 O12 O13");
        gameService.placeInHand(player1, "G2 R2 O2");
        gameService.placeInHand(player1, "O8 R8 B8 G8");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R11 R12 R13
        assertFalse(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // player 1 playing the meld R11 R12 R13
        gameService.executeTurn("play R11 R12 R13");
        // ensuring player 1 does not have R11 R12 R13 anymore
        assertFalse(gameService.existsInHand(player1, "R11 R12 R13".split(" ")));
        // ensuring the board contains the meld R11 R12 R13 now
        assertTrue(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld B11 B12 B13
        assertFalse(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // player 2 playing the meld B11 B12 B13
        gameService.executeTurn("play B11 B12 B13");
        // ensuring player 2 does not have B11 B12 B13 anymore
        assertFalse(gameService.existsInHand(player2, "B11 B12 B13".split(" ")));
        // ensuring the board contains the meld B11 B12 B13 now
        assertTrue(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O11 O12 O13
        assertFalse(currentGame.getBoard().toString().contains("O11, O12, O13"));
        // player 3 playing the meld O11 O12 O13
        gameService.executeTurn("play O11 O12 O13");
        // ensuring player 3 does not have O11 O12 O13 anymore
        assertFalse(player3.getInHand().toString().contains("O11, O12, O13"));
        // ensuring the board contains the meld O11 O12 O13 now
        assertTrue(currentGame.getBoard().toString().contains("O11, O12, O13"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld G2 R2 O2
        assertFalse(currentGame.getBoard().toString().contains("G2, R2, O2"));
        // player 1 playing the meld G2 R2 O2
        gameService.executeTurn("play G2 R2 O2");
        // ensuring player 1 does not have G2 R2 O2 anymore
        assertFalse(gameService.existsInHand(player1, "G2 R2 O2".split(" ")));
        // ensuring the board contains the meld G2 R2 O2 now
        assertTrue(currentGame.getBoard().toString().contains("G2, R2, O2"));
        // as a new meld has been added to board, it's size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());

        // ensuring current player is still player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O8 R8 B8 G8
        assertFalse(currentGame.getBoard().toString().contains("O8, R8, B8, G8"));
        // player 1 playing the meld O8 R8 B8 G8
        gameService.executeTurn("play O8 R8 B8 G8");
        // ensuring player 1 does not have O8 R8 B8 G8 anymore
        assertFalse(gameService.existsInHand(player1, "O8 R8 B8 G8".split(" ")));
        // ensuring the board contains the meld O8 R8 B8 G8 now
        assertTrue(currentGame.getBoard().toString().contains("O8, R8, B8, G8"));
        // as a new meld has been added to board, it's size should increase from 4 to 5
        assertEquals(5, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row67Tests() {
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
        gameService.placeInHand(player2, "B11 B12 B13");
        gameService.placeInHand(player3, "O11 O12 O13");
        gameService.placeInHand(player1, "G2 R2 O2");
        gameService.placeInHand(player1, "O8 O9 O10");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R11 R12 R13
        assertFalse(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // player 1 playing the meld R11 R12 R13
        gameService.executeTurn("play R11 R12 R13");
        // ensuring player 1 does not have R11 R12 R13 anymore
        assertFalse(gameService.existsInHand(player1, "R11 R12 R13".split(" ")));
        // ensuring the board contains the meld R11 R12 R13 now
        assertTrue(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld B11 B12 B13
        assertFalse(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // player 2 playing the meld B11 B12 B13
        gameService.executeTurn("play B11 B12 B13");
        // ensuring player 2 does not have B11 B12 B13 anymore
        assertFalse(gameService.existsInHand(player2, "B11 B12 B13".split(" ")));
        // ensuring the board contains the meld B11 B12 B13 now
        assertTrue(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O11 O12 O13
        assertFalse(currentGame.getBoard().toString().contains("O11, O12, O13"));
        // player 3 playing the meld O11 O12 O13
        gameService.executeTurn("play O11 O12 O13");
        // ensuring player 3 does not have O11 O12 O13 anymore
        assertFalse(player3.getInHand().toString().contains("O11, O12, O13"));
        // ensuring the board contains the meld O11 O12 O13 now
        assertTrue(currentGame.getBoard().toString().contains("O11, O12, O13"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld G2 R2 O2
        assertFalse(currentGame.getBoard().toString().contains("G2, R2, O2"));
        // player 1 playing the meld G2 R2 O2
        gameService.executeTurn("play G2 R2 O2");
        // ensuring player 1 does not have G2 R2 O2 anymore
        assertFalse(gameService.existsInHand(player1, "G2 R2 O2".split(" ")));
        // ensuring the board contains the meld G2 R2 O2 now
        assertTrue(currentGame.getBoard().toString().contains("G2, R2, O2"));
        // as a new meld has been added to board, it's size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());

        // ensuring current player is still player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O8 O9 O10
        assertFalse(currentGame.getBoard().toString().contains("O8, O9, O10"));
        // player 1 playing the meld O8 O9 O10
        gameService.executeTurn("play O8 O9 O10");
        // ensuring player 1 does not have O8 O9 O10 anymore
        assertFalse(gameService.existsInHand(player1, "O8 O9 O10".split(" ")));
        // ensuring the board contains the meld O8 O9 O10 now
        assertTrue(currentGame.getBoard().toString().contains("O8, O9, O10"));
        // as a new meld has been added to board, it's size should increase from 4 to 5
        assertEquals(5, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row68Tests() {
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
        gameService.placeInHand(player2, "B11 B12 B13");
        gameService.placeInHand(player3, "O11 O12 O13");
        gameService.placeInHand(player1, "G2 R2 O2");
        gameService.placeInHand(player1, "G3 R3 O3");
        gameService.placeInHand(player1, "G8 G9 G10 G11 G12");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R11 R12 R13
        assertFalse(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // player 1 playing the meld R11 R12 R13
        gameService.executeTurn("play R11 R12 R13");
        // ensuring player 1 does not have R11 R12 R13 anymore
        assertFalse(gameService.existsInHand(player1, "R11 R12 R13".split(" ")));
        // ensuring the board contains the meld R11 R12 R13 now
        assertTrue(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld B11 B12 B13
        assertFalse(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // player 2 playing the meld B11 B12 B13
        gameService.executeTurn("play B11 B12 B13");
        // ensuring player 2 does not have B11 B12 B13 anymore
        assertFalse(gameService.existsInHand(player2, "B11 B12 B13".split(" ")));
        // ensuring the board contains the meld B11 B12 B13 now
        assertTrue(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O11 O12 O13
        assertFalse(currentGame.getBoard().toString().contains("O11, O12, O13"));
        // player 3 playing the meld O11 O12 O13
        gameService.executeTurn("play O11 O12 O13");
        // ensuring player 3 does not have O11 O12 O13 anymore
        assertFalse(player3.getInHand().toString().contains("O11, O12, O13"));
        // ensuring the board contains the meld O11 O12 O13 now
        assertTrue(currentGame.getBoard().toString().contains("O11, O12, O13"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld G2 R2 O2
        assertFalse(currentGame.getBoard().toString().contains("G2, R2, O2"));
        // player 1 playing the meld G2 R2 O2
        gameService.executeTurn("play G2 R2 O2");
        // ensuring player 1 does not have G2 R2 O2 anymore
        assertFalse(gameService.existsInHand(player1, "G2 R2 O2".split(" ")));
        // ensuring the board contains the meld G2 R2 O2 now
        assertTrue(currentGame.getBoard().toString().contains("G2, R2, O2"));
        // as a new meld has been added to board, it's size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());

        // ensuring current player is still player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld G3 R3 O3
        assertFalse(currentGame.getBoard().toString().contains("G3, R3, O3"));
        // player 1 playing the meld G3 R3 O3
        gameService.executeTurn("play G3 R3 O3");
        // ensuring player 1 does not have G3 R3 O3 anymore
        assertFalse(gameService.existsInHand(player1, "G3 R3 O3".split(" ")));
        // ensuring the board contains the meld G3 R3 O3 now
        assertTrue(currentGame.getBoard().toString().contains("G3, R3, O3"));
        // as a new meld has been added to board, it's size should increase from 4 to 5
        assertEquals(5, currentGame.getBoard().size());

        // ensuring current player is still player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld G8 G9 G10 G11 G12
        assertFalse(currentGame.getBoard().toString().contains("G8, G9, G10, G11, G12"));
        // player 1 playing the meld G8 G9 G10 G11 G12
        gameService.executeTurn("play G8 G9 G10 G11 G12");
        // ensuring player 1 does not have G8 G9 G10 G11 G12 anymore
        assertFalse(gameService.existsInHand(player1, "G8 G9 G10 G11 G12".split(" ")));
        // ensuring the board contains the meld G8 G9 G10 G11 G12 now
        assertTrue(currentGame.getBoard().toString().contains("G8, G9, G10, G11, G12"));
        // as a new meld has been added to board, it's size should increase from 5 to 6
        assertEquals(6, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row72Tests() {
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
        gameService.placeInHand(player1, "G2 R2 O2 G3 R3 O3 O8 O9 O10 R8 R9 R10 G12 R7");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // player 1 draws
        gameService.executeTurn("draw");
        // ensuring player 1 has 15 tiles and the remaining tiles are 63 
        assertEquals(15, player1.getInHand().size());
        assertEquals(63, currentGame.getTilesRemaining().size());
        // ensuring board is empty
        assertEquals(0, currentGame.getBoard().size());
    }

    @Test
    public void row73Tests() {
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
        gameService.placeInHand(player1, "G2 G2 O2 R3 B3 B3 R5 B6 O7 R9 R10 G11 B12 B13");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // player 1 draws
        gameService.executeTurn("draw");
        // ensuring player 1 has 15 tiles and the remaining tiles are 63 
        assertEquals(15, player1.getInHand().size());
        assertEquals(63, currentGame.getTilesRemaining().size());
        // ensuring board is empty
        assertEquals(0, currentGame.getBoard().size());
    }

    @Test
    public void row82Tests() {
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
        gameService.placeInHand(player1, "G1 G2 O2 R3 B3 B3 R5 B6 O7 R9 R10 B11 B12 B13");
        gameService.placeInHand(player2, "R2 B2 G2 O2 G3 G4 G6 G7 O4 O5 O6 O7 O8 O9");
        gameService.placeInHand(player3, "R4 O6 B6 B7 R7 G8 R10 R11 R12 R13 B10 B11 B12 B13");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 draws R2
        gameService.drawSpecificTile(player1, "R2");
        // ensuring player 1 has 15 tiles and the remaining tiles are 63 
        assertEquals(15, player1.getInHand().size());
        assertEquals(63, currentGame.getTilesRemaining().size());
        // ensuring board is empty
        assertEquals(0, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 draws G5
        gameService.drawSpecificTile(player2, "G5");
        // ensuring player 2 has 15 tiles and the remaining tiles are 60
        assertEquals(15, player1.getInHand().size());
        assertEquals(62, currentGame.getTilesRemaining().size());
        // ensuring board is empty
        assertEquals(0, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R10 R11 R12 R13
        assertFalse(currentGame.getBoard().toString().contains("R10, R11, R12, R13"));
        // player 3 playing the meld R10 R11 R12 R13
        gameService.executeTurn("play R10 R11 R12 R13");
        // ensuring player 3 does not have R10 R11 R12 R13 anymore
        assertFalse(gameService.existsInHand(player3, "R10 R11 R12 R13".split(" ")));
        // ensuring the board contains the meld R10 R11 R12 R13 now
        assertTrue(currentGame.getBoard().toString().contains("R10, R11, R12, R13"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());

        // ensuring current player is still player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld B10 B11 B12 B13
        assertFalse(currentGame.getBoard().toString().contains("B10, B11, B12, B13"));
        // player 3 playing the meld B10 B11 B12 B13
        gameService.executeTurn("play B10 B11 B12 B13");
        // ensuring player 3 does not have B10 B11 B12 B13 anymore
        assertFalse(gameService.existsInHand(player3, "B10 B11 B12 B13".split(" ")));
        // ensuring the board contains the meld B10 B11 B12 B13 now
        assertTrue(currentGame.getBoard().toString().contains("B10, B11, B12, B13"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld G2 O2 R2
        assertFalse(currentGame.getBoard().toString().contains("G2, O2, R2"));
        // player 1 playing the meld G2 O2 R2
        gameService.executeTurn("play G2 O2 R2");
        // ensuring player 1 does not have G2 O2 R2 anymore
        assertFalse(gameService.existsInHand(player1, "G2 O2 R2".split(" ")));
        // ensuring the board contains the meld G2 O2 R2 now
        assertTrue(currentGame.getBoard().toString().contains("G2, O2, R2"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());

        // ensuring current player is still player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 playing the meld B11 B12 B13
        gameService.executeTurn("play B11 B12 B13");
        // ensuring player 1 does not have B11 B12 B13 anymore
        assertFalse(gameService.existsInHand(player1, "B11 B12 B13".split(" ")));
        // ensuring the board contains the meld B11 B12 B13 now
        assertTrue(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // as a new meld has been added to board, it's size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld R2 B2 G2 O2
        gameService.executeTurn("play R2 B2 G2 O2");
        // ensuring player 2 does not have R2 B2 G2 O2 anymore
        assertFalse(gameService.existsInHand(player2, "R2 B2 G2 O2".split(" ")));
        // ensuring the board contains the meld R2 B2 G2 O2 now
        assertTrue(currentGame.getBoard().toString().contains("R2, B2, G2, O2"));
        // as a new meld has been added to board, it's size should increase from 4 to 5
        assertEquals(5, currentGame.getBoard().size());

        // ensuring current player is still player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld G3 G4 G5 G6 G7
        gameService.executeTurn("play G3 G4 G5 G6 G7");
        // ensuring player 2 does not have G3 G4 G5 G6 G7 anymore
        assertFalse(gameService.existsInHand(player2, "G3 G4 G5 G6 G7".split(" ")));
        // ensuring the board contains the meld G3 G4 G5 G6 G7 now
        assertTrue(currentGame.getBoard().toString().contains("G3, G4, G5, G6, G7"));
        // as a new meld has been added to board, it's size should increase from 5 to 6
        assertEquals(6, currentGame.getBoard().size());

        // ensuring current player is still player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld O4 O5 O6 O7 O8 O9
        gameService.executeTurn("play O4 O5 O6 O7 O8 O9");
        // ensuring player 2 does not have O4 O5 O6 O7 O8 O9 anymore
        assertFalse(gameService.existsInHand(player2, "O4 O5 O6 O7 O8 O9".split(" ")));
        // ensuring the board contains the meld O4 O5 O6 O7 O8 O9 now
        assertTrue(currentGame.getBoard().toString().contains("O4, O5, O6, O7, O8, O9"));
        // as a new meld has been added to board, it's size should increase from 6 to 7
        assertEquals(7, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        //player 1 scores -47
        assertEquals(player1.getScore(), -47);
        //player 2 scores 0
        assertEquals(player2.getScore(), 0);
        //player 3 scores -38
        assertEquals(player3.getScore(), -38);
    }

    @Test
    public void row87Tests() {
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
        gameService.placeInHand(player1, "R11 O11 B11 G11");
        gameService.placeInHand(player2, "R12 B12 G12");
        gameService.placeInHand(player3, "O7 O8 O9 O10 O11 O12 O13");
        gameService.placeInHand(player2, "B11 G11");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 playing the meld R11 O11 B11 G11
        gameService.executeTurn("play R11 O11 B11 G11");
        // ensuring player 1 does not have R11 O11 B11 G11 anymore
        assertFalse(gameService.existsInHand(player1, "R11 O11 B11 G11".split(" ")));
        // ensuring the board contains the meld R11 O11 B11 G11 now
        assertTrue(currentGame.getBoard().toString().contains("R11, O11, B11, G11"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld R12 B12 G12
        gameService.executeTurn("play R12 B12 G12");
        // ensuring player 2 does not have R12 B12 G12 anymore
        assertFalse(gameService.existsInHand(player2, "R12 B12 G12".split(" ")));
        // ensuring the board contains the meld R12 B12 G12 now
        assertTrue(currentGame.getBoard().toString().contains("R12, B12, G12"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O7 O8 O9 O10 O11 O12 O13
        assertFalse(currentGame.getBoard().toString().contains("O7, O8, O9, O10, O11, O12, O13"));
        // player 3 playing the meld O7 O8 O9 O10 O11 O12 O13
        gameService.executeTurn("play O7 O8 O9 O10 O11 O12 O13");
        // ensuring player 3 does not have O7 O8 O9 O10 O11 O12 O13 anymore
        assertFalse(gameService.existsInHand(player3, "O7 O8 O9 O10 O11 O12 O13".split(" ")));
        // ensuring the board contains the meld O7 O8 O9 O10 O11 O12 O13 now
        assertTrue(currentGame.getBoard().toString().contains("O7, O8, O9, O10, O11, O12, O13"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // player 1 draws
        gameService.executeTurn("draw");
        // ensuring player 1 has 15 tiles and the remaining tiles are 63 
        assertEquals(11, player1.getInHand().size());
        assertEquals(63, currentGame.getTilesRemaining().size());
        // board size should not change since last turn
        assertEquals(3, currentGame.getBoard().size());

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 breaks the meld {R11 O11 B11 G11} into {R11} {O11 B11 G11}
        gameService.executeTurn("break 1 at R11");
        // as a meld has been broken into two, board size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());
        // player 2 adds B11 G11 with {R11} to form {B11 G11 R11}
        gameService.executeTurn("add B11 G11 to 3 at head");
        // ensuring player 2 does not have B11 G11 anymore
        assertFalse(gameService.existsInHand(player3, "B11 G11".split(" ")));
        // tiles have been added to an existing meld, so board size should remain same
        assertEquals(4, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row91Tests() {
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
        gameService.placeInHand(player1, "R11 O11 B11 G11");
        gameService.placeInHand(player2, "R12 B12 G12");
        gameService.placeInHand(player3, "O7 O8 O9 O10 O11 O12 O13");
        gameService.placeInHand(player2, "R12 R13");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 playing the meld R11 O11 B11 G11
        gameService.executeTurn("play R11 O11 B11 G11");
        // ensuring player 1 does not have R11 O11 B11 G11 anymore
        assertFalse(gameService.existsInHand(player1, "R11 O11 B11 G11".split(" ")));
        // ensuring the board contains the meld R11 O11 B11 G11 now
        assertTrue(currentGame.getBoard().toString().contains("R11, O11, B11, G11"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld R12 B12 G12
        gameService.executeTurn("play R12 B12 G12");
        // ensuring player 2 does not have R12 B12 G12 anymore
        assertFalse(gameService.existsInHand(player2, "R12 B12 G12".split(" ")));
        // ensuring the board contains the meld R12 B12 G12 now
        assertTrue(currentGame.getBoard().toString().contains("R12, B12, G12"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O7 O8 O9 O10 O11 O12 O13
        assertFalse(currentGame.getBoard().toString().contains("O7, O8, O9, O10, O11, O12, O13"));
        // player 3 playing the meld O7 O8 O9 O10 O11 O12 O13
        gameService.executeTurn("play O7 O8 O9 O10 O11 O12 O13");
        // ensuring player 3 does not have O7 O8 O9 O10 O11 O12 O13 anymore
        assertFalse(gameService.existsInHand(player3, "O7 O8 O9 O10 O11 O12 O13".split(" ")));
        // ensuring the board contains the meld O7 O8 O9 O10 O11 O12 O13 now
        assertTrue(currentGame.getBoard().toString().contains("O7, O8, O9, O10, O11, O12, O13"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // player 1 draws
        gameService.executeTurn("draw");
        // ensuring player 1 has 15 tiles and the remaining tiles are 63 
        assertEquals(11, player1.getInHand().size());
        assertEquals(63, currentGame.getTilesRemaining().size());
        // board size should not change since last turn
        assertEquals(3, currentGame.getBoard().size());

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 breaks the meld {R11 O11 B11 G11} into {R11} {O11 B11 G11}
        gameService.executeTurn("break 1 at R11");
        // as a meld has been broken into two, board size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());
        // player 2 adds R12 R13 with {R11} to form {R11 R12 R13}
        gameService.executeTurn("add R12 R13 to 3 at tail");
        // ensuring player 2 does not have R12 R13 anymore
        assertFalse(gameService.existsInHand(player2, "R12 R13".split(" ")));
        // tiles have been added to an existing meld, so board size should remain same
        assertEquals(4, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row97Tests() {
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
        gameService.placeInHand(player1, "R11 O11 B11 G11");
        gameService.placeInHand(player2, "R12 B12 G12");
        gameService.placeInHand(player3, "O7 O8 O9 O10 O11 O12 O13");
        gameService.placeInHand(player1, "B7 R7");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 playing the meld R11 O11 B11 G11
        gameService.executeTurn("play R11 O11 B11 G11");
        // ensuring player 1 does not have R11 O11 B11 G11 anymore
        assertFalse(gameService.existsInHand(player1, "R11 O11 B11 G11".split(" ")));
        // ensuring the board contains the meld R11 O11 B11 G11 now
        assertTrue(currentGame.getBoard().toString().contains("R11, O11, B11, G11"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld R12 B12 G12
        gameService.executeTurn("play R12 B12 G12");
        // ensuring player 2 does not have R12 B12 G12 anymore
        assertFalse(gameService.existsInHand(player2, "R12 B12 G12".split(" ")));
        // ensuring the board contains the meld R12 B12 G12 now
        assertTrue(currentGame.getBoard().toString().contains("R12, B12, G12"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O7 O8 O9 O10 O11 O12 O13
        assertFalse(currentGame.getBoard().toString().contains("O7, O8, O9, O10, O11, O12, O13"));
        // player 3 playing the meld O7 O8 O9 O10 O11 O12 O13
        gameService.executeTurn("play O7 O8 O9 O10 O11 O12 O13");
        // ensuring player 3 does not have O7 O8 O9 O10 O11 O12 O13 anymore
        assertFalse(gameService.existsInHand(player3, "O7 O8 O9 O10 O11 O12 O13".split(" ")));
        // ensuring the board contains the meld O7 O8 O9 O10 O11 O12 O13 now
        assertTrue(currentGame.getBoard().toString().contains("O7, O8, O9, O10, O11, O12, O13"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");


        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 breaks the meld {O7 O8 O9 O10 O11 O12 O13} into {O7} {O8 O9 O10 O11 O12 O13}
        gameService.executeTurn("break 3 at O7");
        // as a meld has been broken into two, board size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());
        // player 1 adds B7 R7 with {O7} to form {O7 B7 R7}
        gameService.executeTurn("add B7 R7 to 3 at tail");
        // ensuring player 1 does not have B7 R7 anymore
        assertFalse(gameService.existsInHand(player1, "B7 R7".split(" ")));
        // tiles have been added to an existing meld, so board size should remain same
        assertEquals(4, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row99Tests() {
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
        gameService.placeInHand(player1, "R11 O11 B11 G11");
        gameService.placeInHand(player2, "R12 B12 G12");
        gameService.placeInHand(player3, "O7 O8 O9 O10 O11 O12 O13");
        gameService.placeInHand(player1, "R13 B13");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 playing the meld R11 O11 B11 G11
        gameService.executeTurn("play R11 O11 B11 G11");
        // ensuring player 1 does not have R11 O11 B11 G11 anymore
        assertFalse(gameService.existsInHand(player1, "R11 O11 B11 G11".split(" ")));
        // ensuring the board contains the meld R11 O11 B11 G11 now
        assertTrue(currentGame.getBoard().toString().contains("R11, O11, B11, G11"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld R12 B12 G12
        gameService.executeTurn("play R12 B12 G12");
        // ensuring player 2 does not have R12 B12 G12 anymore
        assertFalse(gameService.existsInHand(player2, "R12 B12 G12".split(" ")));
        // ensuring the board contains the meld R12 B12 G12 now
        assertTrue(currentGame.getBoard().toString().contains("R12, B12, G12"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O7 O8 O9 O10 O11 O12 O13
        assertFalse(currentGame.getBoard().toString().contains("O7, O8, O9, O10, O11, O12, O13"));
        // player 3 playing the meld O7 O8 O9 O10 O11 O12 O13
        gameService.executeTurn("play O7 O8 O9 O10 O11 O12 O13");
        // ensuring player 3 does not have O7 O8 O9 O10 O11 O12 O13 anymore
        assertFalse(gameService.existsInHand(player3, "O7 O8 O9 O10 O11 O12 O13".split(" ")));
        // ensuring the board contains the meld O7 O8 O9 O10 O11 O12 O13 now
        assertTrue(currentGame.getBoard().toString().contains("O7, O8, O9, O10, O11, O12, O13"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");


        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 breaks the meld {O7 O8 O9 O10 O11 O12 O13} into {O7 O8 O9 O10 O11 O12} {O13}
        gameService.executeTurn("break 3 at O12");
        // as a meld has been broken into two, board size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());
        // player 1 adds R13 B13 with {O13} to form {R13 B13 O13}
        gameService.executeTurn("add R13 B13 to 4 at head");
        // ensuring player 1 does not have R13 B13 anymore
        assertFalse(gameService.existsInHand(player1, "R13 B13".split(" ")));
        // tiles have been added to an existing meld, so board size should remain same
        assertEquals(4, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row103Tests() {
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
        gameService.placeInHand(player1, "R11 O11 B11 G11");
        gameService.placeInHand(player2, "R12 B12 G12");
        gameService.placeInHand(player3, "O7 O8 O9 O10 O11 O12 O13");
        gameService.placeInHand(player1, "O8 O9");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 playing the meld R11 O11 B11 G11
        gameService.executeTurn("play R11 O11 B11 G11");
        // ensuring player 1 does not have R11 O11 B11 G11 anymore
        assertFalse(gameService.existsInHand(player1, "R11 O11 B11 G11".split(" ")));
        // ensuring the board contains the meld R11 O11 B11 G11 now
        assertTrue(currentGame.getBoard().toString().contains("R11, O11, B11, G11"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld R12 B12 G12
        gameService.executeTurn("play R12 B12 G12");
        // ensuring player 2 does not have R12 B12 G12 anymore
        assertFalse(gameService.existsInHand(player2, "R12 B12 G12".split(" ")));
        // ensuring the board contains the meld R12 B12 G12 now
        assertTrue(currentGame.getBoard().toString().contains("R12, B12, G12"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld O7 O8 O9 O10 O11 O12 O13
        assertFalse(currentGame.getBoard().toString().contains("O7, O8, O9, O10, O11, O12, O13"));
        // player 3 playing the meld O7 O8 O9 O10 O11 O12 O13
        gameService.executeTurn("play O7 O8 O9 O10 O11 O12 O13");
        // ensuring player 3 does not have O7 O8 O9 O10 O11 O12 O13 anymore
        assertFalse(gameService.existsInHand(player3, "O7 O8 O9 O10 O11 O12 O13".split(" ")));
        // ensuring the board contains the meld O7 O8 O9 O10 O11 O12 O13 now
        assertTrue(currentGame.getBoard().toString().contains("O7, O8, O9, O10, O11, O12, O13"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 breaks the meld {O7 O8 O9 O10 O11 O12 O13} into {O7 O8 O9} {O10 O11 O12 O13}
        gameService.executeTurn("break 3 at O9");
        // player 1 breaks the meld {O10 O11 O12 O13} into {O10} {O11 O12 O13}
        gameService.executeTurn("break 4 at O10");
        // as a meld has been broken into three, board size should increase from 3 to 5
        assertEquals(5, currentGame.getBoard().size());
        // player 1 adds O8 O9 with {O10} to form {O8 O9 O13}
        gameService.executeTurn("add O8 O9 to 4 at head");
        // ensuring player 1 does not have O8 O9 anymore
        assertFalse(gameService.existsInHand(player1, "O8 O9".split(" ")));
        // tiles have been added to an existing meld, so board size should remain same
        assertEquals(5, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row111Tests() {
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
        gameService.placeInHand(player1, "R11 O11 B11 G11 O4 R4 R8");
        gameService.placeInHand(player2, "R12 B12 G12");
        gameService.placeInHand(player3, "R4 G4 B4 R5 R6 R7");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 playing the meld R11 O11 B11 G11
        gameService.executeTurn("play R11 O11 B11 G11");
        // ensuring player 1 does not have R11 O11 B11 G11 anymore
        assertFalse(gameService.existsInHand(player1, "R11 O11 B11 G11".split(" ")));
        // ensuring the board contains the meld R11 O11 B11 G11 now
        assertTrue(currentGame.getBoard().toString().contains("R11, O11, B11, G11"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld R12 B12 G12
        gameService.executeTurn("play R12 B12 G12");
        // ensuring player 2 does not have R12 B12 G12 anymore
        assertFalse(gameService.existsInHand(player2, "R12 B12 G12".split(" ")));
        // ensuring the board contains the meld R12 B12 G12 now
        assertTrue(currentGame.getBoard().toString().contains("R12, B12, G12"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R4 G4 B4
        assertFalse(currentGame.getBoard().toString().contains("R4, G4, B4"));
        // player 3 playing the meld R4 G4 B4
        gameService.executeTurn("play R4 G4 B4");
        // ensuring player 3 does not have R4 G4 B4 anymore
        assertFalse(gameService.existsInHand(player3, "R4 G4 B4".split(" ")));
        // ensuring the board contains the meld R4 G4 B4 now
        assertTrue(currentGame.getBoard().toString().contains("R4, G4, B4"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());

        // ensuring current player is still player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R5 R6 R7
        assertFalse(currentGame.getBoard().toString().contains("R5, R6, R7"));
        // player 3 playing the meld R5 R6 R7
        gameService.executeTurn("play R5 R6 R7");
        // ensuring player 3 does not have R5 R6 R7 anymore
        assertFalse(gameService.existsInHand(player3, "R5 R6 R7".split(" ")));
        // ensuring the board contains the meld R5 R6 R7 now
        assertTrue(currentGame.getBoard().toString().contains("R5, R6, R7"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(4, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 adds O4 with {R4 G4 B4} to form {O4 R4 G4 B4}
        gameService.executeTurn("add O4 to 3 at head");
        // player 1 adds R4 with {R5 R6 R7} to form {R4 R5 R6 R7}
        gameService.executeTurn("add R4 to 4 at head");
        // player 1 adds R8 with {R4 R5 R6 R7} to form {R4 R5 R6 R7 R8}
        gameService.executeTurn("add R8 to 4 at tail");
        // ensuring player 1 does not have O4 R4 R8 anymore
        assertFalse(gameService.existsInHand(player1, "O4 R4 R8".split(" ")));
        // ensuring the board contains the meld O4 R4 G4 B4 now
        assertTrue(currentGame.getBoard().toString().contains("O4, R4, G4, B4"));
        // ensuring the board contains the meld R4 R5 R6 R7 R8 now
        assertTrue(currentGame.getBoard().toString().contains("R4, R5, R6, R7, R8"));
        // tiles have been added to an existing meld, so board size should remain same
        assertEquals(4, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row114Tests() {
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
        gameService.placeInHand(player1, "R11 O11 B11 G1 B12 B13");
        gameService.placeInHand(player2, "G11 G12 G13");
        gameService.placeInHand(player3, "R4 G4 B4 R5 R6 R7");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 playing the meld R11 O11 B11
        gameService.executeTurn("play R11 O11 B11");
        // ensuring player 1 does not have R11 O11 B11 anymore
        assertFalse(gameService.existsInHand(player1, "R11 O11 B11".split(" ")));
        // ensuring the board contains the meld R11 O11 B11 now
        assertTrue(currentGame.getBoard().toString().contains("R11, O11, B11"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld G11 G12 G13
        gameService.executeTurn("play G11 G12 G13");
        // ensuring player 2 does not have G11 G12 G13 anymore
        assertFalse(gameService.existsInHand(player2, "G11 G12 G13".split(" ")));
        // ensuring the board contains the meld G11 G12 G13 now
        assertTrue(currentGame.getBoard().toString().contains("G11, G12, G13"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R4 G4 B4
        assertFalse(currentGame.getBoard().toString().contains("R4, G4, B4"));
        // player 3 playing the meld R4 G4 B4
        gameService.executeTurn("play R4 G4 B4");
        // ensuring player 3 does not have R4 G4 B4 anymore
        assertFalse(gameService.existsInHand(player3, "R4 G4 B4".split(" ")));
        // ensuring the board contains the meld R4 G4 B4 now
        assertTrue(currentGame.getBoard().toString().contains("R4, G4, B4"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());

        // ensuring current player is still player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R5 R6 R7
        assertFalse(currentGame.getBoard().toString().contains("R5, R6, R7"));
        // player 3 playing the meld R5 R6 R7
        gameService.executeTurn("play R5 R6 R7");
        // ensuring player 3 does not have R5 R6 R7 anymore
        assertFalse(gameService.existsInHand(player3, "R5 R6 R7".split(" ")));
        // ensuring the board contains the meld R5 R6 R7 now
        assertTrue(currentGame.getBoard().toString().contains("R5, R6, R7"));
        // as a new meld has been added to board, it's size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 breaks the meld {G11 G12 G13} into {G11} {G12 G13}
        gameService.executeTurn("break 2 at G11");
        // as a meld has been broken into two, board size should increase from 4 to 5
        assertEquals(5, currentGame.getBoard().size());
        // player 1 merges meld {G11} with {R11 O11 B11} to form {G11 R11 O11 B11}
        gameService.executeTurn("merge 4 with 1 at tail");
        // ensuring the board contains the meld G11 R11 O11 B11 now
        assertTrue(currentGame.getBoard().toString().contains("G11, R11, O11, B11"));
        // player 1 adds G1 to {G12 G13} to form {G12 G13 G1}
        gameService.executeTurn("add G1 to 4 at tail");
        // ensuring the board contains the meld G12 G13 G1 now
        assertTrue(currentGame.getBoard().toString().contains("G12, G13, G1"));
        // player 1 breaks the meld {G11 R11 O11 B11} into {G11 R11 O11} {B11}
        gameService.executeTurn("break 3 at O11");
        // player 1 adds B12 B13 to {B11} to form {B11 B12 B13}
        gameService.executeTurn("add B12 B13 to 5 at tail");
        // ensuring the board contains the meld B11 B12 B13 now
        assertTrue(currentGame.getBoard().toString().contains("B11, B12, B13"));
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row119Tests() {
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
        gameService.placeInHand(player1, "O11 B11 G11 G10 B10 R13");
        gameService.placeInHand(player2, "O12 B12 G12");
        gameService.placeInHand(player3, "R7 R8 R9 R10 R11 R12");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 playing the meld O11 B11 G11
        gameService.executeTurn("play O11 B11 G11");
        // ensuring player 1 does not have O11 B11 G11 anymore
        assertFalse(gameService.existsInHand(player1, "O11 B11 G11".split(" ")));
        // ensuring the board contains the meld O11 B11 G11 now
        assertTrue(currentGame.getBoard().toString().contains("O11, B11, G11"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld O12 B12 G12
        gameService.executeTurn("play O12 B12 G12");
        // ensuring player 2 does not have O12 B12 G12 anymore
        assertFalse(gameService.existsInHand(player2, "O12 B12 G12".split(" ")));
        // ensuring the board contains the meld O12 B12 G12 now
        assertTrue(currentGame.getBoard().toString().contains("O12, B12, G12"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");
        
        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // ensuring the board does not contain the meld R7 R8 R9 R10 R11 R12
        assertFalse(currentGame.getBoard().toString().contains("R7, R8, R9, R10, R11, R12"));
        // player 3 playing the meld R7 R8 R9 R10 R11 R12
        gameService.executeTurn("play R7 R8 R9 R10 R11 R12");
        // ensuring player 3 does not have R7 R8 R9 R10 R11 R12 anymore
        assertFalse(gameService.existsInHand(player3, "R7 R8 R9 R10 R11 R12".split(" ")));
        // ensuring the board contains the meld R7 R8 R9 R10 R11 R12 now
        assertTrue(currentGame.getBoard().toString().contains("R7, R8, R9, R10, R11, R12"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 3 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 breaks the meld {R7 R8 R9 R10 R11 R12} into {R7 R8 R9} {R10 R11 R12}
        gameService.executeTurn("break 3 at R9");
        // as a meld has been broken into two, board size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());
        // player 1 breaks the meld {R7 R8 R9 R10 R11 R12} into {R7 R8 R9} {R10 R11 R12}
        gameService.executeTurn("break 4 at R10");
        // player 1 adds G10 B10 to {R10} to form {R10 G10 B10}
        gameService.executeTurn("add G10 B10 to 4 at tail");
        // ensuring the board contains the meld R10 G10 B10 now
        assertTrue(currentGame.getBoard().toString().contains("R10, G10, B10"));
        // player 1 adds R13 to {R11 R12} to form {R11 R12 R13}
        gameService.executeTurn("add R13 to 5 at tail");
        // ensuring the board contains the meld R11 R12 R13 now
        assertTrue(currentGame.getBoard().toString().contains("R11, R12, R13"));
        // player 1 ends turn
        gameService.executeTurn("end");
    }

    @Test
    public void row125Tests() {
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
        gameService.placeInHand(player1, "R11 B11 G11 R3 R4 R5 B1 B2 B3 B4 G4 B4 O5 O13");
        gameService.placeInHand(player2, "O1 O2 O3 O4 R3 O3 B3 G3 G3 G4 G5");

        // distributing tiles randomly so every player has 14 tiles and no tile can be reused
        gameService.startGame();

        // ensuring each player has 14 tiles and the remaining tiles are 64 
        assertEquals(14, player1.getInHand().size());
        assertEquals(14, player2.getInHand().size());
        assertEquals(14, player3.getInHand().size());
        assertEquals(64, currentGame.getTilesRemaining().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 playing the meld R11 B11 G11
        gameService.executeTurn("play R11 B11 G11");
        // ensuring player 1 does not have R11 B11 G11 anymore
        assertFalse(gameService.existsInHand(player1, "R11 B11 G11".split(" ")));
        // ensuring the board contains the meld R11 B11 G11 now
        assertTrue(currentGame.getBoard().toString().contains("R11, B11, G11"));
        // as a new meld has been added to board, it's size should increase from 0 to 1
        assertEquals(1, currentGame.getBoard().size());

        // ensuring current player is still player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 playing the meld R3 R4 R5
        gameService.executeTurn("play R3 R4 R5");
        // ensuring player 1 does not have R3 R4 R5 anymore
        assertFalse(gameService.existsInHand(player1, "R3 R4 R5".split(" ")));
        // ensuring the board contains the meld R3 R4 R5 now
        assertTrue(currentGame.getBoard().toString().contains("R3, R4, R5"));
        // as a new meld has been added to board, it's size should increase from 1 to 2
        assertEquals(2, currentGame.getBoard().size());

        // ensuring current player is still player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 playing the meld B1 B2 B3 B4
        gameService.executeTurn("play B1 B2 B3 B4");
        // ensuring player 1 does not have B1 B2 B3 B4 anymore
        assertFalse(gameService.existsInHand(player1, "B1 B2 B3 B4".split(" ")));
        // ensuring the board contains the meld B1 B2 B3 B4 now
        assertTrue(currentGame.getBoard().toString().contains("B1, B2, B3, B4"));
        // as a new meld has been added to board, it's size should increase from 2 to 3
        assertEquals(3, currentGame.getBoard().size());
        // player 1 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld O1 O2 O3 O4
        gameService.executeTurn("play O1 O2 O3 O4");
        // ensuring player 2 does not have O1 O2 O3 O4 anymore
        assertFalse(gameService.existsInHand(player2, "O1 O2 O3 O4".split(" ")));
        // ensuring the board contains the meld O1 O2 O3 O4 now
        assertTrue(currentGame.getBoard().toString().contains("O1, O2, O3, O4"));
        // as a new meld has been added to board, it's size should increase from 3 to 4
        assertEquals(4, currentGame.getBoard().size());

        // ensuring current player is still player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld R3 O3 B3 G3
        gameService.executeTurn("play R3 O3 B3 G3");
        // ensuring player 2 does not have R3 O3 B3 G3 anymore
        assertFalse(gameService.existsInHand(player2, "R3 O3 B3 G3".split(" ")));
        // ensuring the board contains the meld R3 O3 B3 G3 now
        assertTrue(currentGame.getBoard().toString().contains("R3, O3, B3, G3"));
        // as a new meld has been added to board, it's size should increase from 4 to 5
        assertEquals(5, currentGame.getBoard().size());

        // ensuring current player is still player 2
        assertEquals(2, currentGame.getCurrentPlayer());
        // player 2 playing the meld G3 G4 G5
        gameService.executeTurn("play G3 G4 G5");
        // ensuring player 2 does not have G3 G4 G5 anymore
        assertFalse(gameService.existsInHand(player2, "G3 G4 G5".split(" ")));
        // ensuring the board contains the meld G3 G4 G5 now
        assertTrue(currentGame.getBoard().toString().contains("G3, G4, G5"));
        // as a new meld has been added to board, it's size should increase from 5 to 6
        assertEquals(6, currentGame.getBoard().size());
        // player 2 ends turn
        gameService.executeTurn("end");

        // ensuring current player is player 3
        assertEquals(3, currentGame.getCurrentPlayer());
        // player 3 draws
        gameService.executeTurn("draw");
        // ensuring player 3 has 15 tiles and the remaining tiles are 63 
        assertEquals(15, player3.getInHand().size());
        assertEquals(63, currentGame.getTilesRemaining().size());
        // ensuring board is unchanged
        assertEquals(6, currentGame.getBoard().size());

        // ensuring current player is player 1
        assertEquals(1, currentGame.getCurrentPlayer());
        // player 1 breaks the meld {O1 O2 O3 O4} into {O1 O2 O3} {O4}
        gameService.executeTurn("break 4 at O3");
        // as a meld has been broken into two, board size should increase from 6 to 7
        assertEquals(7, currentGame.getBoard().size());
        // player 1 adds G4 B4 to {O4} to form {O4 G4 B4}
        gameService.executeTurn("add G4 B4 to 7 at tail");
        // ensuring the board contains the meld R10 G10 B10 now
        assertTrue(currentGame.getBoard().toString().contains("O4, G4, B4"));
        // player 1 adds O13 to {O1 O2 O3} to form {O13 O1 O2 O3}
        gameService.executeTurn("add O13 to 6 at head");
        // ensuring the board contains the meld O13 O1 O2 O3 now
        assertTrue(currentGame.getBoard().toString().contains("O13, O1, O2, O3"));
        // player 1 breaks the meld {R3 R4 R5} into {R3 R4} {R5}
        gameService.executeTurn("break 2 at R4");
        // as a meld has been broken into two, board size should increase from 7 to 8
        assertEquals(8, currentGame.getBoard().size());
        // player 1 breaks the meld {G3 G4 G5} into {G3 G4} {G5}
        gameService.executeTurn("break 4 at G4");
        // as a meld has been broken into two, board size should increase from 8 to 9
        assertEquals(9, currentGame.getBoard().size());
        // player 1 adds O5 to {R5} to form {O5 R5}
        gameService.executeTurn("add O5 to 7 at head");
        // ensuring the board contains the meld O13 O1 O2 O3 now
        assertTrue(currentGame.getBoard().toString().contains("O5, R5"));
        // player 1 merges {O5 R5} with {G5} to form {O5 R5 G5}
        gameService.executeTurn("merge 7 with 9 at tail");
        // ensuring the board contains the meld O5 R5 G5 now
        assertTrue(currentGame.getBoard().toString().contains("O5, R5, G5"));
        // player 1 breaks the meld {R3 R4} into {R3} {R4}
        gameService.executeTurn("break 6 at R3");
        // as a meld has been broken into two, board size should increase from 8 to 9
        assertEquals(9, currentGame.getBoard().size());
        // player 1 breaks the meld {G3 G4} into {G3} {G4}
        gameService.executeTurn("break 7 at G3");
        // as a meld has been broken into two, board size should increase from 9 to 10
        assertEquals(10, currentGame.getBoard().size());
        // player 1 merges {R4} with {G4} to form {R4 G4}
        gameService.executeTurn("merge 8 with 10 at tail");
        // ensuring the board contains the meld R4 G4 now
        assertTrue(currentGame.getBoard().toString().contains("R4, G4"));
        // player 1 breaks the meld {B1 B2 B3 B4} into {B1 B2 B3} {B4}
        gameService.executeTurn("break 2 at B3");
        // as a meld has been broken into two, board size should increase from 9 to 10
        assertEquals(10, currentGame.getBoard().size());
        // player 1 merges {R4 G4} with {B4} to form {R4 G4 B4}
        gameService.executeTurn("merge 7 with 10 at tail");
        // ensuring the board contains the meld R4 G4 B4 now
        assertTrue(currentGame.getBoard().toString().contains("R4, G4, B4"));
        // player 1 breaks the meld {R3 O3 B3 G3} into {R3 O3} {B3 G3}
        gameService.executeTurn("break 2 at O3");
        // as a meld has been broken into two, board size should increase from 9 to 10
        assertEquals(10, currentGame.getBoard().size());
        // player 1 merges {R3} with {B3 G3} to form {R3 B3 G3}
        gameService.executeTurn("merge 5 with 10 at tail");
        // ensuring the board contains the meld R3 B3 G3 now
        assertTrue(currentGame.getBoard().toString().contains("R3, B3, G3"));
        // player 1 breaks the meld {R3 O3} into {R3} {O3}
        gameService.executeTurn("break 9 at R3");
        // as a meld has been broken into two, board size should increase from 9 to 10
        assertEquals(10, currentGame.getBoard().size());
        // player 1 merges {O3} with {R3} to form {O3 R3}
        gameService.executeTurn("merge 10 with 9 at tail");
        // ensuring the board contains the meld O3 R3 now
        assertTrue(currentGame.getBoard().toString().contains("O3, R3"));
        // player 1 merges {O3 R3} with {G3} to form {O3 R3 G3}
        gameService.executeTurn("merge 7 with 9 at head");
        // ensuring the board contains the meld O3 R3 G3 now
        assertTrue(currentGame.getBoard().toString().contains("O3, R3, G3"));
        // player 1 ends turn
        gameService.executeTurn("end");
    }
}
