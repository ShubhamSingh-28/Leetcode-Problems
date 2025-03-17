class Solution {
    public boolean divideArray(int[] nums) {
        // 1st approach sorting time :-O(nlogn);
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i+=2){
            if(nums[i]!=nums[i+1]) return false ;
        }
        return true;
    }
}