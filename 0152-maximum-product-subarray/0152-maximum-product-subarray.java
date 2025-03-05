class Solution {
    public int maxProduct(int[] nums) {
        int max=1;
        int res=Integer.MIN_VALUE;
        int min=1;
        for(int m:nums){
            res=Math.max(res,m);
        }

        for(int n:nums){
            int temp=max*n;
             max=Math.max(temp,Math.max(n,min*n));
            min= Math.min(temp,Math.min(n,min*n));
            res=Math.max(res,max);
        }
        
        return res;
    }
}