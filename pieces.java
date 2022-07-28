package com.chessGame;

public class pieces {
    final String symbol;
    public pieces(String symbol) {
        this.symbol = symbol;
    }
    public void move() {}
}


class rook extends pieces {
    public rook(String symbol) {
        super(symbol);
    }
    public void move() {
        if(chessBoard.currentLocationLetter==chessBoard.destinationLetter && chessBoard.currentLocationNumber !=chessBoard.destinationNumber){
            if(chessBoard.currentLocationNumber<chessBoard.destinationNumber){
                for (int a=chessBoard.currentLocationNumber;a<=chessBoard.board.length;a++) {
                    //this if is to make sure that you cannot jump over pieces
                    if(a !=chessBoard.destinationNumber && chessBoard.board[chessBoard.currentLocationLetter][a] !=null){System.out.println("You enter a wrong coordinate!!!!!!");break;}
                    else if (a == chessBoard.destinationNumber && (chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber]==null
                            || !(chessBoard.board[chessBoard.currentLocationLetter][chessBoard.currentLocationNumber].symbol.charAt(0)==(chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber].symbol.charAt(0))))) {
                        chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] =chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
                        chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                        player.currentPlayer=(player.currentPlayer==0)?1:0;
                        break;
                    }
                }
            }
            else {
                for (int a=chessBoard.currentLocationNumber;a>=0;a--){
                    //this if is to make sure that you cannot jump over pieces
                    if(a !=chessBoard.destinationNumber && chessBoard.board[chessBoard.currentLocationLetter][a] !=null){System.out.println("You enter a wrong coordinate!!!!!!");break;}
                    else if (a==chessBoard.destinationNumber && (chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber]==null
                            || !(chessBoard.board[chessBoard.currentLocationLetter][chessBoard.currentLocationNumber].symbol.charAt(0)==(chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber].symbol.charAt(0))))) {
                        chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] =chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
                        chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                        player.currentPlayer=(player.currentPlayer==0)?1:0;
                        break;
                    }
                }
            }
        }
        else if (chessBoard.currentLocationNumber==chessBoard.destinationNumber && chessBoard.currentLocationLetter != chessBoard.destinationLetter
                ){
            if(chessBoard.currentLocationLetter<chessBoard.destinationLetter){

                for (int a=chessBoard.currentLocationLetter;a<=chessBoard.board.length;a++) {
                    //this if is to make sure that you cannot jump over pieces
                    if(a !=chessBoard.destinationLetter && chessBoard.board[a][chessBoard.destinationNumber] !=null){System.out.println("You enter a wrong coordinate!!!!!!");break;}
                    else if (a == chessBoard.destinationNumber
                            && (chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber]==null
                            || !(chessBoard.board[chessBoard.currentLocationLetter][chessBoard.currentLocationNumber].symbol.charAt(0)==(chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber].symbol.charAt(0))))) {
                        chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] =chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
                        chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                        player.currentPlayer=(player.currentPlayer==0)?1:0;
                        break;
                    }
                }
            }
            else {
                for (int a=chessBoard.currentLocationLetter;a>=0;a--){
                    if(a !=chessBoard.currentLocationLetter && chessBoard.board[a][chessBoard.destinationNumber] !=null){System.out.println("You enter a wrong coordinate!!!!!!");break;}
                    else if (a==chessBoard.destinationLetter&& (chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber]==null
                            || !(chessBoard.board[chessBoard.currentLocationLetter][chessBoard.currentLocationNumber].symbol.charAt(0)==(chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber].symbol.charAt(0))))) {
                        chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] =chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
                        chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                        player.currentPlayer=(player.currentPlayer==0)?1:0;
                        break;
                    }
                }
            }
        }
        else System.out.println("You enter a wrong coordinate!!!!!!");

        }


    }


class queen extends pieces {
     public queen(String symbol) {
        super(symbol);

    }
    public void move() {
        new bishop(symbol).move();
        new rook(symbol).move();
    }
}


class knight extends pieces {
    public knight(String symbol) {
        super(symbol);
    }

