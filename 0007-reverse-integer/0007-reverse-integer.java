class Solution {
    public int reverse(int x) {
        if(x > Integer.MAX_VALUE/2 || x < Integer.MIN_VALUE/2) return 0;
        int a=Math.abs(x);
        int res=0;
        while(a!=0){
            int count = a % 10;
             if(res>(Integer.MAX_VALUE-count)/10){
                return 0;
            }
            res = res*10+count;
            a/=10;
        }
        return (x<0) ? -res :res;
    }
}