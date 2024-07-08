class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
         int start = 1;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            end = Math.max(end, nums[i]);
        }
        int ans = -1;

        while (start<=end) {
            int mid = start+(end-start)/2;
            if (isDivisorValid(nums,mid,threshold)) {
                ans = mid;
                end= mid-1;
            } else{
                start=mid+1;
            }
        }
        return ans;
    }
     boolean isDivisorValid(int[] nums,int mid,int threshold){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]/mid;
            if (nums[i]%mid!=0) {
                sum=sum+1;
            }
            if (sum>threshold) {
                return false;
            }
            
        }
        return true;
     }


}