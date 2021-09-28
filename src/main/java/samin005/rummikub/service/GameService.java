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
    private final Game currentGame;

    public GameService() {
        this.currentGame = new Game();
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
            updateGameStatus();
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
        updateGameStatus();
        if (currentGame.getTotalPlayers() == MAX_PLAYERS) {
            distributeTiles();
        }
        return currentGame;
    }

    private void updateGameStatus() {
        if(currentGame.getTotalPlayers() == MAX_PLAYERS) {
            currentGame.setStatus("Starting game...");
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

    private void distributeTiles() {
        for(Player player : currentGame.getPlayerList()) {
            for(int i = 0; i < TILES_PER_PLAYER; i++)
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
        ArrayList<String> tempInHand = new ArrayList<>(TILES_PER_PLAYER);
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
        return new Game();
    }

    public void placeInHand (Player player, String tiles) {

    }
}
