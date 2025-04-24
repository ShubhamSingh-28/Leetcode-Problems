class Solution {
    int res=0;
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][]= new int[m][n];
        for(int[] rows: dp)
            Arrays.fill(rows, -1);

         sol(matrix,0,0,dp);
         return res*res;
    }
    public int sol(char[][] mat,int i,int j, int[][] dp){
        if(i<0 || i>=mat.length || j<0 || j>=mat[0].length){
            return 0;
        }
        if(dp[i][j]!= -1){
            res=Math.max(res,dp[i][j]);
            return dp[i][j];
        }
        int down=sol(mat,i+1,j,dp);
        int right=sol(mat,i,j+1,dp);
        int digonal= sol(mat,i+1,j+1,dp);

        if(mat[i][j]=='1'){
            dp[i][j]=1+Math.min(Math.min(down,right),digonal);
            res=Math.max(res,dp[i][j]);
            return dp[i][j];
        }else{
            return dp[i][j]=0;
        }
    }
}