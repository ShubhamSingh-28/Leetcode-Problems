class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        for(int i=0;i<cols;i++){
            dfs(heights,0,i,pac,heights[0][i]);
            dfs(heights,rows-1,i,atl,heights[rows-1][i]);
        }

        for(int i=0;i<rows;i++){
            dfs(heights,i,0,pac,heights[i][0]);
            dfs(heights,i,cols-1,atl,heights[i][cols-1]);
        }

        List<List<Integer>> res= new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pac[i][j]&& atl[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;

    }
    public void dfs(int[][] grid, int i, int j, boolean visited[][],int preh ){
        if(i<0 || j<0 ||i>=grid.length || j>= grid[0].length || visited[i][j] || grid[i][j]<preh){
            return ;
        }
        visited[i][j]=true;
        dfs(grid,i+1,j,visited,grid[i][j]);
        dfs(grid,i-1,j,visited,grid[i][j]);
        dfs(grid,i,j+1,visited,grid[i][j]);
        dfs(grid,i,j-1,visited,grid[i][j]);
       
    }
}