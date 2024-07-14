class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE, smax =Long.MIN_VALUE, tmax= Long.MIN_VALUE;
        for(int num :nums){
            if(num > max){
                tmax= smax;
                smax= max;
                max= num;
            } else if(num > smax){
                if(num != max){
                    tmax= smax;
                    smax= num;
                }
            } else if(num > tmax && smax != num){
                tmax = num;
            }
        }
        return tmax == Long.MIN_VALUE ? (int)max :(int)tmax;
    }
}