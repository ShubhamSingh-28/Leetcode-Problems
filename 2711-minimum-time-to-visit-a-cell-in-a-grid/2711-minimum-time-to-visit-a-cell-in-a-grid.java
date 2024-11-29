class Solution {
    public int minimumTime(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
         if (grid[0][1] > 1 && grid[1][0] > 1)
        {
            return -1;  // Both right and down from (0, 0) are not possible
        }

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        int dir[][]= {{0,-1},{-1,0},{0,1},{1,0}};
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        while(!pq.isEmpty()){
            int node[]=pq.poll();
            int a= node[0];
            int b= node[1];
            int time= node[2];
            for(int d[]:dir){
                int nr=a+d[0];
                int nc=b+d[1];
                if(nr<0 ||  nr>=n || nc<0 || nc>=m || visited[nr][nc] ) continue;

                int newtime=time+1;
                if(grid[nr][nc]>newtime){
                    int wait=((grid[nr][nc] - newtime + 1) / 2) * 2;  
                    newtime+=wait;
                }                
                if(nr==n-1 && nc==m-1) return newtime;
                visited[nr][nc]=true;
                pq.add(new int[]{nr,nc,newtime});
            }
        }
        return -1;
    }
}