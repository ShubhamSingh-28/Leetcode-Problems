class Solution {
    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        boolean flag=false;
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,q);
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }

        return bfs(grid,q);
    }
    public void dfs(int[][] grid, int i, int j, Queue<int[]> q){
        if(i<0 || j<0 || i>= grid.length || j>=grid[0].length || grid[i][j]== 0 || grid[i][j]== -1) {
            return ;
        }
        grid[i][j] = -1;
        q.add(new int[]{i,j});
        dfs(grid,i+1,j,q);
        dfs(grid,i-1,j,q);
        dfs(grid,i,j+1,q);
        dfs(grid,i,j-1,q);
    }

    public int bfs(int [][] grid, Queue<int[]> q){
        int[][] trav= {{-1,0},{0,1},{1,0},{0,-1}};
        int level=0;
        while(!q.isEmpty()){
            int size= q.size();
            while(size-- > 0){
                int node[]= q.poll();
                int i=node[0];
                int j= node[1];
                for(int[] d : trav){
                    int nr=i+d[0];
                    int nc= j+d[1];
                    if(nr<0 || nc<0 || nr>= grid.length || nc>=grid[0].length || grid[nr][nc]== -1) {
                        continue ;
                    }
                    if(grid[nr][nc]==1){
                        return level;
                    } else{
                        grid[nr][nc]= -1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            level++;
        }
        return -1;
    }
}