class Solution {
    public int removeDuplicates(int[] nums) {
        int k=2;
        for(int i=2; i<nums.length;i++){
            if(nums[i]== nums[i-1] && nums[i]== nums[k-2]){
                continue;
            } else{
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}