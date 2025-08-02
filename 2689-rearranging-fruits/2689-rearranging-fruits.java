class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer,Integer> map= new TreeMap<>();
        int m= Integer.MAX_VALUE;
        for(int b:basket1){
            map.put(b,map.getOrDefault(b,0)+1);
            m=Math.min(m,b);
        }
        for(int b:basket2){
            map.put(b,map.getOrDefault(b,0)-1);
            m=Math.min(m,b);
        }
        List<Integer> ls= new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int count=entry.getValue();
            if(count%2!=0) return -1;
            for(int i=0;i<Math.abs(count)/2;i++){
                ls.add(entry.getKey());
            }
        }
        Collections.sort(ls);
        long res = 0;
        for(int i=0;i<ls.size()/2;i++){
            res+=Math.min(2*m,ls.get(i));
        }
        return res;
    }
}