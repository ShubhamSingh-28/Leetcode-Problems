class Solution {
    public int rob(int[] nums) {
        int dp[]=  new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<=nums.length;i++){
            int ans=nums[i-1];
            dp[i]=Math.max(dp[i-1],dp[i-2]+ans);
        }
        return dp[nums.length];
        //Arrays.fill(dp,-1);
        //return robsmemo(nums,nums.length-1,dp);
        //return  robs(nums,nums.length-1);
    }
    // public int robs(int[] nums, int n) {
    //     if(n<0){
    //         return 0;
    //     }
    //     return Math.max(robs(nums,n-1),robs(nums,n-2)+nums[n]);
    // }

    // public int robsmemo(int[] nums, int n, int dp[]) {
    //     if(n<0){
    //         return 0;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     return dp[n]= Math.max(robsmemo(nums,n-1,dp),robsmemo(nums,n-2,dp)+nums[n]);
    // }
}