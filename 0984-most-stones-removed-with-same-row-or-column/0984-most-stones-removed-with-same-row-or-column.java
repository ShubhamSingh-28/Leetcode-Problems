class Solution {
    public void dfs(int a, List<List<Integer>> adj,boolean visited[]){
        visited[a]=true;
            for(int neigh : adj.get(a)){
                if(!visited[neigh]){
                dfs(neigh,adj, visited);
                }
            }
    }
    public int removeStones(int[][] stones) {
        int n= stones.length;
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n;i++){
            for(int j=i+1; j<n;j++){
                if(stones[i][0] == stones[j][0] ||stones[i][1] == stones[j][1]){
                  adj.get(i).add(j);
                  adj.get(j).add(i);
                }
            }
        }
        boolean visited[] = new boolean[n];
        int components=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,adj, visited);
                components++;
            }
        }
        return (n-components);
    }
}