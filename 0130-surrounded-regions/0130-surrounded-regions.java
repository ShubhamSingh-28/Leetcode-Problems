class Solution {
    public void solve(char[][] board) {
        int n= board.length;
        int m= board[0].length;
        boolean visited[][]= new boolean[n][m];

        for(int i=0;i<n;i++){
            if(!visited[i][0] && board[i][0]=='O'){
                dfs(board,i,0, visited);
            }
            if(!visited[i][m-1] && board[i][m-1]=='O'){
                dfs(board,i,m-1, visited);
            }
        }

         for(int i=0;i<m;i++){
            if(!visited[0][i] && board[0][i]=='O'){
                dfs(board,0,i, visited);
            }
            if(!visited[n-1][i] && board[n-1][i]=='O'){
                dfs(board,n-1,i, visited);
            }
        }
         for(int i=0;i<n;i++){
           for(int j=0;j< m; j++){
            if(!visited[i][j] && board[i][j]=='O'){
                board[i][j]='X';
            }
           }
        }
    }

    void dfs(char[][]board, int row, int col, boolean visited[][]){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || visited[row][col] || board[row][col]=='X'){
            return;
        }
        visited[row][col]=true;
        dfs(board,row+1,col, visited);
        dfs(board,row-1,col, visited);
        dfs(board,row,col+1, visited);
        dfs(board,row,col-1, visited);
    }
}