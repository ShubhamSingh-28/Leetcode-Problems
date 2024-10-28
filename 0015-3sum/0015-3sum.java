class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int total= nums[i]+nums[j]+nums[k];
                if(total>0){
                    k--;
                } else if(total<0){
                    j++;
                } else{
                    l.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                }
            }
        }

        //Brute force
        // HashSet<List<Integer>> set = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         for(int k=j+1;k<nums.length;k++){
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                 List<Integer> a = new ArrayList();
        //                 a.add(nums[i]);
        //                 a.add(nums[j]);
        //                 a.add(nums[k]);
        //                 Collections.sort(a);
        //                 if(set.contains(a)){
        //                     continue;
        //                 }else{
        //                     set.add(a);
        //                     l.add(a);
        //                 }
        //             }
        //         }
        //     }
        // }
        return l;
    }
}