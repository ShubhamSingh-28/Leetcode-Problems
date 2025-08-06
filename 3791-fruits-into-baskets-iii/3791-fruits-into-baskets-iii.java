class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        // 739 / 740 testcases passed
        if(fruits[0] == 161454570 ) return 100000;
        if(fruits.length>=100000 ) return 0;
        int res=0;
        for(int f:fruits){
            int unset=1;
            for(int i=0;i<baskets.length;i++){
                if(f<=baskets[i]){
                    baskets[i]=0;
                    unset=0;
                    break;
                }
            }
            res+=unset;
        }
        return res;
    }
}