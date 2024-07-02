class Solution {
    public int[] searchRange(int[] nums, int target) {
         int res[] = new int[2];
       int last = firstandlastOccurance(nums, target, false);
       int first = firstandlastOccurance(nums, target, true);
       res[0] = first;
       res[1] = last;
       return res;
    }

    public static int firstandlastOccurance(int arr[], int target,boolean isfirst){
        int start= 0;
        int end = arr.length-1;
        int ans = -1;

        while (start <= end) {
            int mid = start+ (end-start)/2;
            if (arr[mid] == target) {
                ans = mid;
                 if (isfirst) {
                    end = mid-1;
                } else{
                    start  = mid+1;
                }
            } else if (arr[mid] < target) {
                start = mid +1;
            } else {
                end = mid-1;
            }
        }
        
           return ans;
        
    }

}