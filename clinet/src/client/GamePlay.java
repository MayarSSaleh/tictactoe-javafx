/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

//import static client.PlayingScreenDemo.counterx;
import javafx.scene.control.Button;

/**
 *
 * @author mosta
 */
public class GamePlay 
{
    private char[][] board ;
    private boolean turn;
    private static int p1Score;
    private static int p2Score;
    private char currentPlayer;

    

    public GamePlay() 
    {
       board= new char[3][3];
       p1Score=0;
       p2Score=0;
       currentPlayer='X';
       turn=false;
            for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
       
    }
    public void print ()
    {
            for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]+" ");
                
            }
                System.out.println();
        }
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public static int getP1Score() {
        return p1Score;
    }

    public static void setP1Score(int score) {
        GamePlay.p1Score=score;
    }

    public static int getP2Score() {
        return p2Score;
    }

    public static void setP2Score(int score) {
        GamePlay.p2Score=score;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
   
    public char checkGameStatus(int row, int col) {
        System.out.println("row "+checkRow(row));
        System.out.println("col "+checkRow(col));
        System.out.println("d1  "+checkDiagonals1());
        System.out.println("d1  "+checkDiagonals2());
        System.out.println();




    if (checkRow(row) || checkColumn(col) || checkDiagonals1()||checkDiagonals2()) 
    {
       
        if (currentPlayer == 'X') {
            p1Score++;
            return 'X';
            
        } 
        else if (currentPlayer == 'O') {
            p2Score++;
            return 'O';
        }
    } 
    else if (isBoardFull()) {
        // Handle draw
        System.out.println("It's a draw!");
        return 'D';
        
    } else {
        switchPlayer(); 
    }
        return 'N';
}

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(int row ,int col,char ch) {
        //this.board = board;
        this.board[row][col]=ch;
    }
    
   public void resetGame(Button ...btn) {
        // Clear the board and reset buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
               // btn.setText("");
            }
        }
       for(int i=0;i<btn.length;i++)
       { 
        btn[i].getStyleClass().removeAll("btno","btnx");
       }
     

        currentPlayer = 'X';
    }
    public void switchPlayer() {
    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
   private boolean checkRow(int row) {
        return board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer;
    }

    private boolean checkColumn(int col) {
        return board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer;
    }

    private boolean checkDiagonals1() {
        return  (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer);
    }
    private boolean checkDiagonals2() {
        return  (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }
        private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

}
