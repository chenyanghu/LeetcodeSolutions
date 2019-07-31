import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=407 lang=java
 *
 * [407] Trapping Rain Water II
 */
class Solution {
    public class Cell implements Comparable<Cell>{
        int row;
        int col;
        int height;

        public Cell(int row, int col, int height){
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public int compareTo(Cell c){
            return height - c.height;
        }
        
    }
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2)
            return 0;
        int m = heightMap.length, n = heightMap[0].length;

        PriorityQueue<Cell> pq = new PriorityQueue<>();

        boolean[][] visited = new boolean[m][n];
        
        // add border cells to pq
        for(int i = 0; i < m; i++){
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for(int i = 0; i < n; i++){
            visited[0][i] = true;
            visited[m - 1][i] = true;
            pq.offer(new Cell(0, i, heightMap[0][i]));
            pq.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }

        int res = 0;
        
        // BFS
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!pq.isEmpty()){
            Cell cell = pq.poll();
            for(int[] dir: directions){
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                if(row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]){
                    visited[row][col] = true;
                    res += Math.max(0, cell.height - heightMap[row][col]);
                    pq.offer(new Cell(row, col, Math.max(cell.height, heightMap[row][col])));
                }
            }
        }

        return res;
    }
}

