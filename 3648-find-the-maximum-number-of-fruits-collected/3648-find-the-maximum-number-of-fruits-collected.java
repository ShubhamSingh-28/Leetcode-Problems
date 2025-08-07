class Solution {
    int n;
    int[][] dp;
    int[][] grid;
    public int maxCollectedFruits(int[][] fruits) {
        this.n = fruits.length;
        this.dp =new int[n][n];
        this.grid = fruits;
        for(int[] i: dp) Arrays.fill(i,-1);

        int first= collectFirst();
        int second = dfsSecond(0,n-1);
        int third = dfsthird(n-1,0);
        return (first+second+third);
    }
    public int dfsSecond(int i,int j){
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        if (i == n-1 && j == n-1) {
            return 0;
        }
         if ( i == j || i > j) {
            return 0;
        }
        if(dp[i][j]!= -1) return dp[i][j];
        int left = grid[i][j] + dfsSecond(i+1,j-1);
        int middle = grid[i][j] + dfsSecond(i+1,j);
        int right = grid[i][j] + dfsSecond(i+1,j+1);
        return dp[i][j] = Math.max(middle, Math.max(right,left));
    }
    public int dfsthird(int i,int j){
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        if (i == n-1 && j == n-1) {
            return 0;
        }
         if ( i == j || j > i) {
            return 0;
        }
        if(dp[i][j]!= -1) return dp[i][j];
        int top = grid[i][j] + dfsthird(i-1,j+1);
        int right = grid[i][j] + dfsthird(i,j+1);
        int topcorner = grid[i][j] + dfsthird(i+1,j+1);
        return dp[i][j] = Math.max(right, Math.max(top,topcorner));
    } 
    public int collectFirst(){
        int res =0;
        for(int i=0;i<n;i++){
            res+=grid[i][i];
            grid[i][i]=0;
            dp[i][i]=0;
        }
        return res;
    }
}