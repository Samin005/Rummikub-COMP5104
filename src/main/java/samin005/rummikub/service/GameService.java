package samin005.rummikub.service;

import org.springframework.stereotype.Service;
import samin005.rummikub.model.Game;
import samin005.rummikub.model.Player;


import java.util.ArrayList;
import java.util.Collections;

@Service
public class GameService {

    private final int MAX_PLAYERS = 3;
    private final int TOTAL_TILES = 104;
    private final int TILES_PER_PLAYER = 14;
    private final String GAME_INSTRUCTIONS = "-To draw a tile, input command: draw\n" +
            "-To play meld from hand, input command: play <tiles with spaces> (for example: play R1 R2 R3)\n" +
            "To end turn, input command: end\n" +
            "   --------   \n";
    private final Game currentGame;
    private ArrayList<ArrayList<String>> tempBoardState;
    private ArrayList<String> tempInHandState;

    public GameService() {
        this.currentGame = new Game();
        this.tempBoardState = (ArrayList<ArrayList<String>>) currentGame.getBoard().clone();
        this.tempInHandState = new ArrayList<>();
    }

    public String joinGame() {
        int totalPlayers = currentGame.getTotalPlayers();
        if(totalPlayers < MAX_PLAYERS) {
            Player player = new Player();
            player.setPlayerNo(totalPlayers + 1);
            currentGame.addPlayerToList(player);
            if(totalPlayers + 1 == 1) {
                currentGame.setTilesRemaining(createTiles());
                currentGame.setCurrentPlayer(1);
            }
            currentGame.setTotalPlayers(totalPlayers + 1);
            return "Player "+player.getPlayerNo()+" has joined the game.";
        }
        else {
            return MAX_PLAYERS + " players are already playing, please wait for them to finish";
        }
    }

