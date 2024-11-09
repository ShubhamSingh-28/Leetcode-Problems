class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res= new ArrayList<>();
        backTrack(n,k,res , new ArrayList<>(),1);
        return res;
    }

    public void backTrack(int n, int k,List<List<Integer>> res,List<Integer> cur, int i ){
        if(cur.size()==k){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int j= i; j<=n; j++){
            cur.add(j);
            backTrack(n,k,res,cur,j+1);
            cur.remove(cur.size()-1);
        }
    }
}