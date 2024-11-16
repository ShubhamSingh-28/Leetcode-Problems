class Solution {
    public boolean exist(char[][] board, String word) {
        //String s= "";
        int n = board.length;
        int m= board[0].length;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                     if(dfs(board,word,visited,i,j,0)){
                        return true;
                     }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word,boolean visited[][], int r, int c,int ind){

        if(ind==word.length()){
            return true;
        }

        if(r<0 || r>=board.length || c<0 || c>=board[0].length || visited[r][c]|| board[r][c] !=word.charAt(ind)){
            return false;
        }

        visited[r][c]=true;

        if(dfs(board,word,visited,r+1,c,ind+1) || dfs(board,word,visited,r-1,c,ind+1) || dfs(board,word,visited,r,c+1,ind+1) || dfs(board,word,visited,r,c-1,ind+1)){
            return true;
        }

        visited[r][c]=false;
        return false;

    }
}