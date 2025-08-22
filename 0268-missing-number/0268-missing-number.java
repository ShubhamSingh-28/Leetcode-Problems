class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        int len=nums.length;
        for(int n:nums) sum+=n;
        int expectedSum= len*(len+1)/2;
        return expectedSum-sum;
    }
}