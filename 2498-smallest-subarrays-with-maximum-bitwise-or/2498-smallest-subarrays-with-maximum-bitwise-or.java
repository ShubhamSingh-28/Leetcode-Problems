class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int last[]=new int[31];
        Arrays.fill(last,-1);
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
            int j=i;
            for(int k=0;k<31;++k){
                if((nums[i] & (1 << k))==0){
                    if(last[k]!=-1){
                        j=Math.max(j,last[k]);
                    }
                } else{
                    last[k]=i;
                }
            }
            ans[i] = j-i+1;
        }
        return ans;
    }
}