class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        // If the sum is odd, we cannot partition it into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }
        
        // We need to check if there exists a subset with sum equal to sum / 2
        int target = sum / 2;
        
        // Call the subset sum function to check if a subset with sum `target` is possible
        return knapsack(nums, target, nums.length);
    }
    public boolean knapsack(int[]nums,int w, int n){
        boolean dp[][]=new boolean[n+1][w+1];
        dp[0][0]=true;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j]|=dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][w];
    }
}