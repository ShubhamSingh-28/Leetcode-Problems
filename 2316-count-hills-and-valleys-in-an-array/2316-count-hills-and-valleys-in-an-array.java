class Solution {
    public int countHillValley(int[] nums) {
        int c=0;
        int res = 0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                if((nums[i]<nums[c] && nums[i]<nums[i+1]) || (nums[i]>nums[c] && nums[i]>nums[i+1])){
                    res++;
                }
                c=i;
            }
        }
        return res;
    }
}