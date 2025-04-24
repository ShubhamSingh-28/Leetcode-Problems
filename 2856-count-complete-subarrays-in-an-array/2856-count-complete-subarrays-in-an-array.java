class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int res =0;
        int n=nums.length;
        Set<Integer> set= new HashSet<>();
        for(int a:nums){
            set.add(a);
        }

        int count=set.size();
        for(int i=0;i<n;i++){
            Set<Integer> temp= new HashSet<>();
            for(int j=i;j<n;j++){
                temp.add(nums[j]);
                if(temp.size()==count){
                    res+=n-j;
                    break;
                }
            }
        }
        return res;
    }
}