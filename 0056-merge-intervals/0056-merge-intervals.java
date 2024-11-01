class Solution {
    public int[][] merge(int[][] intervals) {
        int a= intervals.length;
        int b= intervals[0].length;
        Arrays.sort(intervals, (c, d) -> Integer.compare(c[0], d[0]));
        LinkedList<int[]> m = new LinkedList<>();
        m.add(intervals[0]);
        for(int i=1;i<a;i++){
            int res[]=m.getLast();
            if(res[1]>=intervals[i][0]){
                res[1]=Math.max(res[1],intervals[i][1]);
            } else{
                m.add(intervals[i]);
            }
        }
        return m.toArray(new int[m.size()][]);
    }
}