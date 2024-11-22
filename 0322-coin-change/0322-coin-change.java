class Solution {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int dp[]= new int[amount+1];
       
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        

        // Iterate through each coin
        for (int coin : coins) {
            // Update the dp array for all amounts from coin to the target amount
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still Integer.MAX_VALUE, it means we can't make the amount
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        //return recur(coins,amount,n,dp);
    }

    // public int recur(int coins[], int amount, int n, int dp[]){
    //     int count =0;
    //     if(n==0 || amount ==0) return 0;
    //     if(dp[n][amount]!=-1){
    //         return dp[n][amount];
    //     }
    //     if(amount>=coins[n-1]){
    //          dp[n][amount]= Math.max(coins[n-1]+recur(coins,amount-coins[n-1],n,dp),recur(coins,amount,n-1,dp));
    //          count++;
    //     } else{
    //          dp[n][amount]=recur(coins,amount,n-1,dp);
    //     }
    //     return count;
    // }
}