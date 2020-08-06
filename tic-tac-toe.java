import java.util.Scanner;

class tictactoe {
    static Scanner input = new Scanner(System.in);
    static int n = 3;
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        char[][] board = new char[n][n];
        int[][] record = new int[n*n][2];
        int move = 0;
        boolean unfinished = true;
        System.out.println("Game Started, Player 1 moves first");
        while(unfinished){
            // Player 1 Move
            playerMove(board,record, 'X', move,1);
            move++;
            // Check player 1 win condition
            if(checkWin(board,record[move-1][0],record[move-1][1],'X')) {
                System.out.println("Player 1 win!");
                unfinished = false;
                break;
            }
            // Check draw condition
            if(record[(n*n)-1][0]!= (char) 0){
                System.out.println("Draw!");
                unfinished = false;
                break;
            }
            // Player 2 Move
            playerMove(board,record, 'O', move,2);
            move++;
            // Check player 2 win condition
            if(checkWin(board,record[move-1][0],record[move-1][1],'O')) {
                System.out.println("Player 2 win!");
                unfinished = false;
                break;
            }
        }	
        keyboard.close();
}
    // Player move function
    private static void playerMove(char[][] board, int[][] record, char playerChar,int move, int playerNum){
        boolean playerMove = true;
        while(playerMove){
            int playerRow = 0, playerCol = 0; 
            System.out.println("Player " + playerNum +" : Which row you choose?");
            playerRow = input.nextInt()-1;
            System.out.println("Player " + playerNum +" : Which col you choose?");
            playerCol = input.nextInt()-1;
            if(playerRow>n-1 ||playerRow<0 ||playerCol>n-1||playerCol<0||board[playerRow][playerCol] != (char) 0){
                System.out.println("Player " + playerNum +" : Unavailable placement, please place another spot.");
            }else{
                record [move][0] = playerRow;
                record [move][1] = playerCol;
                board[playerRow][playerCol] = playerChar;
                playerMove = false;
            }
        displayBoard(board);
        }
    }

    // Game Board display function
    private static void displayBoard(char[][] board){
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

    // Win condition check function
    private static boolean checkWin(char[][] board, int row, int col, char player) {
        boolean win = true;
        // Check row
        for(int i = 0;i<n;i++){
            if(board[i][col] != player) win = false;
        }
        if(win) return true;
        
        // Check col 
        win = true;
        for(int i = 0;i<n;i++){
            if(board[row][i] != player) win = false;
        }
        if(win) return true;
        
        // Check diagonal
        if(row == col){
            win = true;
            for(int i = 0;i<n;i++){
                if(board[i][i] != player) win = false;
            }
            if(win) return true;
        }
        // Check the other diagonal
        if(row == n - col -1){
            win = true;
            for(int i = 0;i<n;i++){
                if(board[i][n-i-1] != player) win = false;
            }
        }
        return win;
    }
}