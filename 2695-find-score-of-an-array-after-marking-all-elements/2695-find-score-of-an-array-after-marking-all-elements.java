class Solution {
    public long findScore(int[] nums) {
        int n= nums.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=nums[i];
            dp[i][1]=i;
        }
        Arrays.sort(dp,(a,b)->a[0] -b[0]);
        boolean mark[] = new boolean[n];
        long res=0;

        for(int arr[]:dp){
            int val=arr[0];
            int ind= arr[1];
            if(!mark[ind]){
                res+=val;
                mark[ind]=true;
                if(ind>0){
                    mark[ind-1]=true;
                }
                if(ind<n-1){
                    mark[ind+1]=true;
                }
            }
        }
        return res;
    }
}