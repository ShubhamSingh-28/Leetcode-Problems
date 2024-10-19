class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int targetOr=0;
        for(int i : nums){
            targetOr |= i;
        }
        return count(0, nums, 0, targetOr);
    }

    public int count(int index, int[] nums, int curOr, int targetOr){
        if(index==nums.length){
            return (curOr==targetOr)?1:0;
        }
        int pick = count(index+1, nums, curOr | nums[index], targetOr);
        int nopick = count(index+1, nums, curOr, targetOr);
        return pick + nopick;
    }

}