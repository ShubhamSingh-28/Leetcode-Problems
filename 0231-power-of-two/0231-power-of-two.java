class Solution {
    public boolean isPowerOfTwo(int n) {
       if(n >= 1 && (n & (n-1))==0){
        return true;
       }
       return false;
    }
}