class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subset(nums,0,res,new ArrayList<>());
        int ans=0;
        for(List<Integer> ns:res){
            int x=0;
            for(int s:ns){
                x^=s;
            }
            ans+=x;
        }
        return ans;
    }
    public void subset(int nums[],int i,List<List<Integer>> res,List<Integer> cur){
        res.add(new ArrayList<>(cur));
        for(int ind=i;ind<nums.length;ind++){
            cur.add(nums[ind]);
            subset(nums,ind+1,res,cur);
            cur.remove(cur.size()-1);
        }

    }
}