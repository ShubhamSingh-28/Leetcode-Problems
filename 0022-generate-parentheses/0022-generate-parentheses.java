class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        back(n,res,"",0,0);
        return res;
    }
    public void back(int n, List<String> res, String s, int left, int right){
        if(s.length()==n*2){
            res.add(s);
            return;
        }
        if(left<n){
            back(n,res,s+"(", left+1,right);
        }

        if(right<left){
            back(n,res,s+")", left,right+1);
        }

    }
}