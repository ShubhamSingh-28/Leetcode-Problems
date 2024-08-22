class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map= new HashMap<Character, String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            return res;
        }
        recur(digits,0,"",res,map);
        return res;
    }

    public void recur (String digits, int ind,String cur, List<String> res,HashMap<Character, String> map){
        
        // base case 
        if(ind== digits.length()){
            res.add(cur);
            return;
        }

        // main task
        char a = digits.charAt(ind);
        String current= map.get(a);
        for(int i=0; i<current.length(); i++){
            cur+=current.charAt(i);
            recur(digits,ind+1,cur,res,map);
            cur=cur.substring(0,cur.length()-1);

        }
    }
}