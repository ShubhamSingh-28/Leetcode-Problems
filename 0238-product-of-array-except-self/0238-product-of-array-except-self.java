class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];

        // 1st approach O(n2) time complaxity
        // for(int i=0;i<n;i++){
        // int mul=1;
        //     for(int j =0; j<n;j++){
        //         if(nums[i]==nums[j]){
        //             continue;
        //         }
        //         mul*=nums[j];
        //     }
        //     ans[i]=mul;
        // }

        // 2nd approach O(n)

        Arrays.fill(ans,1);

        int left=1;
        for(int i=0;i<n;i++){
            ans[i]*=left;
            left*=nums[i];
        }

        int right=1;
        for(int i=n-1;i>=0;i--){
            ans[i]*=right;
            right*=nums[i];
        }
        return ans;
    }
}