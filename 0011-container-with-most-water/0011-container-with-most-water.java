class Solution {
    public int maxArea(int[] height) {
        int s=0;
        int e= height.length-1;
        int max=0;

        while(s<e){
            max=Math.max(max,(e-s)*Math.min(height[s],height[e]));

            if(height[s]<height[e]){
                s++;
            } else{
                e--;
            }

        }
        return max;
    }
}