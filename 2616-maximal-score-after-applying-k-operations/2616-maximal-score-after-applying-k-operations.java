class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
        }
        long score=0;
        while(k>0){
            score+=pq.peek();
            pq.offer((int)Math.ceil(pq.poll()/3.0));
            k--;
        }
        return score;
    }
}