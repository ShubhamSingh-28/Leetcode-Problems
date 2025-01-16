class Solution {
    public int[] sortedSquares(int[] nums) {
        int res[]= new int[nums.length];
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int num:nums){
            pq.add((num*num));
        }
        int i=0;
        while(!pq.isEmpty()){
            res[i]=pq.poll();
            i++;
        }
        return res;
    }
}