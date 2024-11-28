class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
                int dp[][]= new int[m][n];
                for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        dp[i][j]=-1;
                    }
                }
        // memoization
        return ct(grid,m-1,n-1,dp);
    }

    public int ct(int [][] grid,int m, int n,int dp[][]){
        if(m==0 && n==0){
            return grid[0][0];
        }
        int top = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
        if(dp[m][n]!= -1) return dp[m][n];        
        if (m > 0) {
            top = ct(grid, m - 1, n, dp);
        }

        // If we can move left, get the value from the left cell
        if (n > 0) {
            left = ct(grid, m, n - 1, dp);
        }

        // Store the result in dp and return it
        dp[m][n] = Math.min(top, left) + grid[m][n];
        return dp[m][n];

    }
}