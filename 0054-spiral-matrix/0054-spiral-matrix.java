class Solution {
      public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;   
        int m = matrix[0].length;
        int startRow =0;
        int endRow = n-1;
        int startCol =0;
        int endCol = m-1;

        while (startRow<=endRow && startCol<=endCol) {

            //first row
            for (int i = startCol; i <=endCol; i++) {
                result.add(matrix[startRow][i]);
            }
            startRow+=1;

            //end column
            for (int j = startRow; j <= endRow; j++) {
                result.add(matrix[j][endCol]);
            }
            endCol-=1;

            if (startRow<=endRow) {
                 //end row
            for (int i = endCol; i >= startCol; i--) {
                result.add(matrix[endRow][i]);
            }
            endRow-=1;
            }
           
            if (startCol<=endCol) {
                 // first colum
            for (int j = endRow; j >=startRow; j--) {
                result.add(matrix[j][startCol]);
            }
            startCol+=1;
            }

           
        }

        return result;
    }

}