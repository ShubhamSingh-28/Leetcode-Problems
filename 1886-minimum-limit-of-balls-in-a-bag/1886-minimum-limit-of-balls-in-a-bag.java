class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int start=1;
        int end=Arrays.stream(nums).max().getAsInt();
        int res= end;
        while(start<end){
            int mid= start+(end-start)/2;
            if(canDivide(nums, mid, maxOperations)){
                end=mid;
                res=end;
            }else{
                start=mid+1;
            }
        }
        return res;
    }
    boolean canDivide(int nums[], int mid, int maxOperations){
        int a=0;
        for(int n:nums){
            a += (n + mid - 1) / mid-1;
            if(a>maxOperations){
                return false;
            }
        }
        return true;
    }
}