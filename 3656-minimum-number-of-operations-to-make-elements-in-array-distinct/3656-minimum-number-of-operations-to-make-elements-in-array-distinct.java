class Solution {
    public int minimumOperations(int[] nums) {
        int ans=0;
        int map[]= new int[101];
        for(int i=nums.length-1;i>=0;i--){
            map[nums[i]]++;
            if(map[nums[i]]>1){
                ans=i+1;
                break;
            }
        }
        return (ans%3==0)?ans/3:(ans/3)+1;
    }
}