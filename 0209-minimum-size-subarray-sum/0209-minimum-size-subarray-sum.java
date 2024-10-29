class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0;
        int end=0;
        int sum=0;
        int min= Integer.MAX_VALUE;
        int n= nums.length;
        while(end<n){
            sum+=nums[end];
                while( sum>=target){
                    sum-=nums[start];
                    min= Math.min(min,end-start+1);
                    start++;
                }
            end++;
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}