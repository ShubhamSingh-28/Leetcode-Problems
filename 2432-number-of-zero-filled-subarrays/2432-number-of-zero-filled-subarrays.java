class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count =0;
        int steak=0;
        for(int n:nums){
          if(n==0){
            steak+=1;
          } else{
            steak=0;
          }
          count+=steak;
        }
        return count;
    }
}