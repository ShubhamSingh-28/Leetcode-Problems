class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q= new LinkedList<>();
        maze[entrance[0]][entrance[1]]='+';
        q.add(new int[]{entrance[0],entrance[1],0});
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!q.isEmpty()){
            int node[]=q.poll();
            int r=node[0];
            int c= node[1];
            int dist= node[2];
            for(int i=0;i<4;i++){
                int nr=r+dx[i];
                int nc=c+dy[i];
                if(nr<0 || nc<0 || nr==maze.length || nc==maze[0].length) continue;
                if(maze[nr][nc]=='+') continue;
                if(nr==0 || nc==0 || nr==maze.length-1 || nc==maze[0].length-1) return dist +1;
                maze[nr][nc]='+';
                q.add(new int[]{nr,nc,dist+1});
            }
        }
        return -1;
    }
}