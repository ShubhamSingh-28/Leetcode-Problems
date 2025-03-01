class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> res=  new HashMap<>();
        for(String s:strs){
            char ch[]=s.toCharArray();
            Arrays.sort(ch);
            String newStr= new String(ch);
            if(!res.containsKey(newStr)){
                res.put(newStr,new ArrayList<>());
            }
            res.get(newStr).add(s);
        }
        return new ArrayList<>(res.values());
    }
}