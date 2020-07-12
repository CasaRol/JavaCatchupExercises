package com.example.tictactoe;

import java.lang.reflect.Array;

public class GameLogic {

    private String[] gameboard;
    private String player;

    public GameLogic() {
        this.gameboard = new String[9];
        this.player = "X";
    }

    public void playerMove(int position, String player) {
        //Make sure index is clear
        if(gameboard[position] == null) {
            //adding player move to index
            gameboard[position] = player;
            //change player
            if(getPlayer() == "X") {
                setPlayer("O");
            } else {
                setPlayer("X");
            }
        }
    }

    public String checkWin() {
        for(int i = 0; i < gameboard.length; i+=3) {
            if(gameboard[i] != null && gameboard[i] == gameboard[i+1] && gameboard[i+1] == gameboard[i+2]) {
                return gameboard[i];
            }
        }
        for(int i = 0; i < 3; i++) {
            if(gameboard[i] != null && gameboard[i] == gameboard[i+3] && gameboard[i+3] == gameboard[i+6]) {
                return gameboard[i];
            }
        }
        if(gameboard[0] != null && gameboard[0] == gameboard[4] && gameboard[4] == gameboard[8]){
            return gameboard[0];
        } else if(gameboard[2] != null && gameboard[2] == gameboard[4] && gameboard[4] == gameboard[6]) {
            return gameboard[2];
        }

        //Checking if any indexes are empty
        //If no indexes are empty game is a draw
        for(int i = 0; i < gameboard.length; i++) {
            if(gameboard[i] == null) {
                return "-1";
            }
        }
        //No matches on above criteria results in a draw
        return "draw";
    }



    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getGameboardIndex(int index) {
        return gameboard[index];
    }


}
