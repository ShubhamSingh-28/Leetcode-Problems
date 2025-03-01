class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int sum=0;
       int ans=0;
       int max=0;
       for(int i=gas.length-1;i>=0;i--){
        sum=sum+gas[i]-cost[i];
        if(sum>max){
            max=sum;
            ans=i;
        }
       }
        return (sum>=0)?ans:-1;
    }
}