package samin005.rummikub.model;

import java.util.ArrayList;

public class Player {
    private int playerNo;
    private ArrayList<String> inHand = new ArrayList<>();
    private boolean isInitialTurn = true;

    public int getPlayerNo() {
        return playerNo;
    }

    public void setPlayerNo(int playerNo) {
        this.playerNo = playerNo;
    }

    public ArrayList<String> getInHand() {
        return inHand;
    }

    public void addTileInHand(String tile) {
        inHand.add(tile);
    }

    public void setInHand(ArrayList<String> inHand) {
        this.inHand = inHand;
    }

    public boolean isInitialTurn() {
        return isInitialTurn;
    }

    public void setInitialTurn(boolean initialTurn) {
        isInitialTurn = initialTurn;
    }
}
