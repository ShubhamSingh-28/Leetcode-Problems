class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n= nums.length;
        int [] ans= new int[n-k+1];
        int a=0;
        int j=0;
        for(int i=k-1;i<n;i++){
            if( isSolved(nums,j,i)){
               ans[a]=nums[i];
            } else{
                ans[a]=-1;
            }
            a++;
            j++;
        }
        return ans;
    }

    public boolean isSolved(int[]nums,int start, int end){
        for(int i=start;i<end;i++){
            if(nums[i]+1 != nums[i+1]){
                return false;
            }
        }
        return true;
    }

}