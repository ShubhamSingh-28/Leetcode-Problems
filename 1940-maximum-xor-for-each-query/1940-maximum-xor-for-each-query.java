class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int mask = (1 << maximumBit)-1;
        int n= nums.length;
        int ans[]= new int[n];
        int cur=0;

        for(int i=0; i<n; i++){
            cur^=nums[i];
            ans[n-i-1]= ~cur & mask;
        }

        return ans;
    }
}