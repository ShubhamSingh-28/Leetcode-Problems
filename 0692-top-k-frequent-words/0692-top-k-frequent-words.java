class Solution {
    class Pair implements Comparable<Pair> {
        String str;
        int fre;
        Pair(String str, int n){
            this.str=str;
            this.fre = n;
        }

        @Override
        public int compareTo(Pair that) {
            if(this.fre==that.fre){
                return this.str.compareTo(that.str);
            } else{
                return that.fre - this.fre;
            }
        }

    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        for(Map.Entry<String,Integer> m:map.entrySet()){
            int val=m.getValue();
            String key = m.getKey();
            pq.add(new Pair(key,val));
        }
        List<String> res= new ArrayList<>();
        while(!pq.isEmpty() && k>0){
            Pair p = pq.poll();
            k--;
            res.add(p.str);
        }
        return res;
    }
}