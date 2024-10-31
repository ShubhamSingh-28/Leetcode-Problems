class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for(String s: strs){
            char a[]= s.toCharArray();
            Arrays.sort(a);
            String newS=new String(a);
            if(!ans.containsKey(newS)){
                ans.put(newS,new ArrayList<>());
            }
            ans.get(newS).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}