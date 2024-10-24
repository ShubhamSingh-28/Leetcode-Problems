class Solution {
    public boolean canJump(int[] nums) {
        int s=0;
        int m=0;
        int e= nums.length;
        while(s<=m && s<e){
            m=Math.max(m,s+nums[s]);
            s++;
        }
        return m >= e-1;
    }
}