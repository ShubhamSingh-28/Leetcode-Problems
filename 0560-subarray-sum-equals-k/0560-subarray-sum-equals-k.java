class Solution {
    public int subarraySum(int[] nums, int k) {
         HashMap<Integer, Integer> my = new HashMap<>();
        int count = 0;
        int sum = 0;
         my.put(0, 1);
          for (int element : nums) {
            sum+=element;
            int ans= sum-k;
            count+=my.getOrDefault(ans,0);
            my.put(sum,my.getOrDefault(sum,0)+1);
        }
         return count;
    }
}