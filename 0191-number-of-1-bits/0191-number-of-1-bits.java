class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while(n!=0){
            res++;
            n=(n &  n-1);
        }
        // for (int i = 0; i < 32; i++) {
        //     if (((n >> i) & 1) == 1) {
        //         res += 1;
        //     }
        // }
        return res;    
    }
}