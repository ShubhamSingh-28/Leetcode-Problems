class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int res =0;
        int n=nums.length;
        
        //brute force aproach.
        // Set<Integer> set= new HashSet<>();
        // for(int a:nums) set.add(a);
        // int count=set.size();
        // for(int i=0;i<n;i++){
        //     set.clear();
        //     for(int j=i;j<n;j++){
        //         set.add(nums[j]);
        //         if(set.size()==count){
        //             res+=n-j;
        //             break;
        //         }
        //     }
        // }

        // sliding window 

        Set<Integer> set= new HashSet<>();
        for(int a:nums) set.add(a);
        int count=set.size();
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size()==count){
                res+=n-i;
                map.put(nums[j],map.get(nums[j])-1);
                if(map.get(nums[j])==0) map.remove(nums[j]);
                j++;
            }
        }

        return res;
    }
}