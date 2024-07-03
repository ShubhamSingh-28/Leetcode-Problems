class Solution {
    public int findPeakElement(int[] nums) {
        int res = nums[0];
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (res < nums[i]) {
                res = nums[i];
                ans = i;
            }
        }
        return ans;
    }
}