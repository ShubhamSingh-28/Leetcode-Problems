class Solution {
    public long coloredCells(int n) {
       // O(N) time conplexity
        // long res =1;
        // int a=4;
        
        // while(--n>0){
        //     res+=a;
        //     a+=4;
        // }
        // return res;

        return 1+(long)(n-1)*n*2;
    }
}