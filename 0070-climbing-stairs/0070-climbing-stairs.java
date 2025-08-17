class Solution {
    public int climbStairs(int n) {
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        return backtrack(n,dp);
    }

    public int backtrack(int n,int dp[]){
        if(n==0 || n==1) return dp[n]= 1;
        if(dp[n]!=-1) return dp[n]; 
        return dp[n]= backtrack(n-1,dp)+backtrack(n-2,dp);
    }
}