    public void move() {
        //there are eight possibilities
        //(1)Northeast
        if((chessBoard.currentLocationLetter-2 ==chessBoard.destinationLetter
                && chessBoard.currentLocationNumber +1 ==chessBoard.destinationNumber)
                || (chessBoard.currentLocationLetter-1 ==chessBoard.destinationLetter
                && chessBoard.currentLocationNumber +2 ==chessBoard.destinationNumber)
                || (chessBoard.currentLocationLetter+2 ==chessBoard.destinationLetter
                && chessBoard.currentLocationNumber +1 ==chessBoard.destinationNumber)
                || (chessBoard.currentLocationLetter+1 ==chessBoard.destinationLetter
                && chessBoard.currentLocationNumber +2 ==chessBoard.destinationNumber)
                || (chessBoard.currentLocationLetter+2 ==chessBoard.destinationLetter
                && chessBoard.currentLocationNumber -1 ==chessBoard.destinationNumber)
                || (chessBoard.currentLocationLetter+1 ==chessBoard.destinationLetter
                && chessBoard.currentLocationNumber -2 ==chessBoard.destinationNumber)
                || (chessBoard.currentLocationLetter-2 ==chessBoard.destinationLetter
                && chessBoard.currentLocationNumber -1 ==chessBoard.destinationNumber)
                || (chessBoard.currentLocationLetter-1 ==chessBoard.destinationLetter
                && chessBoard.currentLocationNumber -2 ==chessBoard.destinationNumber)
                && (chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber]==null
                || !(chessBoard.board[chessBoard.currentLocationLetter][chessBoard.currentLocationNumber].symbol.charAt(0)==(chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber].symbol.charAt(0))))) {
            chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] =chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
            chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
            player.currentPlayer=(player.currentPlayer==0)?1:0;
        }
        else System.out.println("You enter a wrong coordinate!!!!!!");
    }
}


class pawn extends pieces {
    public pawn(String symbol) {super(symbol);}
    public void move() {



            if (player.currentPlayer == 0) {
                //the first if statement is what does the capturing.
                if (chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] != null
                        && chessBoard.destinationLetter == chessBoard.currentLocationLetter + 1
                        && !(chessBoard.board[chessBoard.currentLocationLetter][chessBoard.currentLocationNumber].symbol.charAt(0)==(chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber].symbol.charAt(0)))
                        && (chessBoard.destinationNumber == chessBoard.currentLocationNumber + 1
                            || chessBoard.destinationNumber == chessBoard.currentLocationNumber - 1)) {
                    chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] = chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
                    chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                    player.currentPlayer = 1;
                    //this else if statement is what causes a movement of the pawn forward.
                } else if ( chessBoard.destinationLetter == chessBoard.currentLocationLetter + 1
                        && chessBoard.destinationNumber == chessBoard.currentLocationNumber
                        && chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber]==null) {
                    chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] = chessBoard.board[ chessBoard.destinationLetter - 1 ][ chessBoard.destinationNumber ];
                    chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                    player.currentPlayer = 1;

                } else System.out.println("You enter a wrong coordinate!!!!!!");
            }
            else {
                if (player.currentPlayer == 1) {
                    //the first if statement is what does the capturing.
                    if (chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] != null
                            && chessBoard.destinationLetter == chessBoard.currentLocationLetter - 1
                            && !(chessBoard.board[chessBoard.currentLocationLetter][chessBoard.currentLocationNumber].symbol.charAt(0)==(chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber].symbol.charAt(0)))
                            && (chessBoard.destinationNumber == chessBoard.currentLocationNumber + 1 || chessBoard.destinationNumber == chessBoard.currentLocationNumber - 1)) {
                        chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] = chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
                        chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                        player.currentPlayer = 0;

                        //this else if statement is what causes a movement of the pawn forward.
                    } else if (chessBoard.destinationLetter == chessBoard.currentLocationLetter - 1
                            && chessBoard.destinationNumber == chessBoard.currentLocationNumber
                            && chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber]==null) {
                        chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] = chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
                        chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                        player.currentPlayer = 0;

                    } else System.out.println("You enter a wrong coordinate!!!!!");

                }
            }
    }
}


class bishop extends pieces {
    public bishop(String symbol) {
        super(symbol);
    }

