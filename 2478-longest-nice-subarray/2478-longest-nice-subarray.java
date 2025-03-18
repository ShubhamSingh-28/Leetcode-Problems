class Solution {
    private boolean isNice(int nums[], int s, int e){
        // for(int i=s;i<e;i++){
        //     int num=nums[i];
        //     for(int j =i+1;j<e;j++){
        //         if((num & nums[j]) != 0) return false;
        //     }
        // }
        int num = nums[e];
        int k = e - 1;
        while (k >= s) {
            if ((num & nums[k]) != 0) return false;
            k--;
        }
        return true;
    }
    public int longestNiceSubarray(int[] nums) {
        int s=0;
        int e=1;
        int n=nums.length;
        int len=1;
        while(e<n){
            if(isNice(nums,s,e)){
                len=Math.max(len,e-s+1);
                e++;
            }else{
                s++;
                e=s+1;
            }
        }
        return len;
    }
}