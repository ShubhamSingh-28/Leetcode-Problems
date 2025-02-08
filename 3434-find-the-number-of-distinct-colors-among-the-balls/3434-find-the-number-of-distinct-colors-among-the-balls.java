class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> m1= new HashMap<>();
        Map<Integer,Integer> m2= new HashMap<>();
        int[] res= new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int ball=queries[i][0];
            int val= queries[i][1];
            if(m1.containsKey(ball)){
                int oldColor= m1.get(ball);
                m2.put(oldColor,m2.get(oldColor)-1);
                if(m2.get(oldColor)==0){
                    m2.remove(oldColor);
                }
            }
            m1.put(ball,val);
            m2.put(val,m2.getOrDefault(val,0)+1);
            res[i]=m2.size();
        }
        return res;
    }
}