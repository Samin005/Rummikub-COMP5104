package samin005.rummikub.service;

import org.springframework.stereotype.Service;
import samin005.rummikub.model.Game;
import samin005.rummikub.model.Player;


import java.util.ArrayList;
import java.util.Collections;

@Service
public class GameService {

    private final int MAX_PLAYERS = 3;
    private final int TOTAL_TILES = 106;
    private final String JOKER = "*";
    private final String TILE_COLORS = "R B G O";
    private final int TILES_PER_PLAYER = 14;
    private final String GAME_INSTRUCTIONS = "-To draw a tile, input command: draw\n" +
            "-To play meld from hand, input command: play <tiles with spaces> (for example: play R1 R2 R3)\n" +
            "To end turn, input command: end\n" +
            "-To break a meld in board, input command: break <meld index> at <tile in meld> (for example: break 2 at R7\n" +
            "For example, if the board has: 1. {R10 R11 R12 R13}), the command 'break 1 at R11' would result in 1. {R10 R11} 2. {R12 R13}\n" +
            "-To add tile(s) in existing melds, input command: add <tile(s)> to <meld index> at head/tail\n" +
            "For example: if the board has: 1. {R10 R11 R12} 2. {O11 O12 O13}, the command 'add R8 R9 to 1 at head' would result in 1. {R8 R9 R10 R11 R12} 2. {O11 O12 O13}\n" +
            "-To merge melds in board, input command: merge <meld index> with <meld index> at head/tail\n" +
            "For example: if the board has: 1. {R10 R11} 2. {R12 R13}, the command 'merge 1 with 2 at head' would result in 1. {R10 R11 R12 R13}\n" +
            "-To replace Joker in board: 'replace joker at <meld index> <joker index> with <tile>'" +
            "For example: if the board has: 1. {R3 R4 * R6}, the command 'replace joker at 1 3 with R5' would result in 1. {R3 R4 R5 R6} 2. {*}\n" +
            "   --------   \n";
    private Game currentGame;
    private ArrayList<ArrayList<String>> tempBoardState;
    private ArrayList<String> tempInHandState;
    private ArrayList<ArrayList<String>> boardToDisplay;

    public GameService() {
        resetGame();
    }

