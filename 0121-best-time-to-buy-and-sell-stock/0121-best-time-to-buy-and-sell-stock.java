class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int min=Integer.MAX_VALUE;
        int minIndex= -1;
        for(int i=0;i<prices.length;i++){
            if(min>prices[i]){
                min=prices[i];
                minIndex=i;
            }
            if(i>minIndex){
                ans=Math.max(ans,prices[i]-min);
            }
        }
        return ans;
    }
}