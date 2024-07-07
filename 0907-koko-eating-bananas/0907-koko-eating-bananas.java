class Solution {
     public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            end = Math.max(end, piles[i]);
        }
        int ans=-1;
        while (start<=end) {
            int mid = start + (end-start)/2;
            if (isEatingSpeedValid(piles,mid,h)) {
                ans = mid;
                end=mid-1;
            } else{
                start=mid+1;
            }
        }
        return ans;
    }

     boolean isEatingSpeedValid(int[] piles, int k, int h) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += piles[i]/k;
            if (piles[i]%k!=0) {
                time+=1;
            }
            if (time>h) {
                return false;
            }
        }
        return true;
     }


}