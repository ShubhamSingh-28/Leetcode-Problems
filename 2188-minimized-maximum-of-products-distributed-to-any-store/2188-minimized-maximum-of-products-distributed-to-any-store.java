class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int ans =-1;
        int start = 1;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < quantities.length; i++) {
            end = Math.max(end, quantities[i]);
        }

        while (start<= end) {
            int mid = start+ (end-start)/2;
            if (isDistributionValid(quantities,mid,n)) {
                ans= mid;
                end= mid-1;
            } else{
                start= mid+1;
            }
        }
        return ans;
     }

     boolean isDistributionValid(int quantities[], int mid, int n){
        int sum = 0;
        for (int i = 0; i < quantities.length; i++) {
            sum+= quantities[i]/mid;
            if (quantities[i]%mid!=0) {
                sum=sum+1;
            }
            if (sum>n) {
                return false;
            }
        }
        return true;
     }

}