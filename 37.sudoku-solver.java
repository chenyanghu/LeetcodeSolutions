/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */
class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    private boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    // DFS
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            if(solve(board))
                                return true;
                            else
                            // reset to be '.' if it not valid
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++){
            // check duplication on row "row"
            if(board[row][i] != '.' && board[row][i] == c)
                return false;
            // check duplication on colume "col"
            if(board[i][col] != '.' && board[i][col] == c)
                return false;
            if(board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] != '.' 
                &&  board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c)
                return false;
        }
        return true;
    }
}

