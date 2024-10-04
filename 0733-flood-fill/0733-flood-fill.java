class Solution {
    int rows;
    int cols;
    public void dfs(int[][] image, int row, int col, int newcolor, int Curcolor, boolean visited[][]){
        // out of bound condition.
        if(row<0 || row>=rows || col<0 || col>=cols ||image[row][col]!=Curcolor || visited[row][col]){
            return;
        }
        image[row][col]=newcolor;
        visited[row][col]=true;
        int a[][]= {{row+1,col}, {row-1, col}, {row,col+1}, {row, col-1}};
        for(int neighour[] : a){
            dfs(image, neighour[0],neighour[1],newcolor,Curcolor,visited);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows= image.length;
        cols=image[0].length;
        boolean visited[][]= new boolean[rows][cols];
        dfs(image, sr,sc,color,image[sr][sc],visited);
        return image;
    }
}