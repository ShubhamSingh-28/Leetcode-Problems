class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur =  new ArrayList<Integer>();
        recur(candidates,target,0,res,cur);
        return res;
    }

    public void recur(int[] candidates, int target,int ind, List<List<Integer>> res,List<Integer> cur){
        if(ind==candidates.length){
            if(target==0){
            res.add(new ArrayList<>(cur));
        }
            return;
        }
        if(target>=candidates[ind]){
            cur.add(candidates[ind]);
            recur(candidates,target-candidates[ind],ind,res,cur);
            cur.remove(cur.size()-1);
        }
        recur(candidates,target, ind+1,res,cur);
    }
   
}