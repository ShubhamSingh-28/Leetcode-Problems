class Solution {
    public int jump(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        int res=0;
        int n=0;
        for(int i=0;i<nums.length;i++){
            if(res<nums.length-1){
                res+=nums[i];
                n++;
            }
        }
        return n;
    }
}