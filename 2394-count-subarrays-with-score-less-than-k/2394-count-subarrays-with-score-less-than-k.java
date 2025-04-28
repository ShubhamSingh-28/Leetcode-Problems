class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n= nums.length;
        long res=0;
        int start=0;
        long sum=0;
        for(int end=0;end<n;end++){
            sum+=nums[end];
            while(sum*(end-start+1)>=k){
                sum-=nums[start];
                start++;
            }
            res+=end-start+1;
        }


        // brute force 159 / 167 testcases passed

        // for(int i=0;i<n;i++){
        //     long sum=0;
        //     for(int j=i;j<n;j++){
        //         sum+=nums[j];
        //         if(sum*(j-i+1)<k){
        //             res++;
        //         }
        //     }
            
        // }
        return res;
    }
}