    private ArrayList<String> createTiles() {
        ArrayList<String> tiles = new ArrayList<>(TOTAL_TILES);
        String[] colors = {"R", "B", "G", "O",
                "R", "B", "G", "O"};
        for(String color: colors) {
            for(int i=1; i<=13; i++) {
                tiles.add(color + i);
            }
        }
        return tiles;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public Game startGame() {
        if (currentGame.getTotalPlayers() == MAX_PLAYERS) {
            distributeTiles();
            updateGameStatus();
            updateTempGameState();
        }
        else updateGameStatus();
        return currentGame;
    }

    private void updateGameStatus() {
        if(currentGame.getTotalPlayers() == MAX_PLAYERS) {
            String status = addGameInfoAndInstructions();
            System.out.println(status);
            currentGame.setStatus(status);
        }
        else {
            if (currentGame.getTotalPlayers() == MAX_PLAYERS-1){
                currentGame.setStatus("1 player yet to join...");
            }
            else {
                currentGame.setStatus((MAX_PLAYERS - currentGame.getTotalPlayers())+ " players yet to join...");
            }
        }
    }

    private String boardInDisplay() {
        String result = "\n";
        ArrayList<ArrayList<String>> board = currentGame.getBoard();
        for(int i=0; i < board.size(); i++) {
            String temp = board.get(i).toString();
            temp = temp.replace("[", "{");
            temp = temp.replace("]", "}");
            temp = temp.replaceAll(",", "");
            result += (i+1) + ". ";
            if(i >= tempBoardState.size()) {
                result += "*" + temp + "\n";
            }
            else result += temp + "\n";
        }
        return result;
    }

    private String addGameInfoAndInstructions() {
        String status = "Player " + currentGame.getCurrentPlayer() + "'s turn.\n";
        status += "board: " + boardInDisplay() + "\n";
        status += "Player " + currentGame.getCurrentPlayer() + "'s tiles: " + currentGame.getPlayerByNumber(currentGame.getCurrentPlayer()).getInHand().toString() + "\n";
        status += "Instructions: \n";
        status += GAME_INSTRUCTIONS;
        return status;
    }

    private void distributeTiles() {
        for(Player player : currentGame.getPlayerList()) {
            while(player.getInHand().size() < TILES_PER_PLAYER)
                distributeTilesToPlayer(player.getPlayerNo());
            player.setInHand(sortInHandTiles(player.getInHand()));
        }

    }

    private void distributeTilesToPlayer(int playerNo) {
        Player player = currentGame.getPlayerByNumber(playerNo);
        int randomIndex = getRandomNumber(0, currentGame.getTilesRemaining().size());
        player.addTileInHand(currentGame.getTilesRemaining().get(randomIndex));
        currentGame.getTilesRemaining().remove(randomIndex);
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private ArrayList<String> sortInHandTiles(ArrayList<String> inHand) {
        inHand = makeAllTiles2Digits(inHand);
        Collections.sort(inHand);
        inHand = removeAddedDigits(inHand);
        ArrayList<String> tempInHand = new ArrayList<>();
        for(String tile:inHand){
            if (tile.startsWith("R"))
                tempInHand.add(tile);
        }
        for(String tile:inHand){
            if (tile.startsWith("B"))
                tempInHand.add(tile);
        }
        for(String tile:inHand){
            if (tile.startsWith("G"))
                tempInHand.add(tile);
        }
        for(String tile:inHand){
            if (tile.startsWith("O"))
                tempInHand.add(tile);
        }
        return tempInHand;
    }

    private ArrayList<String> makeAllTiles2Digits(ArrayList<String> inHand) {
        for(int i=0; i<inHand.size(); i++) {
            String tile = inHand.get(i);
            if(tile.length() < 3) {
                tile = tile.charAt(0) + "0" + tile.charAt(1);
                inHand.set(i, tile);
            }
        }
        return inHand;
    }

    private ArrayList<String> removeAddedDigits(ArrayList<String> inHand) {
        for(int i=0; i<inHand.size(); i++) {
            String tile = inHand.get(i);
            if(tile.charAt(1) == '0') {
                tile = "" + tile.charAt(0) + tile.charAt(2);
                inHand.set(i, tile);
            }
        }
        return inHand;
    }

    public Game executeTurn (String command){
        System.out.println("## Command entered by player: " + command + "\n");
        if(currentGame.getTotalPlayers() == MAX_PLAYERS) {
            Player player = currentGame.getPlayerByNumber(currentGame.getCurrentPlayer());
            if (command.equalsIgnoreCase("draw")) {
                distributeTilesToPlayer(player.getPlayerNo());
                player.setInHand(sortInHandTiles(player.getInHand()));
                updateCurrentPlayerNo();
                updateGameStatus();
                updateTempGameState();
            }
            else if (command.toLowerCase().startsWith("play")) {
                ArrayList<ArrayList<String>> board = currentGame.getBoard();
                String[] commandTiles = command.split(" ", 2);
                String[] tiles = commandTiles[1].split(" ");
                if(player.isInitialTurn()) {
                    int initialPoints = player.getInitial30points();
                    initialPoints += getMeldScore(tiles);
                    player.setInitial30points(initialPoints);
                }
                updateBoardAndInHandTiles(board, player, tiles);
                updateGameStatus();
            }
            else if (command.equalsIgnoreCase("end")) {
                if(player.isInitialTurn()) {
                    if(player.getInitial30points() >= 30) {
                        updateCurrentPlayerNo();
                        updateGameStatus();
                        player.setInitialTurn(false);
                        updateTempGameState();
                    }
                    else {
                        returnGameToPreviousState();
                        currentGame.setStatus("You must score at least 30 in your initial turn \n" + addGameInfoAndInstructions());
                        System.out.println(currentGame.getStatus());
                    }
                }
                else {
                    updateCurrentPlayerNo();
                    updateGameStatus();
                    updateTempGameState();
                }
            }
            else {
                currentGame.setStatus("INVALID MOVE \n" + addGameInfoAndInstructions());
                System.out.println(currentGame.getStatus());
            }
        }
        else updateGameStatus();
        return currentGame;
    }

    private void returnGameToPreviousState() {
        currentGame.setBoard((ArrayList<ArrayList<String>>) tempBoardState.clone());
        currentGame.getPlayerByNumber(currentGame.getCurrentPlayer()).setInHand((ArrayList<String>) tempInHandState.clone());
    }

    private void updateTempGameState() {
        tempBoardState = (ArrayList<ArrayList<String>>) currentGame.getBoard().clone();
        tempInHandState = (ArrayList<String>) currentGame.getPlayerByNumber(currentGame.getCurrentPlayer()).getInHand().clone();
    }

    private void updateBoardAndInHandTiles(ArrayList<ArrayList<String>> board, Player player, String[] tiles) {
        ArrayList<String> melds = new ArrayList<>();
        for(String tile: tiles) {
            melds.add(tile);
            player.getInHand().remove(tile);
        }
        board.add(melds);
    }

    private int getMeldScore(String[] meld) {
        int score = 0;
        for(String tile: meld) {
            score += getTileScore(tile);
        }
        return score;
    }

    private int getTileScore(String tile) {
        int score;
        String[] tileSeparated = tile.split("", 2);
        int tileNumber = Integer.parseInt(tileSeparated[1]);
        if(tileNumber >= 10){
            score = 10;
        }
        else score = tileNumber;
        return score;
    }

    public void placeInHand(Player player, String tiles) {
        String[] tilesToSet = tiles.split(" ");
        for(String tile: tilesToSet) {
            player.addTileInHand(tile);
            currentGame.getTilesRemaining().remove(tile);
        }
    }

    private void updateCurrentPlayerNo() {
        int currentPlayerNo = currentGame.getCurrentPlayer();
        if (currentPlayerNo == MAX_PLAYERS) {
            currentGame.setCurrentPlayer(1);
        }
        else currentGame.setCurrentPlayer(currentPlayerNo + 1);
    }
}
