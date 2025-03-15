class Solution {
    public boolean isPos(int mid,int nums[], int k){
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=mid){
                res++;
                i++;
            }
            if(res>=k) return true;
        }
        return res>=k;
    }
    public int minCapability(int[] nums, int k) {
        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        int ans=0;
        for(int num:nums){
            start= Math.min(start,num);
            end=Math.max(end,num);
        }
        while(start<=end){
            int mid = start+(end-start)/2;
            if(isPos(mid,nums,k)){
                ans=mid;;
                end=mid-1;
            }else{
                start= mid+1;
            }
        }
        return ans;
    }
}