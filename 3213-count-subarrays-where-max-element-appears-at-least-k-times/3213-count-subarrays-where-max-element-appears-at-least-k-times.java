class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxVal=0;
        for(int num:nums){
            maxVal= Math.max(maxVal,num);
        }
        long ans=0;
        int start=0;
        int count=0;
        for(int end=0;end<nums.length;end++){
            if(maxVal==nums[end])count++;
            while(count==k){
                if(maxVal==nums[start])count--;
                start++;
            }
            ans+=start;
        }
        return ans;
    }
}