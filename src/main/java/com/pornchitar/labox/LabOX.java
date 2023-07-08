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
    
    public static void main(String[] args) {
        LabOX project = new  LabOX();
        Scanner kb = new Scanner(System.in);
        project.startGame();
    }
}
