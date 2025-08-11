class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n,0,0,res,"");
        return res;
    }
    private void generate(int n, int i,int j,List<String> res,String s){
        if(s.length()==n*2){
            res.add(s);
            return;
        }
        if(i<n){
            generate(n,i+1,j,res,s+'(');
        }
        if(i>j){
            generate(n,i,j+1,res,s+')');
        }
    }

}