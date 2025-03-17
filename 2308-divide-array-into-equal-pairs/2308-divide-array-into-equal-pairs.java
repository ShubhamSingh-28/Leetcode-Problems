class Solution {
    public boolean divideArray(int[] nums) {
        // 1st approach sorting time :-O(nlogn);
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length-1;i+=2){
        //     if(nums[i]!=nums[i+1]) return false ;
        // }
        // return true;

        // 2nd approach hashMap tc:-O(n) and sc O(n);
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int n:nums){
        //     map.put(n,map.getOrDefault(n,0)+1);
        // }

        // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     if(entry.getValue() %2 != 0) return false;
        // }
        // return true;

        //3rd aproch set tc:-O(n) and sc O(n);
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            if(set.contains(n)){
                set.remove(n);
            }else{
                set.add(n);
            }
        }
        return set.isEmpty();
    }
}