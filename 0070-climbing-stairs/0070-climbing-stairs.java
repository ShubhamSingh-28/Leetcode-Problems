// class Solution {
//     public int climbStairs(int n) {
//         if(n==0 || n==1){
//             return 1;
//         }
//         return climbStairs(n-1)+ climbStairs(n-2);
//     }
// }

class Solution {
    public int climbStairs(int n) {
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        
        return climbStairsHelper(n,dp);
    }

    public int climbStairsHelper(int n, int[] dp){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!= -1) return dp[n];
        return dp[n]= climbStairsHelper(n-1,dp) +climbStairsHelper(n-2,dp);
    }
}