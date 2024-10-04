// class Solution {
//     // dfs approach
//     int rows;
//     int cols;
//     public void dfs(int[][] image, int row, int col, int newcolor, int Curcolor){
//         // out of bound condition.
//         if(row<0 || row>=rows || col<0 || col>=cols ||image[row][col]!=Curcolor || image[row][col]==newcolor){
//             return;
//         }
//         image[row][col]=newcolor;
//         //visited[row][col]=true;
//         int a[][]= {{row+1,col}, {row-1, col}, {row,col+1}, {row, col-1}};
//         for(int neighour[] : a){
//             dfs(image, neighour[0],neighour[1],newcolor,Curcolor);
//         }
//     }

//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         rows= image.length;
//         cols=image[0].length;
//         //boolean visited[][]= new boolean[rows][cols];
//         dfs(image, sr,sc,color,image[sr][sc]);
//         return image;
//     }
// }


class Solution {
    // bfs approach
    int rows;
    int cols;


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows= image.length;
        cols=image[0].length;
        int curColor = image[sr][sc];
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{sr,sc});
        image[sr][sc]= color;
        while(!q.isEmpty()){
            int node[]= q.poll();
            int row=  node[0];
            int col= node[1];
            int a[][]= {{row+1,col}, {row-1, col}, {row,col+1}, {row, col-1}};
        for(int neighour[] : a){
             // out of bound condition.
             int r=neighour[0];
             int c = neighour[1];
        if(r<0 || r>=rows || c<0 || c>=cols ||image[r][c]!=curColor || image[r][c]==color){
            continue;
        }
        q.offer(new int[]{r,c});
        image[r][c]=color;    
        }
        }
        return image;
    }
}