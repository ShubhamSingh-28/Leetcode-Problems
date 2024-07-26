class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        cyclesort(nums);
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!= i+1){
                list.add(i+1);
            }
        }
        return list;
    }

    public void cyclesort(int[] nums){
        int n = nums.length;
        int index = 0;
        while(index<n){
            int element = nums[index];
            int actualpos = element-1;
            if (nums[index]!= nums[actualpos]){
                swap(nums,index,actualpos);
            } else{
                index++;
            }
        }
    }

    public void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }
}