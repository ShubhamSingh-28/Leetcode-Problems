class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n=nums.length;
        long ans=0;
        int min = -1,max = -1, start = -1;
        for(int i=0;i<n;i++){
            if(nums[i]<minK || nums[i]>maxK) start=i;
            if(nums[i]==minK) max=i;
            if(nums[i]==maxK)min=i;
            int valid=Math.max(0,Math.min(min,max)-start);
            ans+=valid;
        }


        //brute force 45 / 53 testcases passed
        // for(int i=0;i<n;i++){
        //     int min=Integer.MAX_VALUE;
        //     int max=Integer.MIN_VALUE;
        //     for(int j=i;j<n;j++){
        //         min=Math.min(min,nums[j]);
        //         max=Math.max(max,nums[j]);
        //         if(min==minK && max==maxK) ans++;
        //     }
        // }
        return ans;
    }
}