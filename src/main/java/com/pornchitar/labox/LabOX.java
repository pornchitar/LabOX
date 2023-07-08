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

   public int row;
    public int col;
    Scanner kb = new Scanner(System.in);
    public boolean play = false;
    public String start;
    public boolean end;
    public String turn;
    public String[][] board = {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};

    public void startGame() {
        System.out.println("OX GAME");
        System.out.print("Start Game??? (y/n): ");
        start = kb.nextLine().toLowerCase();
        while (!start.equals("n") && !start.equals("y")) {
            System.out.print("Start Game??? (y/n): ");
            start = kb.nextLine().toLowerCase();
        }
        if (start.equals("n")) {
            play = false;
        } else {
            play = true;
        }

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

    public void checkWin() {
        if (checkRows() || checkColumns() || checkDiagonals()) {
            show();
            System.out.println("!!! " + turn + " Win !!!");
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

    public boolean checkRows() {
        for (int j = 0; j < board[row - 1].length; j++) {
            if (!board[row - 1][j].equals(turn.toUpperCase())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonals() {
        if (board[0][0].equals(turn.toUpperCase()) && board[1][1].equals(turn.toUpperCase()) && board[2][2].equals(turn.toUpperCase())) {
            return true;
        }

        if (board[0][2].equals(turn.toUpperCase()) && board[1][1].equals(turn.toUpperCase()) && board[2][0].equals(turn.toUpperCase())) {
            return true;
        }

        return false;
    }

    public boolean checkColumns() {
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j].equals(turn.toUpperCase()) && board[1][j].equals(turn.toUpperCase()) && board[2][j].equals(turn.toUpperCase())) {
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

    public boolean endGame() {
        String continues = kb.nextLine().toLowerCase();

        while (!continues.equals("n") && !continues.equals("y")) {

            System.out.print("Exit !!!??? (y/n): ");
            continues = kb.nextLine().toLowerCase();
        }
        if (continues.equals("y")) {
            System.out.println("GoodBye...");
            return false;
        }
        return true;

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
