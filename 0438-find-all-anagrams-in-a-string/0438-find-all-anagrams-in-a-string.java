class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list= new ArrayList<>();
        if(p.length()> s.length()) return list;
        Map<Character,Integer> map= new HashMap<>();
        for(char ch: p.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=map.size();
        int start=0;
        int end=0;
        int n=s.length();
        while(end<n){
            char ch=s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    count--;
                }
            }
            end++;
            while(count==0){
                char temp=s.charAt(start);
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                    if(map.get(temp)>0){
                      count++;
                    }
                }
                if(end-start==p.length()){
                    list.add(start);
                }
                start++;
            }
        }
        return list;
    }
}