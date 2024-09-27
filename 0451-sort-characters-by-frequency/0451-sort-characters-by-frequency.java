
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq= new PriorityQueue<>((e1,e2)->e2.getValue()-e1.getValue());
        pq.addAll(map.entrySet());
        String res="";
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry= pq.poll();
            for(int i=0; i<entry.getValue();i++){
                res+=entry.getKey();
           }
        }
        return res;
    }
}