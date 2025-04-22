class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int a:answers){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int total=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int k=m.getKey();
            int val=m.getValue();
            total+=Math.ceil((double)val/(k+1))*(k+1);
        }
        return total;
    }
}