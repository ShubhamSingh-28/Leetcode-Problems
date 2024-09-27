
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq= new PriorityQueue<>((e1,e2)->e2.getValue()-e1.getValue());
        pq.addAll(map.entrySet());
        StringBuilder res=new StringBuilder() ;
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry= pq.poll();
            for(int i=0; i<entry.getValue();i++){
                res.append(entry.getKey());
           }
        }
        return res.toString();
    }
}