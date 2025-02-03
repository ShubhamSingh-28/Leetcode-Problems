class Solution {
    public int longestMonotonicSubarray(int[] nums) {
         int n = nums.length;
        if (n == 0) {
            return 0;
        }
        
        // Initialize counters for the lengths of increasing and decreasing subarrays
        int increasingLen = 1;
        int decreasingLen = 1;
        int maxLen = 1;  // At least one element is always part of the subarray
        
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {  // Strictly increasing
                increasingLen++;
                decreasingLen = 1;  // Reset decreasing subarray length
            } else if (nums[i] < nums[i - 1]) {  // Strictly decreasing
                decreasingLen++;
                increasingLen = 1;  // Reset increasing subarray length
            } else {  // If it's neither increasing nor decreasing, reset both
                increasingLen = 1;
                decreasingLen = 1;
            }
            
            // Update the max length for either type of subarray
            maxLen = Math.max(maxLen, Math.max(increasingLen, decreasingLen));
        }
        
        return maxLen;
    }
}