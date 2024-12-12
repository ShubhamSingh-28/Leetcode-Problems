class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i:gifts){
            pq.add(i);
        }

        for(int i=0;i<k && pq.peek() > 1 ; i++){
            int x= pq.poll();
            pq.add((int) Math.sqrt(x));
        }
        long sum=0;
        for(int val : pq){
            sum+=val;
        }
        return sum;
    }
}