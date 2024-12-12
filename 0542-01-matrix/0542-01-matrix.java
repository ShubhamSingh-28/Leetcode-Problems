class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n= mat.length;
        int m=mat[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                } else{
                    mat[i][j]=Integer.MAX_VALUE;
                }
            }
        }

        while(!q.isEmpty()){
            int node[]=q.poll();
            int r=node[0];
            int c=node[1];
            for(int dir[]:directions){
                int nr= r+dir[0];
                int nc=c+dir[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && mat[nr][nc] > mat[r][c]+1){
                    mat[nr][nc]=mat[r][c]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return mat;
    }
}