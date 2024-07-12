class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        for (int i = 0; i <  arr.length; i++) {  
            int start = 0;
            int end = arr[i].length-1;
            while (start<=end) {
                int mid = start+ (end-start)/2;
                if (arr[i][mid]==target) {
                    return true;
                } else if (arr[i][mid]<target) {
                        start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
    return false;
    }
}