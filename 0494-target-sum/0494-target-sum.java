class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> map= new HashMap<>();
        return findWays(nums,target,0,0,map);
    }
    public int findWays(int[]nums, int target,int i,int sum,Map<String,Integer> map){
        if(i==nums.length){
            return (sum==target) ? 1:0;
        }
        String key= sum+"()"+i;
        if(map.containsKey(key)) return map.get(key);
        int c=0;
         c += findWays(nums,target,i+1,sum+nums[i],map);
         c +=findWays(nums,target,i+1,sum-nums[i],map);
        map.put(key,c);
        return c;
    }
}