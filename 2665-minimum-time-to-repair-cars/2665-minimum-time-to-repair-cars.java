class Solution {
    private boolean isCarRepaired(long mid,int[] ranks,int cars){
        long res=0;
        for(int r:ranks){
            res+=(long)(Math.sqrt((1.0 * mid) / r));
            if(res>=cars) return true;
        }
        return false;
    }
    public long repairCars(int[] ranks, int cars) {
        long start=Integer.MAX_VALUE;
        long end=Integer.MIN_VALUE;
        for(int n: ranks){
            start=Math.min(start,n);
            end = Math.max(end,n);
        }
        end= end*cars*cars;
        long ans=0;
        while(start<=end){
            long mid=start+(end-start)/2;
            if(isCarRepaired(mid,ranks,cars)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
}