    public Game joinGame() {
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
            currentGame.setStatus("Player "+player.getPlayerNo()+" has joined the game.");
            System.out.println(currentGame.getStatus());
            return currentGame;
        }
        else {
            currentGame.setStatus(MAX_PLAYERS + " players are already playing, please wait for them to finish");
            System.out.println(currentGame.getStatus());
            return currentGame;
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
        // adding 2 jokers
        tiles.add(JOKER);
        tiles.add(JOKER);
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
            if(currentGame.isGameOver()) {
                updateFinalScores();
                String status = "Player " + currentGame.getCurrentPlayer() + " has won the game!\n";
                status += "Player scores:\n";
                for(Player player: currentGame.getPlayerList()) {
                    status += "Player " + player.getPlayerNo() + ": " + player.getScore() + " (In Hand Tiles: " + player.getInHand() + ")\n";
                }
                System.out.println(status);
                currentGame.setStatus(status);
            }
            else {
                String status = addGameInfoAndInstructions();
                System.out.println(status);
                currentGame.setStatus(status);
            }
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

    private String getBoardToDisplay() {
        String result = "\n";
        for(int i=0; i < boardToDisplay.size(); i++) {
            result += (i+1) + ". { ";
            ArrayList<String> meld = boardToDisplay.get(i);
            for (String tile: meld) {
                result += tile + " ";
            }
            result += "}\n";
        }
        return result;
    }

    private String addGameInfoAndInstructions() {
        String status = "Player " + currentGame.getCurrentPlayer() + "'s turn.\n";
        status += "board: " + getBoardToDisplay() + "\n";
        status += "Player " + currentGame.getCurrentPlayer() + "'s tiles: " + currentGame.getPlayerByNumber(currentGame.getCurrentPlayer()).getInHand().toString() + "\n";
        status += "Instructions: \n";
        status += GAME_INSTRUCTIONS;
        return status;
    }

    private void distributeTiles() {
        for(Player player : currentGame.getPlayerList()) {
            while(player.getInHand().size() < TILES_PER_PLAYER)
                distributeTileToPlayer(player.getPlayerNo());
            player.setInHand(sortInHandTiles(player.getInHand()));
        }

    }

    private void distributeTileToPlayer(int playerNo) {
        Player player = currentGame.getPlayerByNumber(playerNo);
        int randomIndex = getRandomNumber(0, currentGame.getTilesRemaining().size());
        player.addTileInHand(currentGame.getTilesRemaining().get(randomIndex));
        currentGame.getTilesRemaining().remove(randomIndex);
    }

    private void draw3TilesPenalty(Player player) {
        int playerNo = player.getPlayerNo();
        for(int i=1; i<=3; i++) {
            distributeTileToPlayer(playerNo);
        }
        player.setInHand(sortInHandTiles(player.getInHand()));
        updateCurrentPlayerNo();
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
        for(String tile:inHand){
            if (tile.startsWith(JOKER))
                tempInHand.add(tile);
        }
        return tempInHand;
    }

    private ArrayList<String> makeAllTiles2Digits(ArrayList<String> inHand) {
        for(int i=0; i<inHand.size(); i++) {
            String tile = inHand.get(i);
            if(tile.length() != 1 && tile.length() < 3) {
                tile = tile.charAt(0) + "0" + tile.charAt(1);
                inHand.set(i, tile);
            }
        }
        return inHand;
    }

    private ArrayList<String> removeAddedDigits(ArrayList<String> inHand) {
        for(int i=0; i<inHand.size(); i++) {
            String tile = inHand.get(i);
            if(tile.length() != 1 && tile.charAt(1) == '0') {
                tile = "" + tile.charAt(0) + tile.charAt(2);
                inHand.set(i, tile);
            }
        }
        return inHand;
    }

    public Game executeTurn (String command){
        System.out.println("## Command entered by player: " + command + "\n");
        if(currentGame.getTotalPlayers() == MAX_PLAYERS) {
            if(!currentGame.isGameOver()) {
                Player player = currentGame.getPlayerByNumber(currentGame.getCurrentPlayer());
                if (command.equalsIgnoreCase("draw")) {
                    distributeTileToPlayer(player.getPlayerNo());
                    player.setInHand(sortInHandTiles(player.getInHand()));
                    updateCurrentPlayerNo();
                    updateGameStatus();
                    updateTempGameState();
                }
                else if (command.toLowerCase().startsWith("play")) {
                    ArrayList<ArrayList<String>> board = currentGame.getBoard();
                    String[] commandTiles = command.split(" ", 2);
                    String[] tiles = commandTiles[1].split(" ");
                    if(existsInHand(player, tiles)) {
                        if(isValidRun(tiles) || isValidSet(tiles)) {
                            if (player.isInitialTurn()) {
                                int initialPoints = player.getInitial30points();
                                initialPoints += getInitialMeldScore(tiles);
                                player.setInitial30points(initialPoints);
                            }
                            updateBoardAndInHandTiles(board, player, tiles);
                            updateGameStatus();
                        }
                        else printInvalidMove("INVALID! Not a valid meld.");
                    }
                    else printInvalidMove("INVALID! Tiles does not exist in hand.");
                }
                else if (command.toLowerCase().startsWith("break")) {
                    if (command.contains(" at ")) {
                        String[] splitCommand = command.split(" at ", 2);
                        String meldIndexString;
                        if (splitCommand[0].contains("break ")) {
                            meldIndexString = splitCommand[0].replace("break ", "");
                        }
                        else meldIndexString = splitCommand[0].replace("break", "");
                        if (isNumber(meldIndexString)) {
                            int meldIndex = Integer.parseInt(meldIndexString)-1;
                            ArrayList<ArrayList<String>> board = currentGame.getBoard();
                            ArrayList<String> meldToBreak = board.get(meldIndex);
                            if (meldToBreak.contains(splitCommand[1])) {
                                if(!meldToBreak.contains(JOKER)) {
                                    breakMeldAndUpdateBoard(meldIndex, splitCommand[1]);
                                    updateGameStatus();
                                }
                                else printInvalidMove("INVALID MOVE! You must replace the Joker with a tile from your hand before breaking.");
                            }
                            else printInvalidMove("INVALID COMMAND! Invalid tile in meld.");
                        }
                        else printInvalidMove("INVALID COMMAND! Invalid meld index.");
                    }
                    else printInvalidMove("INVALID COMMAND!");
                }
                else if (command.toLowerCase().startsWith("add")) {
                    if (command.contains(" to ")) {
                        String[] splitCommand = command.split(" to ", 2);
                        String tilesString = splitCommand[0].replace("add ", "");
                        String[] tiles = tilesString.split(" ");
                        String[] splitCommandEnd = splitCommand[1].split(" at ", 2);
                        String meldIndexString = splitCommandEnd[0];
                        String position = splitCommandEnd[1].toLowerCase();
                        if (existsInHand(player, tiles) && isNumber(meldIndexString) && (position.equals("head") || position.equals("tail"))) {
                            int meldIndex = Integer.parseInt(meldIndexString)-1;
                            if(meldIndex < currentGame.getBoard().size()) {
                                addTilesToExistingMeld(player, tiles, meldIndex, position);
                                updateGameStatus();
                            }
                            else printInvalidMove("INVALID COMMAND! Meld index not in board.");
                        }
                        else printInvalidMove("INVALID COMMAND!");
                    }
                    else printInvalidMove("INVALID COMMAND!");
                }
                else if (command.toLowerCase().startsWith("merge")) {
                    String[] splitCommand = command.split(" with ", 2);
                    String meldIndex1 = splitCommand[0].replace("merge ", "");
                    String[] splitCommandEnd = splitCommand[1].split(" at ", 2);
                    String meldIndex2 = splitCommandEnd[0];
                    String position = splitCommandEnd[1].toLowerCase();
                    if (isNumber(meldIndex1) && isNumber(meldIndex2) && !meldIndex1.equals(meldIndex2) && (position.equals("head") || position.equals("tail"))) {
                        int index1 = Integer.parseInt(meldIndex1)-1;
                        int index2 = Integer.parseInt(meldIndex2)-1;
                        ArrayList<ArrayList<String>> board = currentGame.getBoard();
                        if (index1 < board.size() && index2 < board.size()){
                            if(!board.get(index1).contains(JOKER) && !board.get(index2).contains(JOKER)) {
                                mergeMeldsInBoard(board, index1, index2, position);
                                updateGameStatus();
                            }
                            else printInvalidMove("INVALID MOVE! You must replace the Joker with a tile from your hand before merging.");
                        }
                        else printInvalidMove("INVALID COMMAND! Meld indexes not in board.");
                    }
                    else printInvalidMove("INVALID COMMAND!");
                }
                else if (command.toLowerCase().startsWith("replace joker at")) {
                    String commandString = command.replace("replace joker at", "").trim();
                    String[] splitCommand = commandString.split(" with ", 2);
                    String[] indexes = splitCommand[0].split(" ", 2);
                    String meldIndexString = indexes[0];
                    String jokerIndexString = indexes[1];
                    String replacingTile = splitCommand[1];
                    if (isNumber(meldIndexString) && isNumber(jokerIndexString)) {
                        int meldIndex = Integer.parseInt(meldIndexString)-1;
                        int jokerIndex = Integer.parseInt(jokerIndexString)-1;
                        ArrayList<ArrayList<String>> board = currentGame.getBoard();
                        if (meldIndex < board.size()){
                            if(board.get(meldIndex).contains(JOKER)) {
                                ArrayList<String> meld = board.get(meldIndex);
                                if(meld.get(jokerIndex).equals(JOKER) && !meld.toString().equals("[" + JOKER + "]")) {
                                    if(!replacingTile.contains(" ") && !(replacingTile.length() > 3) && existsInHand(player, replacingTile.split(" ", 1))) {
                                        replaceJoker(board, meldIndex, jokerIndex, replacingTile);
                                        updateGameStatus();
                                    }
                                    else printInvalidMove("INVALID MOVE! You must replace the Joker with a single valid tile from your hand and then reuse it.");
                                }
                                else printInvalidMove("INVALID MOVE! The selected joker index is not a Joker.");
                            }
                            else printInvalidMove("INVALID MOVE! The selected meld does not contain a Joker.");
                        }
                        else printInvalidMove("INVALID COMMAND! Meld indexes not in board.");
                    }
                    else printInvalidMove("INVALID COMMAND!");
                }
                else if (command.equalsIgnoreCase("end")) {
                    if(player.isInitialTurn()) {
                        if(player.getInitial30points() >= 30) {
                            player.setInitialTurn(false);
                            checkWinner(player);
                            if(!currentGame.isGameOver()) {
                                updateCurrentPlayerNo();
                            }
                            player.setInHand(sortInHandTiles(player.getInHand()));
                            updateGameStatus();
                            updateTempGameState();
                        }
                        else {
                            returnGameToPreviousState();
                            draw3TilesPenalty(player);
                            printInvalidMove("INVALID! You must score at least 30 in your initial turn. You have drawn 3 tiles as a penalty!");
                        }
                    }
                    else {
                        if(allValidMeldsInBoard()) {
                            if(hasInHandChanged(player)) {
                                checkWinner(player);
                                if(!currentGame.isGameOver()) {
                                    updateCurrentPlayerNo();
                                }
                                player.setInHand(sortInHandTiles(player.getInHand()));
                                updateGameStatus();
                                updateTempGameState();
                            }
                            else printInvalidMove("INVALID! You must draw or play valid tiles from your hand to end turn.");
                        }
                        else {
                            returnGameToPreviousState();
                            draw3TilesPenalty(player);
                            printInvalidMove("INVALID! All melds were not valid! Returned board to previous state. You have drawn 3 tiles as a penalty!");
                        }
                    }
                }
                else {
                    printInvalidMove("INVALID MOVE ");
                }
            }
            else updateGameStatus();
        }
        else updateGameStatus();
        return currentGame;
    }

    private void replaceJoker(ArrayList<ArrayList<String>> board, int meldIndex, int jokerIndex, String replacingTile) {
        ArrayList<String> meld = (ArrayList<String>) board.get(meldIndex).clone();
        ArrayList<String> meldToDisplay = (ArrayList<String>) boardToDisplay.get(meldIndex).clone();

        meld.set(jokerIndex, replacingTile);
        meldToDisplay.set(jokerIndex, "*" + replacingTile);

        board.set(meldIndex, meld);
        boardToDisplay.set(meldIndex, meldToDisplay);

        ArrayList<String> jokerMeld = new ArrayList<>();
        jokerMeld.add(JOKER);
        board.add(jokerMeld);
        boardToDisplay.add(jokerMeld);
    }

    private void mergeMeldsInBoard(ArrayList<ArrayList<String>> board, int index1, int index2, String position) {
        ArrayList<String> meld1 = (ArrayList<String>) board.get(index1).clone();
        ArrayList<String> meld1ToDisplay = (ArrayList<String>) boardToDisplay.get(index1).clone();
        ArrayList<String> meld2 = (ArrayList<String>) board.get(index2).clone();
        ArrayList<String> meld2ToDisplay = (ArrayList<String>) boardToDisplay.get(index2).clone();
        if (position.equals("tail")) {
            meld1.addAll(meld2);
            board.set(index1, meld1);
            board.remove(meld2);

            meld1ToDisplay.addAll(meld2ToDisplay);
            boardToDisplay.set(index1, meld1ToDisplay);
            boardToDisplay.remove(meld2ToDisplay);
        }
        else if (position.equals("head")) {
            meld2.addAll(meld1);
            board.set(index2, meld2);
            board.remove(meld1);

            meld2ToDisplay.addAll(meld1ToDisplay);
            boardToDisplay.set(index2, meld2ToDisplay);
            boardToDisplay.remove(meld1ToDisplay);
        }
    }

    private void addTilesToExistingMeld(Player player, String[] tiles, int meldIndex, String position) {
        ArrayList<ArrayList<String>> board = currentGame.getBoard();
        if (position.equals("tail")) {
            ArrayList<String> meld = (ArrayList<String>) board.get(meldIndex).clone();
            ArrayList<String> meldToDisplay = (ArrayList<String>) boardToDisplay.get(meldIndex).clone();
            String reusedTile = meldToDisplay.get(meldToDisplay.size()-1);
            reusedTile = "!" + reusedTile;
            meldToDisplay.remove(meldToDisplay.size()-1);
            meldToDisplay.add(boardToDisplay.get(meldIndex).size()-1, reusedTile);
            for(String tile: tiles) {
                meld.add(tile);
                meldToDisplay.add("*" + tile);
                player.getInHand().remove(tile);
            }
            board.remove(meldIndex);
            board.add(meldIndex, meld);

            boardToDisplay.remove(meldIndex);
            boardToDisplay.add(meldIndex, meldToDisplay);
        }
        else if (position.equals("head")) {
            ArrayList<String> meld = new ArrayList<>();
            ArrayList<String> meldToDisplay = new ArrayList<>();
            for (String tile: tiles) {
                meld.add(tile);
                meldToDisplay.add("*" + tile);
                player.getInHand().remove(tile);
            }
            meld.addAll(board.get(meldIndex));

            String reusedTile = boardToDisplay.get(meldIndex).get(0);
            reusedTile = "!" + reusedTile;
            boardToDisplay.get(meldIndex).remove(0);
            boardToDisplay.get(meldIndex).add(0, reusedTile);

            meldToDisplay.addAll(boardToDisplay.get(meldIndex));
            board.remove(meldIndex);
            board.add(meldIndex, meld);
            boardToDisplay.remove(meldIndex);
            boardToDisplay.add(meldIndex, meldToDisplay);
        }
    }

    private boolean allValidMeldsInBoard() {
        ArrayList<ArrayList<String>> board = currentGame.getBoard();
        for(ArrayList<String> meld: board) {
            String meldString = meld.toString().replaceAll(",", "");
            meldString = meldString.replace("[", "");
            meldString = meldString.replace("]", "");
            String[] tiles = meldString.split(" ");
            if (!isValidRun(tiles) && !isValidSet(tiles)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasInHandChanged(Player player) {
        if (tempInHandState.size() != player.getInHand().size()) {
            return true;
        }
        else {
            for(int i=0; i<tempInHandState.size(); i++) {
                if (!tempInHandState.get(i).equals(player.getInHand().get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    private void breakMeldAndUpdateBoard(int meldIndex, String tile) {
        ArrayList<String> meld = currentGame.getBoard().get(meldIndex);
        ArrayList<String> meldToDisplay = boardToDisplay.get(meldIndex);
        int tileIndex = meld.indexOf(tile);
        ArrayList<String> meld1 = new ArrayList<> (meld.subList(0, tileIndex+1));
        ArrayList<String> meld2 = new ArrayList<> (meld.subList(tileIndex+1, meld.size()));
        ArrayList<String> meld1ToDisplay = new ArrayList<> (meldToDisplay.subList(0, tileIndex+1));
        ArrayList<String> meld2ToDisplay = new ArrayList<> (meldToDisplay.subList(tileIndex+1, meldToDisplay.size()));

        currentGame.getBoard().remove(meld);
        currentGame.getBoard().add(meld1);
        currentGame.getBoard().add(meld2);

        boardToDisplay.remove(meldToDisplay);
        boardToDisplay.add(meld1ToDisplay);
        boardToDisplay.add(meld2ToDisplay);
    }

    private boolean isNumber(String numberString) {
        try{
            Integer.parseInt(numberString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isValidRun(String[] tiles) {
        if(tiles.length < 3) {
            return false;
        }
        else {
            boolean validRun = true;
            String firstTile = tiles[0];
            int startingIndex = 1;
            if(firstTile.equals(JOKER)) {
                if(tiles[1].equals(JOKER)) {
                    firstTile = tiles[2];
                    startingIndex = 3;
                }
                else {
                    firstTile = tiles[1];
                    startingIndex = 2;
                }
            }
            String firstTileColor = firstTile.charAt(0) + "";
            String firstTileNumberString = firstTile.replace(firstTileColor, "");
            if (isNumber(firstTileNumberString) || TILE_COLORS.contains(firstTileColor)) {
                int firstTileNumber = Integer.parseInt(firstTileNumberString);
                for(int i=startingIndex; i<tiles.length; i++) {
                    String tile = tiles[i];
                    if(!tile.equals(JOKER)) {
                        String tileColor = tiles[i].charAt(0) + "";
                        String tileNumberString = tile.replace(firstTileColor, "");
                        if (isNumber(tileNumberString)) {
                            int tileNumber = Integer.parseInt(tileNumberString);
                            if(!(tileColor).equals(firstTileColor)) {
                                validRun = false;
                            }
                            else {
                                if (tileNumber == 1) {
                                    String previousTile = tiles[i-1];
                                    if(!previousTile.equals(JOKER)) {
                                        if (Integer.parseInt(previousTile.replace(firstTileColor, "")) != 13) {
                                            validRun = false;
                                        }
                                    }

                                }
                                else if (tileNumber == 13) {
                                    if (tileNumber != (firstTileNumber+(i-startingIndex+1))){
                                        validRun = false;
                                    }
                                }
                                else {
                                    if (tileNumber != (firstTileNumber+(i-startingIndex+1))%13){
                                        validRun = false;
                                    }
                                }
                            }
                        }
                        else {
                            return false;
                        }
                    }
                }
            }
            else {
                return false;
            }
            return validRun;
        }
    }

    private boolean isValidSet(String[] tiles) {
        int meldLength = tiles.length;
        if(meldLength < 3 || meldLength > 4) {
            return false;
        }
        else {
            boolean validSet = true;
            ArrayList<String> colorsFound = new ArrayList<>();
            String firstTile = tiles[0];
            if(!firstTile.equals(JOKER)) {
                String firstTileColor = firstTile.charAt(0) + "";
                String firstTileNumber = firstTile.replace(firstTileColor, "");
                colorsFound.add(firstTileColor);
                for(int i=1; i<meldLength; i++) {
                    if(!tiles[i].equals(JOKER)) {
                        String color = tiles[i].charAt(0) + "";
                        String number = tiles[i].replace(color, "");
                        if(colorsFound.contains(color) || !number.equals(firstTileNumber) || !isNumber(number) || !TILE_COLORS.contains(color)) {
                            validSet = false;
                        }
                        colorsFound.add(color);
                    }
                }
            }
            else {
                String secondTile = tiles[1];
                if(!secondTile.equals(JOKER)) {
                    String secondTileColor = secondTile.charAt(0) + "";
                    String secondTileNumber = secondTile.replace(secondTileColor, "");
                    colorsFound.add(secondTileColor);
                    for(int i=2; i<meldLength; i++) {
                        if(!tiles[i].equals(JOKER)) {
                            String color = tiles[i].charAt(0) + "";
                            String number = tiles[i].replace(color, "");
                            if(colorsFound.contains(color) || !number.equals(secondTileNumber) || !isNumber(number) || !TILE_COLORS.contains(color)) {
                                validSet = false;
                            }
                            colorsFound.add(color);
                        }
                    }
                }
                else {
                    String thirdTile = tiles[2];
                    String thirdTileColor = thirdTile.charAt(0) + "";
                    String thirdTileNumber = thirdTile.replace(thirdTileColor, "");
                    colorsFound.add(thirdTileColor);
                    for(int i=3; i<meldLength; i++) {
                        if(!tiles[i].equals(JOKER)) {
                            String color = tiles[i].charAt(0) + "";
                            String number = tiles[i].replace(color, "");
                            if(colorsFound.contains(color) || !number.equals(thirdTileNumber) || !isNumber(number) || !isNumber(thirdTileNumber) || !TILE_COLORS.contains(color) || !TILE_COLORS.contains(thirdTileColor)) {
                                validSet = false;
                            }
                            colorsFound.add(color);
                        }
                    }
                }
            }
            return validSet;
        }
    }

    public boolean existsInHand(Player player, String[] tiles) {
        boolean exists = true;
        ArrayList<String> inHandTiles = player.getInHand();
        for(String tile: tiles) {
            if(!inHandTiles.contains(tile)) {
                exists = false;
            }
        }
        return exists;
    }

    private void printInvalidMove(String reason) {
        currentGame.setStatus(reason + " " + addGameInfoAndInstructions());
        System.out.println(currentGame.getStatus());
    }

    private void checkWinner(Player player) {
        if(player.getInHand().size() == 0) {
            currentGame.setGameOver(true);
        }
    }

    private void returnGameToPreviousState() {
        currentGame.setBoard((ArrayList<ArrayList<String>>) tempBoardState.clone());
        currentGame.getPlayerByNumber(currentGame.getCurrentPlayer()).setInHand((ArrayList<String>) tempInHandState.clone());
        boardToDisplay = (ArrayList<ArrayList<String>>) tempBoardState.clone();
    }

    private void updateTempGameState() {
        tempBoardState = (ArrayList<ArrayList<String>>) currentGame.getBoard().clone();
        tempInHandState = (ArrayList<String>) currentGame.getPlayerByNumber(currentGame.getCurrentPlayer()).getInHand().clone();
        boardToDisplay = (ArrayList<ArrayList<String>>) tempBoardState.clone();
    }

    private void updateBoardAndInHandTiles(ArrayList<ArrayList<String>> board, Player player, String[] tiles) {
        ArrayList<String> melds = new ArrayList<>();
        ArrayList<String> meldsToDisplayInBoard = new ArrayList<>();
        for(String tile: tiles) {
            melds.add(tile);
            player.getInHand().remove(tile);
            meldsToDisplayInBoard.add("*" + tile);
        }
        board.add(melds);
        boardToDisplay.add(meldsToDisplayInBoard);
    }

    private void updateFinalScores() {
        for(Player player:currentGame.getPlayerList()) {
            int score = 0;
            for(String tile: player.getInHand()) {
                if(tile.equals(JOKER)) {
                    score -= 30;
                }
                else {
                    score -= getTileScore(tile);
                }
            }
            player.setScore(score);
        }
    }

    private int getInitialMeldScore(String[] meld) {
        int score = 0;
        int meldLength = meld.length;
        for(int i=0; i<meldLength; i++) {
            String tile = meld[i];
            if(tile.equals(JOKER)) {
                if(i == 0) {
                    String nextTile = meld[i+1];
                    if (nextTile.equals(JOKER)) {
                        String nextNextTile = meld[i+2];
                        String color = nextNextTile.charAt(0) + "";
                        String number = nextNextTile.replace(color, "");
                        if(isValidSet(meld)) {
                            score += Integer.parseInt(number);
                        }
                        else if (isValidRun(meld)) {
                            score += Integer.parseInt(number) - 2;
                        }
                    }
                    else {
                        String color = nextTile.charAt(0) + "";
                        String number = nextTile.replace(color, "");
                        if(isValidSet(meld)) {
                            score += Integer.parseInt(number);
                        }
                        else if (isValidRun(meld)) {
                            score += Integer.parseInt(number) - 1;
                        }
                    }
                }
                else if(i == meldLength-1){
                    String previousTile = meld[i-1];
                    if (previousTile.equals(JOKER)) {
                        String previousPreviousTile = meld[i-2];
                        String color = previousPreviousTile.charAt(0) + "";
                        String number = previousPreviousTile.replace(color, "");
                        if(isValidSet(meld)) {
                            score += Integer.parseInt(number);
                        }
                        else if (isValidRun(meld)) {
                            score += Integer.parseInt(number) + 2;
                        }
                    }
                    else {
                        String color = previousTile.charAt(0) + "";
                        String number = previousTile.replace(color, "");
                        if(isValidSet(meld)) {
                            score += Integer.parseInt(number);
                        }
                        else if (isValidRun(meld)) {
                            score += Integer.parseInt(number) + 1;
                        }
                    }
                }
                else {
                    String nextTile = meld[i+1];
                    if (nextTile.equals(JOKER)) {
                        String previousTile = meld[i-1];
                        String color = previousTile.charAt(0) + "";
                        String number = previousTile.replace(color, "");
                        if(isValidSet(meld)) {
                            score += Integer.parseInt(number);
                        }
                        else if (isValidRun(meld)) {
                            score += Integer.parseInt(number) + 1;
                        }
                    }
                    else {
                        String color = nextTile.charAt(0) + "";
                        String number = nextTile.replace(color, "");
                        if(isValidSet(meld)) {
                            score += Integer.parseInt(number);
                        }
                        else if (isValidRun(meld)) {
                            score += Integer.parseInt(number) - 1;
                        }
                    }
                }
            }
            else {
                score += getTileScore(tile);
            }
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

    public void drawSpecificTile(Player player, String tile) {
        player.addTileInHand(tile);
        currentGame.getTilesRemaining().remove(tile);
        if(player.isInitialTurn()) {
            player.setInitialTurn(false);
        }
        player.setInHand(sortInHandTiles(player.getInHand()));
    }

    private void updateCurrentPlayerNo() {
        int currentPlayerNo = currentGame.getCurrentPlayer();
        if (currentPlayerNo == MAX_PLAYERS) {
            currentGame.setCurrentPlayer(1);
        }
        else currentGame.setCurrentPlayer(currentPlayerNo + 1);
    }

    public void resetGame() {
        this.currentGame = new Game();
        this.tempBoardState = (ArrayList<ArrayList<String>>) currentGame.getBoard().clone();
        this.tempInHandState = new ArrayList<>();
        boardToDisplay = new ArrayList<>();
    }
}
