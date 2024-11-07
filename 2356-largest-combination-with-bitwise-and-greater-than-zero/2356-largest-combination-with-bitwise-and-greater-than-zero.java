class Solution {
    public int largestCombination(int[] candidates) {
        int max= 0;
        for(int i = 0;i<24;i++){
            int f=0;
            for(int x : candidates){
                if((x&(1<<i))!=0){
                    f++;
                }
            }
            max= Math.max(f,max);
        }

        return max;
    }
}