    public void move() {
        //there is four possible ways
        boolean stop=false;
        if (chessBoard.currentLocationLetter > chessBoard.destinationLetter && chessBoard.currentLocationNumber > chessBoard.destinationNumber) {
            //1)northwest
            for(int i=chessBoard.currentLocationLetter;i>=0;--i){
                for (int j=chessBoard.currentLocationNumber;j>=0;--j){
                    if(i !=chessBoard.destinationLetter && j !=chessBoard.destinationNumber && chessBoard.board[i][j] !=null){System.out.println("You enter a wrong coordinate!!!!!!");stop=true;break;}
                    else if (j==chessBoard.destinationNumber && i==chessBoard.destinationLetter
                            && (chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber]==null
                            || !(chessBoard.board[chessBoard.currentLocationLetter][chessBoard.currentLocationNumber].symbol.charAt(0)==(chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber].symbol.charAt(0))))) {
                        chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] =chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
                        chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                        player.currentPlayer=(player.currentPlayer==0)?1:0;
                        break;
                    }
            }
                if (stop){break;}
        }
            }
        else if (chessBoard.currentLocationLetter > chessBoard.destinationLetter && chessBoard.currentLocationNumber < chessBoard.destinationNumber) {
            //2)northeast
            for(int i=chessBoard.currentLocationLetter;i>=0;--i){
                for (int j=chessBoard.currentLocationNumber;j<chessBoard.board.length;++j){
                    if(i !=chessBoard.destinationLetter && j !=chessBoard.destinationNumber && chessBoard.board[i][j] !=null){System.out.println("You enter a wrong coordinate!!!!!!");stop=true;break;}
                    else if (j==chessBoard.destinationNumber && i==chessBoard.destinationLetter
                            && (chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber]==null
                            || !(chessBoard.board[chessBoard.currentLocationLetter][chessBoard.currentLocationNumber].symbol.charAt(0)==(chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber].symbol.charAt(0))))) {
                        chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] =chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
                        chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                        player.currentPlayer=(player.currentPlayer==0)?1:0;
                        break;
                    }if (stop)break;
                }
            }
        }
        else if (chessBoard.currentLocationLetter < chessBoard.destinationLetter && chessBoard.currentLocationNumber > chessBoard.destinationNumber) {
            //3)southwest
            for(int i=chessBoard.currentLocationLetter;i<chessBoard.board.length;++i){
                for (int j=chessBoard.currentLocationNumber;j>=0;--j){
                    if(i !=chessBoard.destinationLetter && j !=chessBoard.destinationNumber && chessBoard.board[i][j] !=null){System.out.println("You enter a wrong coordinate!!!!!!");stop=true;break;}
                    else if (j==chessBoard.destinationNumber && i==chessBoard.destinationLetter
                            && (chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber]==null
                            || !(chessBoard.board[chessBoard.currentLocationLetter][chessBoard.currentLocationNumber].symbol.charAt(0)==(chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber].symbol.charAt(0))))) {
                        chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] =chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
                        chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                        player.currentPlayer=(player.currentPlayer==0)?1:0;
                        break;
                    }if (stop)break;
                }
            }
        } else if (chessBoard.currentLocationLetter < chessBoard.destinationLetter && chessBoard.currentLocationNumber < chessBoard.destinationNumber)
            {
                //4)southeast
                for(int i=chessBoard.currentLocationLetter;i<chessBoard.board.length;++i){
                    for (int j=chessBoard.currentLocationNumber;j<chessBoard.board.length;++j){
                        if(i !=chessBoard.destinationLetter && j !=chessBoard.destinationNumber && chessBoard.board[i][j] !=null){System.out.println("You enter a wrong coordinate!!!!!!");stop=true;break;}
                        else if (j==chessBoard.destinationNumber && i==chessBoard.destinationLetter
                                && (chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber]==null
                                || !(chessBoard.board[chessBoard.currentLocationLetter][chessBoard.currentLocationNumber].symbol.charAt(0)==(chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber].symbol.charAt(0))))) {
                            chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] =chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
                            chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                            player.currentPlayer=(player.currentPlayer==0)?1:0;
                            break;
                        }if (stop)break;
                    }
            }
        } else System.out.println("You enter a wrong coordinate!!!!!!");

    }
}

class king extends pieces {
    public king(String symbol) {
        super(symbol);
    }

    public void move() {
            boolean diagonal = (chessBoard.destinationNumber == chessBoard.currentLocationNumber + 1 || chessBoard.destinationNumber == chessBoard.currentLocationNumber - 1 || chessBoard.destinationNumber == chessBoard.currentLocationNumber);
            boolean b = (diagonal && chessBoard.destinationLetter == chessBoard.currentLocationLetter) || (diagonal && chessBoard.destinationLetter == chessBoard.currentLocationLetter - 1) || (diagonal && chessBoard.destinationLetter == chessBoard.currentLocationLetter + 1);

            if (player.currentPlayer == 1) {

                if (b && (chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber]==null
                        || !(chessBoard.board[chessBoard.currentLocationLetter][chessBoard.currentLocationNumber].symbol.charAt(0)==(chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber].symbol.charAt(0))))) {
                    chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] = chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
                    chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                    player.currentPlayer = 0;
                } else System.out.println("You enter a wrong coordinate!!!!!!");


            } else {

                if (b && (chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber]==null
                        || !(chessBoard.board[chessBoard.currentLocationLetter][chessBoard.currentLocationNumber].symbol.charAt(0)==(chessBoard.board[chessBoard.destinationLetter][chessBoard.destinationNumber].symbol.charAt(0))))) {
                    chessBoard.board[ chessBoard.destinationLetter ][ chessBoard.destinationNumber ] = chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ];
                    chessBoard.board[ chessBoard.currentLocationLetter ][ chessBoard.currentLocationNumber ] = null;
                    player.currentPlayer = 1;

                } else System.out.println("You enter a wrong coordinate!!!!!!");

            }
    }
}