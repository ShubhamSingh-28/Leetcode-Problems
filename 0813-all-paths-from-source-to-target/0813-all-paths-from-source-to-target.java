class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj= new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
         cur.add(0);
        dfs(graph,adj,0,graph.length-1,cur);
        return adj;
    }

    public void dfs(int[][] graph,List<List<Integer>> adj,int src, int dest,List<Integer> cur){
        if(src==dest){
            adj.add(new ArrayList<>(cur));
            return;
        } else{
            int vis[]= graph[src];
            for(int i:vis){
                cur.add(i);
                dfs(graph,adj,i,dest,cur);
                cur.remove(cur.size()-1);
            }
        }

    }
}