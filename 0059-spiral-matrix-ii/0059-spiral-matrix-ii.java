class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][]= new int[n][n];
        int startRow =0;
        int endRow = n-1;
        int startCol =0;
        int endCol = n-1;
        int val = 1;
        while (startRow<=endRow && startCol<=endCol) {

            //first row
            for (int i = startCol; i <=endCol; i++) {
                matrix[startRow][i]=val;
                val+=1;
            }
            startRow+=1;

            //end column
            for (int j = startRow; j <=endRow; j++) {
                matrix[j][endCol]=val;
                val+=1;
            }
            endCol-=1;

            if (startRow<=endRow) {
                 //end row
            for (int i = endCol; i >= startCol; i--) {
                matrix[endRow][i]=val;
                val+=1;
            }
            endRow-=1;
            }
           
            if (startCol<=endCol) {
                 // first colum
            for (int j = endRow; j >=startRow; j--) {
                matrix[j][startCol]=val;
                val+=1;
            }
            startCol+=1;
            }

           
        }

        return matrix;
    }
}