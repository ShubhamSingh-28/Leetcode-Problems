class Solution {
    public String getHappyString(int n, int k) {
        List<String> res= new ArrayList<>();
        backtrack(n,res,new StringBuilder());
        return (k>res.size()) ? "":res.get(k-1);
    }

    public void backtrack(int n,List<String> res,StringBuilder cur){
        if(n==cur.length()){
            res.add(cur.toString());
            return;
        }
        char [] ch={'a','b','c'};
        for(char c:ch){
            if(cur.length()>0 && cur.charAt(cur.length()-1)==c ) continue;
            cur.append(c);
            backtrack(n,res,cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}