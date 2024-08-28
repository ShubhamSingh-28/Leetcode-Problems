class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n= grid.length;
        int m =  grid[0].length;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public  void dfs (char[][]m, int i, int j){
        // write dead ends before base case or with base case always.
        // dead ends 
        if (i<0 ||i>=m.length || j<0 || j>=  m[i].length || m[i][j]=='0' ||m[i][j]=='2' ) {
            return;
        }
        m[i][j]='2';
        dfs(m,i-1,j);
        dfs(m,i+1,j);
        dfs(m,i,j+1);
        dfs(m,i,j-1);
    }
}