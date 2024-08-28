class Solution {
    public int totalNQueens(int n) {
         int[][]arr= new int[n][n];
        int a= solveNQueens(n, arr,0);
        return a;
    }
     public int solveNQueens(int n, int[][]arr, int col){
        if (col==n) {
            return 1;
        }
        int count = 0;
        for (int row = 0; row < n; row++) {
            if(isSafe(n, arr, col,row)){
                arr[row][col]=1;
               count+= solveNQueens(n,arr, col+1);
                arr[row][col]=0;
            }
        }
        return count;
    }
    public  boolean isSafe(int n, int[][]arr, int col, int row){
        // left side
        for (int i = 0; i < col; i++) {
            if (arr[row][i] == 1) {
                return false;
            }
        }

        // upper diagonal
        for (int i = row, j=col; i>=0 && j>=0; i--,j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        // lower diagonal
        for (int i = row, j=col; i<n && j>=0; i++,j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}