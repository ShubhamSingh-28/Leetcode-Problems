class Solution {
    public int divide(int dividend, int divisor) {
         // edge case condition
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // edge case condition
        if(dividend == Integer.MAX_VALUE && divisor == -1 ){
            return Integer.MIN_VALUE+1;
        }
        boolean isneg = (dividend<0 && divisor>0) || (dividend>0 && divisor<0);
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        
        int count=0;
        long sum =0;
        while(a>=sum+b){
            sum+=b;
            count++;
        }
        if((isneg)){
            return -count;
        } else{
            return count;
        }
    }
}