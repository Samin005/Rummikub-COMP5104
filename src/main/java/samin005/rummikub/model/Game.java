package samin005.rummikub.model;

import java.util.ArrayList;

public class Game {
    private String status = "Waiting for players to join...";
    private int totalPlayers = 0;
    private int currentPlayer = 0;
    private ArrayList<Player> playerList = new ArrayList<>();
    private ArrayList<String> tilesRemaining;
    private ArrayList<ArrayList<String>> board = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getPlayerByNumber(int playerNo) {
        return playerList.get(playerNo-1);
    }

    public void addPlayerToList(Player player) {
        this.playerList.add(player);
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<String> getTilesRemaining() {
        return tilesRemaining;
    }

    public void setTilesRemaining(ArrayList<String> tilesRemaining) {
        this.tilesRemaining = tilesRemaining;
    }

    public ArrayList<ArrayList<String>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<String>> board) {
        this.board = board;
    }
}
