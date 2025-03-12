class Solution {
    public int positiveIndex(int[] nums){
        int start=0;
        int end=nums.length-1;
        int ans=nums.length;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<=0){
                start=mid+1;
            } else if(nums[mid]>0){
                end=mid-1;
                ans=mid;
            }
        }
         return ans;
    }
    public int negetiveIndex(int[] nums){
        int start=0;
        int end=nums.length-1;
        int ans=nums.length;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<0){
                start=mid+1;
            } else if(nums[mid]>=0){
                end=mid-1;
                ans=mid;
            }
        }
        return ans;
    }
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int pos=n- positiveIndex(nums);
        int neg = negetiveIndex(nums);

       // normal approach time-complexity O(N);
        // int neg =0;
        // int pos =0;
        // for(int num: nums){
        //     if(num>0){
        //         pos++;
        //     } else if(num<0){
        //         neg++;
        //     }
        // }
        return Math.max(pos,neg);
    }
}