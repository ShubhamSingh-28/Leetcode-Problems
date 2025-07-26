class Solution {
    public int maxSum(int[] nums) {
        if(nums.length==1) return nums[0];
        int res =0;
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            if(num>0 && !set.contains(num)){
                res+=num;
                set.add(num);
            }
        }
        if(res==0) res+=Arrays.stream(nums).max().getAsInt();
        return res;
    }
}