class Solution {
    public int longestSubarray(int[] nums) {
        int start=0;
        int ans=0;
        int count=0;
        int end=0;
        while(end<nums.length){
            count += (nums[end]==0)?1:0;
            while(count>1){
                count -= (nums[start]==0)?1:0;
                start++;
            }
            ans=Math.max(ans,end-start);
            end++;
        }
        return ans;
    }
}