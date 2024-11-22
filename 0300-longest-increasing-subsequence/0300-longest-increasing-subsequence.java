class Solution {
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        int arr[]= new int[set.size()];
        int l=0;
        for(int num:set){
            arr[l]=num;
            l++;
        }
        Arrays.sort(arr);
        int dp[][]= new int[nums.length+1][arr.length+1];
        int n=dp.length;
        int m=dp[0].length;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(nums[i-1]==arr[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                } else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n-1][m-1];
        //return lcs(nums,arr,nums.length,arr.length,dp);
    }

// memoization code
    // public int lcs(int nums[], int arr[],int n,int m, int dp[][]){
    //     if(n==0 || m==0){
    //         return 0;
    //     }
    //    if(dp[n-1][m-1]!=-1){
    //     return dp[n-1][m-1];
    //    }

    //    if(arr[m-1]==nums[n-1]){
    //      return dp[n-1][m-1]=lcs(nums,arr,n-1,m-1,dp)+1;
    //    } else{
    //     int ans1=lcs(nums,arr,n-1,m,dp);
    //     int ans2=lcs(nums,arr,n,m-1,dp);
    //     return dp[n-1][m-1]= Math.max(ans1,ans2);
    //    }
    // }
}