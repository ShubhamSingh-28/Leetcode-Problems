class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        recur(nums,list,0, new ArrayList<>());
        return list;
    }
    public void recur(int nums[],List<List<Integer>>list,int i,List<Integer>cur){
        list.add(new ArrayList<>(cur));
        for(int j=i;j<nums.length;j++){
            cur.add(nums[j]);
            recur(nums,list,j+1,cur);
            cur.remove(cur.size()-1);
        }
    }
}