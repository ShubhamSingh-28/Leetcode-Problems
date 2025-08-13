class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int n: nums)set.add(n);
        return (nums.length == set.size())? false :true;
    }
}