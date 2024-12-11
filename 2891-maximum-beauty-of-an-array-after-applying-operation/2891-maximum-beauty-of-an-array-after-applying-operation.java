class Solution {
    public int maximumBeauty(int[] nums, int k) {
        if(nums.length==1)return 1;
        int max=0;
        for(int num:nums){
            max= Math.max(max, num);
        }
        int count[]= new int[max+1];
        for(int num:nums){
            count[Math.max(num-k,0)]++;
            count[Math.min(num+k+1,max)]--;
        }
        
        int cur=0;
        int maxsum=0;
        for(int c:count){
            cur+=c;
            maxsum = Math.max(maxsum,cur);
        }
        return maxsum;
    }
}