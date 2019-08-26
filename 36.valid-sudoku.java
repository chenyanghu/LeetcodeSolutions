import java.util.Set;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        /** 
         * '4' in row 7 is encoded as "4 in row 7".
         * '4' in column 7 is encoded as "4 in col 7".
         * '4' in the top-right block is encoded as "4 in block 02".
         */

        Set<String> seen = new HashSet<>();
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    char number = board[i][j];
                    if(!seen.add(number + "in row" + i) || !seen.add(number + "in col" + j) || !seen.add(number + "in block" + i / 3 + j / 3))
                        return false;
                }
            }
        return true;
    }
}

