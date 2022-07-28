package com.chessGame;

import java.util.Scanner;

public class chessBoard {
    static final pieces[][] board = new pieces[8][8];
    static int currentLocationLetter;
    static int currentLocationNumber;
    static int destinationLetter;
    static int destinationNumber;
    static String decision;
    public static void main(String[] args) {



        System.out.println("White plays first.");
        player White = new player("White");
        White.playerPositions();
        player Black = new player("Black");
        Black.playerPositions();
        player.currentPlayer=0;
        //zero means whites turn.

        do {
            displayBoard();
            System.out.println("It's "+((player.currentPlayer==0)?"Whites":"Blacks")+" turn to play.");
            System.out.println("Enter a coordinate or enter 99 to exit the Game.");
            decision = ask();
            piecesChoose(decision);
        }while (! decision.equals("99"));
        System.out.println((player.currentPlayer==0)?"Black":"White"+" Wins !!!!!!!!!");
        }

    public static void displayBoard() {
        char letter=97;
        System.out.print(" ");
        for (int i=1;i<=board.length;i++)
            System.out.print(" " + i + "  ");
        System.out.println();
        System.out.println(" _______________________________");
        for (com.chessGame.pieces[] pieces : board) {
            System.out.print("|");

            for (int row = 0; row < board.length; row++) {
                if (pieces[row] == null)
                    System.out.print("___|");
                else
                    System.out.print("" + pieces[row].symbol + "|");

            }
            System.out.print(" "+letter++);
            System.out.println();
        }
        System.out.println(" -------------------------------");

    }

    public static void piecesChoose(String coordinate){
        currentLocationLetter=coordinate.charAt(0)-97;
        currentLocationNumber=Character.getNumericValue(coordinate.charAt(1))-1;
        destinationLetter=coordinate.charAt(3)-97;
        destinationNumber=Character.getNumericValue(coordinate.charAt(4)-1);
        chessBoard.board[currentLocationLetter][currentLocationNumber].move();
    }
    public static String ask(){
        return new Scanner(System.in).next();
    }

}