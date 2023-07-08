/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pornchitar.labox;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class LabOX {

    Scanner kb = new Scanner(System.in);
    public int row;
    public int col;
    public String[][] board = {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};
    public boolean play = false;
    public String turn;
    public String start;
    public boolean end;
    
    public void startGame() {
        System.out.println("OX GAME");
        System.out.print("Start Game??? (y/n): ");
        start = kb.nextLine().toLowerCase();
        while (!start.equals("n") && !start.equals("y")) {
            System.out.print("Start Game (y/n): ");
            start = kb.nextLine().toLowerCase();
        }
        if (start.equals("n")) {
            play = false;
        } else {
            play = true;
        }

    }
    
    public boolean endGame() {
        String continues = kb.nextLine().toLowerCase();

        while (!continues.equals("n") && !continues.equals("y")) {

            System.out.print("Exit !!!??? (y/n): ");
            continues = kb.nextLine().toLowerCase();
        }
        if (continues.equals("y")) {
            return false;
        }
        return true;

    }

    public void inputRowAndColumn() {
        System.out.print("Input row : ");
        row = kb.nextInt();
        System.out.print("Input column : ");
        col = kb.nextInt();
        if (((row > 0 && row < 4) && (col > 0 && col < 4))) {

            if (board[row - 1][col - 1].equals("_")) {

                board[row - 1][col - 1] = turn.toUpperCase();

                checkWin();
                nextTurn();

            } else {

                while ((!(row > 0 && row < 4) && !(col > 0 && col < 4)) && !(board[row - 1][col - 1].equals("_"))) {

                    System.out.println("Please Input Again.");
                    System.out.print("Input row :");
                    row = kb.nextInt();
                    System.out.print("Input column :");
                    col = kb.nextInt();

                }

                return;
            }

        } else {
            return;
        }
    }
    public void nextTurn() {
        if (turn.equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }

    }

    public boolean checkDraw() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("_")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRows() {
        for (int j = 0; j < board[row - 1].length; j++) {
            if (!board[row - 1][j].toLowerCase().equals(turn)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonals() {
        if (board[0][0].toLowerCase().equals(turn) && board[1][1].toLowerCase().equals(turn) && board[2][2].toLowerCase().equals(turn)) {
            return true;
        }

        if (board[0][2].toLowerCase().equals(turn) && board[1][1].toLowerCase().equals(turn) && board[2][0].toLowerCase().equals(turn)) {
            return true;
        }

        return false;
    }

    public boolean checkColumns() {
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j].toLowerCase().equals(turn) && board[1][j].toLowerCase().equals(turn) && board[2][j].toLowerCase().equals(turn)) {
                return true;
            }
        }
        return false;
    }

    public void show() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println();

        }

    }

    public void reset() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "_";
            }
        }
        turn = "O";
    }

    public void showTurn() {
        System.out.println("_________________________");
        System.out.println(">>> " + turn.toUpperCase() + " Turn !!!");

    }

    public void playGame() {
        show();
        showTurn();
        inputRowAndColumn();

    }

    public void checkWin() {
        if (checkRows() || checkColumns() || checkDiagonals()) {

            System.out.println("!!! " + turn + " Wins !!!");
            if (endGame()) {
                reset();
            } else {
                play = false;

            }
        } if(play == true) {
            if (checkDraw()) {
                System.out.println("!!! Draw !!!");
                if (endGame()) {
                    reset();
                } else {
                    play = false;

                }
            }
        }
    }

    public static void main(String[] args) {
        LabOX project = new  LabOX();
        Scanner kb = new Scanner(System.in);
        project.startGame();
        if (project.play == false) {
            System.out.println("GoodBye...");
            return;
        }

        project.turn = "X";
        while (project.play) {
            project.playGame();
        }
    }
}
