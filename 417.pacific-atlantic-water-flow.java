import java.util.Arrays;

/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */
class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0)
            return res;

        int m = matrix.length, n = matrix[0].length;   
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // edges: top left -> Pacific
        //        bottom right -> Atlantic

        // start from edges
        for(int i = 0; i < m; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
        }
        for(int i = 0; i < n; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, i);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new ArrayList<Integer>(Arrays.asList(i, j)));
            }
        }

        return res;

    }
    private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for(int[] dir : dirs)
            dfs(matrix, visited, matrix[x][y], x + dir[0], y + dir[1]);
    }
}

