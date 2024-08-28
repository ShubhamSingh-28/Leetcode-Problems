class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        char[][] board= new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(n,board,res,0);
        return res;
    } 
    public void solve(int n, char[][]board, List<List<String>> res ,int row){
        // base case
        if(row == n){
           res.add(createBoard(board, n));
            return ;
        }
        for(int col= 0; col<n; col++){
            if(isSafe(board, row, col,n)){
                board[row][col]='Q';
                solve(n,board,res,row+1);
                board[row][col]='.';
            }
        }
    }
    public boolean isSafe (char[][]board, int row,int col,int n){
        for(int i = 0; i<col;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        for(int i = 0; i<row;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    private List<String> createBoard(char[][] board, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}