class Solution {
    public long maximumTripletValue(int[] nums) {
         int n = nums.length;
        long res = 0, imax = 0, dmax = 0;
        for (int k = 0; k < n; k++) {
            res = Math.max(res, dmax * nums[k]);
            dmax = Math.max(dmax, imax - nums[k]);
            imax = Math.max(imax, nums[k]);
        }
        return res;
        
        // Brute force O(n3)
    //   int n=nums.length;
    //   long res =0;
    //   for(int i=0;i<n;i++) {
    //     for(int j=i+1;j<n;j++){
    //         for(int k=j+1;k<n;k++){
    //             long val=(long)(nums[i]-nums[j])*nums[k];
    //             res=Math.max(res,val);
    //         }
    //     }
    //   } 
    //   return res;
    }
}