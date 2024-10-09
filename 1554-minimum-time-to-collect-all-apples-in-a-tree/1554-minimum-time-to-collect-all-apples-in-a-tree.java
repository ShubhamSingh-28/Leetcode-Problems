class Solution {
    public int dfs(int src, int parent, List<List<Integer>> adj, List<Boolean> hasApple){
        int time=0;
        for(int neigh : adj.get(src)){
            if(neigh== parent){
                continue;
            }
            int tt= dfs(neigh, src,adj,hasApple);
            if(tt>0 || hasApple.get(neigh)){
                time+= tt + 2;
            }
        }
        return time;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            int u= edge[0];
            int v= edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(0,-1,adj, hasApple);
    }
}