class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]= new int[m+1][n+1];
        // memoization
        return ct(m-1,n-1,dp);
    }

    public int ct(int m, int n,int dp[][]){
        if(m==0 || n==0){
            return 1;
        }
        if(dp[m][n]!=0) return dp[m][n];
        return dp[m][n]= ct(m-1,n,dp)+ct(m,n-1,dp);
    }
}