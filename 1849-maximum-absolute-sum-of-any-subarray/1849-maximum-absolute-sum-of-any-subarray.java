class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min=0;
        int prefix=0;
        int max= 0;
        for(int num: nums){
            prefix+=num;
            min=Math.min(min,prefix);
            max=Math.max(max,prefix);
        }
        return max-min;
    }
}