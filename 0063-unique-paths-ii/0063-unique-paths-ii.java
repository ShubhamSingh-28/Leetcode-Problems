class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n= obstacleGrid[0].length;
         int dp[][]= new int[m][n];
        // if(obstacleGrid[0][0]==1) return 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        // memoization
        return ct(obstacleGrid,m-1,n-1,dp);
    }

    public int ct(int obstacleGrid[][],int m, int n,int dp[][]){
        if(m<0 || n<0 ||obstacleGrid[m][n]==1) return 0;
        if(m==0 && n==0){
            return 1;
        }
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n]= ct(obstacleGrid,m-1,n,dp)+ct(obstacleGrid,m,n-1,dp);
    }
}