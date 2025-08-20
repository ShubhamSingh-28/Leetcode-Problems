class Solution {
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m= matrix[0].length;
        int dp[][]= new int[n+1][m+1];
        for(int d[]:dp) Arrays.fill(d,-1);
        int ans=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans += solve( matrix,i, j, dp);
            }
        }
        return ans;
    }

    public int solve(int[][] matrix,int i, int j, int[][] dp){
        if(i>=matrix.length || j>=matrix[0].length || matrix[i][j]==0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int right= solve(matrix,i,j+1,dp);
        int diagonal= solve(matrix,i+1,j+1,dp);
        int down = solve(matrix,i+1,j,dp);
        return dp[i][j]= Math.min(right,(Math.min(down,diagonal)))+1;
    }
}