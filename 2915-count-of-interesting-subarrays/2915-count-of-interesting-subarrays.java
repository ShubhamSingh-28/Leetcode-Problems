class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long res =0;
        int n = nums.size();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int prefix = 0;
        cnt.put(0,1);
        for(int i=0;i<n;i++){
            prefix += nums.get(i) % modulo == k ? 1 : 0;
            res += cnt.getOrDefault((prefix - k + modulo) % modulo, 0);
            cnt.put(prefix % modulo, cnt.getOrDefault(prefix % modulo, 0) + 1);
        }
        // brute force 609 / 617 testcases passed
        // for(int i=0;i<nums.size();i++){
        //     int count=0;
        //     for(int j=i;j<nums.size();j++){
        //         if(nums.get(j)%modulo==k) count++;
        //         if(count%modulo==k) res++;
        //     }
        // }

        return res;
    }
}