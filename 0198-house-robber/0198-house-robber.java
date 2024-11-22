class Solution {
    public int rob(int[] nums) {
        int dp[]=  new int[nums.length+1];
        Arrays.fill(dp,-1);
        return robsmemo(nums,nums.length-1,dp);
        //return  robs(nums,nums.length-1);
    }
    // public int robs(int[] nums, int n) {
    //     if(n<0){
    //         return 0;
    //     }
    //     return Math.max(robs(nums,n-1),robs(nums,n-2)+nums[n]);
    // }

    public int robsmemo(int[] nums, int n, int dp[]) {
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]= Math.max(robsmemo(nums,n-1,dp),robsmemo(nums,n-2,dp)+nums[n]);
    }
}