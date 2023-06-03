package backtracking;

public class Sudoku {
    public static void main(String args[]){
        int[][] sudokuPuzzle = {
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {4, 9, 0, 1, 5, 7, 0, 0, 2},
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {1, 8, 5, 0, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 6, 0},
            {0, 6, 0, 4, 0, 5, 3, 0, 0},
            {0, 3, 0, 0, 7, 2, 0, 0, 4},
            {0, 4, 9, 0, 3, 0, 0, 5, 7},
            {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };
        print(sudokuPuzzle);
        System.out.println("------------------------------");
        if(sudokuSolver(sudokuPuzzle, 0, 0)){
            print(sudokuPuzzle);
        }
        else{
            System.out.println("Solution does not exist");
        }
        
    }
    public static void print(int game[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(game[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean sudokuSolver(int game[][], int row, int col){
        //base case
        if(row==9 && col==0){
            return true;
        }

        //recursive work

        int nextRow=row,nextCol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
        }

        if(game[row][col]!=0){
            return sudokuSolver(game, nextRow, nextCol);
        }
        for(int digit=1;digit<=9;digit++){
            if(isSafe(game, row, col, digit)){
                game[row][col]=digit;
                if(sudokuSolver(game, nextRow, nextCol)){
                    return true;
                }
                game[row][col]=0;
            }
        }
        return false;
    }
    public static boolean isSafe(int game[][], int row, int col, int digit){
        // Row checking
    for (int i = 0; i < 9; i++) {
        if (game[row][i] == digit && i != col) {
            return false;
        }
    }

    // Column checking
    for (int i = 0; i < 9; i++) {
        if (game[i][col] == digit && i != row) {
            return false;
        }
    }
        
        //grid checking
        int rs=(row/3)*3;
        int cs=(col/3)*3;

        for (int i = rs; i < rs + 3; i++) {
            for (int j = cs; j < cs + 3; j++) {
                if (game[i][j] == digit && (i != row || j != col))
                    return false;
            }
        }

        return true;
    }
}
