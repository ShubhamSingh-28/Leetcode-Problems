class Solution {
    public int[] sortedSquares(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums){
            pq.add(n*n);
        }
        int [] arr = new int[nums.length];
        int i=0;
        while(!pq.isEmpty()){
            arr[i]=pq.poll();
            i++;
        }
        return arr;
    }
}