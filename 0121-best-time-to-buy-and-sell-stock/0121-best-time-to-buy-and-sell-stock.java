class Solution {
    public int maxProfit(int[] prices) {
       int max=Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
       for(int val:prices){
         min= Math.min(min,val);
        max=Math.max(max,val-min);
       }
       return max;
    }
}