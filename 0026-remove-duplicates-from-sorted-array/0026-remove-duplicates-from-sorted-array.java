class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int n: nums) set.add(n);
        int i=0;
        Arrays.fill(nums,0);
        for(int num :set){
            nums[i]=num;
            //set.remove(n);
            i++;
        }
        return i;
    }
}