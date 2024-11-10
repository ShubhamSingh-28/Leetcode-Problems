class Solution {
    public int maxJump(int[] stones) {
       int max= Math.abs(stones[0]-stones[1]);
       for(int i=2;i<stones.length;i++){
        max= Math.max(stones[i]-stones[i-2], max);
       }
       return max;
    }    
}