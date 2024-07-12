class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
          if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return false;
        }
          if(target < arr[0][0] || target > arr[arr.length - 1][arr[0].length - 1]) return false ;
          int n = arr.length;    
          int m = arr[0].length;  
          int start = 0;
            int end = n*m-1;
            while (start<=end) {
                int mid = start+ (end-start)/2;
                int r= mid/m;
                int c = mid%m;
                 if (r >= 0 && r < n && c >= 0 && c < m) {
                int val = arr[r][c];
                if (val==target) {
                   return true;
                } else if (val<target) {
                        start = mid+1;
                } else {
                    end = mid-1;
                }
                 } else{
                    break;
                 }
            }
            return false;
    }
}