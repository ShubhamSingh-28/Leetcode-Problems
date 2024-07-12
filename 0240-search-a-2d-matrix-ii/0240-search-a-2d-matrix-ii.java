class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0;
        int end = m-1;
        while(start < n && end>=0){
            int mid =start +(end-start)/2;
            int val = matrix[start][end];
            if(val== target){
                return true;
            } else if( val<target){
                start = start+1;
            } else {
                end= end-1;
            }
        }
        return false;
    }
}