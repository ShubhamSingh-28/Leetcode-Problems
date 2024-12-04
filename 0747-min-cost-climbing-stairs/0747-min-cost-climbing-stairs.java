class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(func(cost,dp, n-1),func(cost,dp, n-2));
    }
    public int func(int cost[], int dp[], int i){
         if (i < 0) return 0;
        if (i==0 ||i == 1 ) return cost[i];
        if(dp[i]!=-1) return dp[i];
        dp[i]= Math.min(func(cost,dp,i-1),func(cost,dp,i-2))+cost[i];
        return dp[i];
    }
}