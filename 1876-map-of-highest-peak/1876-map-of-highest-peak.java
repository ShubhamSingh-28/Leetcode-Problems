class Solution {
    public int[][] highestPeak(int[][] isWater) {
         int n= isWater.length;
        int m=isWater[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q= new LinkedList<>();
        int res[][]= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==1){
                    res[i][j] = 0;
                    q.add(new int[]{i,j});
                } else{
                    res[i][j]=-1;
                }
            }
        }

        while(!q.isEmpty()){
            int node[] = q.poll();
            int r = node[0];
            int c = node[1];
            int h=res[r][c];

            for(int [] dir : directions){
                int nr = r+dir[0];
                int nc = c+dir[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && res[nr][nc]==-1){
                    res[nr][nc]=h+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return res;
    }
}