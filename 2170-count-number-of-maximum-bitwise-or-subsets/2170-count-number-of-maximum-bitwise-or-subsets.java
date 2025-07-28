class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int targetOr=0;
        for(int num:nums){
            targetOr |= num;
        }
        return count(0,nums,0,targetOr);
    }
    private int count(int i,int nums[],int curOr,int targetOr){
        if(i==nums.length){
            return (curOr==targetOr)?1:0;
        }
        int pick=count(i+1,nums,curOr|nums[i],targetOr);
        int noPick=count(i+1,nums,curOr,targetOr);
        return pick+noPick;
    }
}