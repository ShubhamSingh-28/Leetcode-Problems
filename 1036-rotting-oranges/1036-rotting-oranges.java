class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q =new LinkedList<>();
        int freshCount =0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    freshCount++;
                }else if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        if(freshCount==0){
            return 0;
        }
        
        
        int time=0;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                int node[]= q.poll();
                int r= node[0];
                int c = node[1];
                int neighours[][]= {{r-1,c},{r,c+1},{r+1,c},{r,c-1}};
                for(int ns[] : neighours){
                    int nr = ns[0];
                    int nc = ns[1];
                    if(nr<0 || nr>=n || nc<0|| nc>=m  || grid[nr][nc]==2 || grid[nr][nc] ==0){
                        continue;
                    }
                    
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc}); 
                        freshCount--;
                        if(freshCount==0){
                            return time+1;
                        }
                    
                }
            }
            time++;
        }
        return (freshCount==0)? time :-1;
    }
}