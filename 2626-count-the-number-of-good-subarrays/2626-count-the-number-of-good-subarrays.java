class Solution {
    // public boolean isgood(int nums[],int i, int j,int k){
    //     int c=0;
    //     for(int a=i;a<j;a++){
    //         for(int b=a+1;b<=j;b++){
    //             if(nums[a]==nums[b]) c++;
    //         }
    //     }
    //     return c>=k;
    // }
    public long countGood(int[] nums, int k) {
        long ans=0;
        int n=nums.length;
        Map<Integer,Integer> map= new HashMap<>();
        int left=0;
        int right=0;
        while(right<n){
            k-=map.getOrDefault(nums[right],0);
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(k<=0){
                map.put(nums[left],map.get(nums[left])-1);
                k+=map.get(nums[left++]);
            }
            ans+=left;
            right++;
        }
        //32 / 41 testcases passed
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(isgood(nums,i,j,k)) ans++;
        //     }
        // }
        return ans;
    }
}