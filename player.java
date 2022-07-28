package com.chessGame;

public class player {

    private static pieces[][] board;
    static int position;
    static int currentPlayer;
    String playerSymbol;
    pieces[] knight = new knight[2];
    pieces[] pawn = new pawn[8];
    pieces[] bishop = new bishop[2];
    pieces king ;
    pieces queen;
    pieces[] rook = new rook[2];

    public player(String side){

        board=chessBoard.board;
        position=side.equals("White")?0:1;
    }
    public void playerPositions() {
        playerSymbol=(position==0)?"*":"+";


        knight[0] = new knight(String.format("%s%s%s",playerSymbol,"N",playerSymbol));
        knight[1] = new knight(String.format("%s%s%s",playerSymbol,"N",playerSymbol));

        for (int i = 0; i < pawn.length; i++) {
            pawn[i] = new pawn(String.format("%s%s%s",playerSymbol,"P",playerSymbol));
        }


        rook[0] = new rook(String.format("%s%s%s",playerSymbol,"R",playerSymbol));
        rook[1] = new rook(String.format("%s%s%s",playerSymbol,"R",playerSymbol));
        king = new king(String.format("%s%s%s",playerSymbol,"K",playerSymbol));
        queen = new queen(String.format("%s%s%s",playerSymbol,"Q",playerSymbol));
        bishop[0] = new bishop(String.format("%s%s%s",playerSymbol,"B",playerSymbol));
        bishop[1] = new bishop(String.format("%s%s%s",playerSymbol,"B",playerSymbol));

        if(position==0) {


                board[0][0] = rook[0];
                board[0][1] = knight[0];
                board[0][2] = bishop[1];
                board[0][3] = queen;
                board[0][4] = king;
                board[0][5] = bishop[1];
                board[0][6] = knight[0];
                board[0][7] = rook[1];

            System.arraycopy(pawn, 0, board[1], 0, board[1].length);
        }
        else{

                board[7][7] = rook[0];
                board[7][6] = knight[0];
                board[7][5] = bishop[1];
                board[7][4] = queen;
                board[7][3] = king;
                board[7][2] = bishop[1];
                board[7][1] = knight[0];
                board[7][0] = rook[1];

            System.arraycopy(pawn, 0, board[6], 0, board[6].length);

        }

    }
}