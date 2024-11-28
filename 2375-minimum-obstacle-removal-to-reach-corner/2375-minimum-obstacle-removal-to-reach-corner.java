class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // Priority Queue: stores the current obstacles removed and position (x, y)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        pq.offer(new int[]{0, 0, dp[0][0]});  // {obstacles removed, x, y}
        
        
        while(!pq.isEmpty()){
            int node[]= pq.poll();
            int u= node[0];
            int v= node[1];
            int removed= node[2];
            if(u==n-1 && v== m-1){
                return removed;
            }
            for(int[] d : dir){
                int nr= u+d[0];
                int nc =v+d[1];

                if(!isvalid(grid,nr,nc)) continue;
                int newremove= removed+grid[nr][nc];
                if(newremove< dp[nr][nc]){
                    dp[nr][nc]= newremove;
                    pq.offer(new int[]{ nr, nc,newremove});
                }
            }
        }
        return dp[n-1][m-1];
    }
    public boolean isvalid(int [][]grid, int row, int col){
        return (row>=0 && row<grid.length && col>=0 && col<grid[0].length);
    }
}