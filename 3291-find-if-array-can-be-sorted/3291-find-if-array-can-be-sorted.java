class Solution {
    public boolean canSortArray(int[] nums) {

        int setbits=Integer.bitCount(nums[0]);
        int prevMax=-1;
        int curMax=nums[0];
        for(int i=0;i<nums.length;i++){
            if(setbits!=Integer.bitCount(nums[i])){
                setbits=Integer.bitCount(nums[i]);
                prevMax=Math.max(prevMax,curMax);
                curMax= nums[i];
            } else{
                curMax=Math.max(curMax,nums[i]);
            }
            if(prevMax!= -1 && nums[i] < prevMax){
                return false;
            }
        }

        return true;

        // 1st approach
        // int setbits=Integer.bitCount(nums[0]);
        // int curMax=nums[0];
        // int prevMax=Integer.MIN_VALUE;
        // int curMin=nums[0];
        // for(int i=0;i<nums.length;i++){
        //     if(setbits==Integer.bitCount(nums[i])){
        //         curMax=Math.max(curMax,nums[i]);
        //         curMin=Math.min(curMin,nums[i]);
        //     } else{
        //         if(curMin<prevMax) return false;
        //         prevMax=curMax;
        //         setbits=Integer.bitCount(nums[i]);
        //         curMax=nums[i];
        //         curMin= nums[i];
        //     }
        // }
        // return curMin>prevMax;
    }
}