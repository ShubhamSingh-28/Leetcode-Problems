class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if(digits.length()==0) return res;
        backtrack(digits,map,res,"",0);
        return res;
    }

    private void backtrack(String digits,Map<Character,String> map,List<String> res,String ans, int i){
        if(i==digits.length()){
            res.add(ans);
            return;
        }
        char curChar= digits.charAt(i);
        String cur = map.get(curChar);
        for(int ind=0;ind<cur.length();ind++){
            ans+=cur.charAt(ind);
            backtrack(digits,map,res,ans,i+1);
            ans=ans.substring(0,ans.length()-1);
        }
    }
}