class Solution {
    public boolean bfs(int src, int[][] graph,int color[] ){
        Queue<Integer> q= new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node= q.poll();
            for(int a: graph[node]){
                if(color[a]==-1){
                    color[a]=1-color[node];
                    q.add(a);
                } else if(color[a]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int color[]=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                if(!bfs(i,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }
}