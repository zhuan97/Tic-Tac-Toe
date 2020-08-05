import java.util.Scanner;

class tictactoe {

    static Scanner input = new Scanner(System.in);
    static int n = 3;
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        
        char[][] board = new char[n][n];
        int player1Row = 0, player1Col = 0, player2Row = 0, player2Col = 0;
        int[][] record = new int[9][2];
        int move = 0;
        boolean unfinished = true;
        System.out.println("Game Started, Player 1 moves first");
        while(unfinished){
            boolean player1Move = true, player2Move = true;
            while(player1Move){
                System.out.println("Player 1: Which row you choose?");
                player1Row = input.nextInt()-1;
                System.out.println("Player 1: Which col you choose?");
                player1Col = input.nextInt()-1;
                if(player1Row>2 ||player1Row<0 ||player1Col>2||player1Col<0||board[player1Row][player1Col] != (char) 0){
                    System.out.println("Player 1: Unavailable placement, please place another spot.");
                }else{
                    record [move][0] = player1Row;
                    record [move][1] = player1Col;
                    move++;
                    board[player1Row][player1Col] = 'X';
                    player1Move = false;
                }
                System.out.println("Current Board");
                for(int i = 0;i <n;i++){
                    for(int j = 0; j<n;j++){
                        if(j == n-1){
                            System.out.print("|" + board[i][j] +"|");
                        }else{
                            System.out.print("|" + board[i][j] );
                        }
                        
                    }
                    System.out.println();
                }
            }
            if(checkWin(board,player1Row,player1Col,'X')) {
                System.out.println("Player 1 win!");
                unfinished = false;
                break;
            }

            if(record[8][0]!= (char) 0){
                System.out.println("Draw!");
                unfinished = false;
                break;
            }
            while(player2Move){
                System.out.println("Player 2: Which row you choose?");
                player2Row = input.nextInt()-1;
                System.out.println("Player 2: Which col you choose?");
                player2Col = input.nextInt()-1;
                if(player2Row>2 ||player2Row<0 ||player2Col>2||player2Col<0||board[player2Row][player2Col] != (char) 0){
                    System.out.println("Player 2: Unavailable placement, please place another spot.");
                }else{
                    record [move][0] = player2Row;
                    record [move][1] = player2Col;
                    move++;
                    board[player2Row][player2Col] = 'O';
                    player2Move = false;
                }
                for(int i = 0;i <n;i++){
                    for(int j = 0; j<n;j++){
                        if(j == n-1){
                            System.out.print("|" + board[i][j] +"|");
                        }else{
                            System.out.print("|" + board[i][j] );
                        }
                    }
                    System.out.println();
                }
            }
            if(checkWin(board,player2Row,player2Col,'O')) {
                System.out.println("Player 2 win!");
                unfinished = false;
                break;
            }
        }	
        keyboard.close();
}


    private static boolean checkWin(char[][] board, int row, int col, char player) {
        boolean win = true;
        //check row
        for(int i = 0;i<n;i++){
            if(board[i][col] != player) win = false;
        }
        if(win) return true;
        
        //check col 
        win = true;
        for(int i = 0;i<n;i++){
            if(board[row][i] != player) win = false;
        }
        if(win) return true;
        
        //check diagonal
        if(row == col){
            win = true;
            for(int i = 0;i<n;i++){
                if(board[i][i] != player) win = false;
            }
            if(win) return true;
        }
        //check the other diagonal
        if(row == n - col -1){
            win = true;
            for(int i = 0;i<n;i++){
                if(board[i][n-i-1] != player) win = false;
            }
        }
        return win;
    }
}