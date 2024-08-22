class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> cur =new ArrayList<String>();
        recur(s,0,res,cur);
        return res;
    }

    public void recur (String s,int ind,List<List<String>>res, List<String>cur){

        int n = s.length();
        // base case
        if(ind >= n){
            res.add(new ArrayList<String>(cur));
            return;
        }

        // main logic

        for(int i = ind; i<n; i++){
            if(ispelindrome(s, ind ,i)){
                cur.add(s.substring(ind,i+1));
                recur(s,i+1,res, cur);
                cur.remove(cur.size()-1);
            }
            
        }
    }

    public boolean ispelindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j) ){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}