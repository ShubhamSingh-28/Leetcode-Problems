class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int ncolor , int color){
        if(sr<0 || sc<0 || sr>=image.length || sc >= image[0].length || image[sr][sc]!=color || image[sr][sc]==ncolor){
            return;
        }
        image[sr][sc]=ncolor;
        int [][]a = {{sr+1,sc},{sr,sc+1},{sr-1,sc},{sr,sc-1}};
        for(int an[]:a){
            dfs(image,an[0],an[1],ncolor,color);
        }
    }
}