class Solution {
    public long maximumTripletValue(int[] nums) {
      int n=nums.length;
      long res =0;
      for(int i=0;i<n;i++) {
        for(int j=i+1;j<n;j++){
            for(int k=j+1;k<n;k++){
                long val=(long)(nums[i]-nums[j])*nums[k];
                res=Math.max(res,val);
            }
        }
      } 
      return res;
    }
}