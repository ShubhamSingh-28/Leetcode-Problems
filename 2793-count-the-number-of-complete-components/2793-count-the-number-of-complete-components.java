class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();
         for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int res=0;
        for(int e[]:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
               int r[]= dfs(adj,vis,i);
               int v=r[0];
                int e=r[1];
                if(v*(v-1)==e){
                    res++;
                }
            }
        }
        return res;
    }

    public int[] dfs(List<List<Integer>> adj,boolean vis[], int i){
       vis[i] = true;
        int vertices = 1;  // Count the current node
        int edges = 0;     // Count edges as we visit them
        
        for (int neighbor : adj.get(i)) {
            if (!vis[neighbor]) {
                int[] subResult = dfs(adj, vis, neighbor);
                vertices += subResult[0]; // Add vertices in the connected component
                edges += subResult[1];     // Add edges from the recursive call
            }
            // Add 1 for each edge as we traverse it
            edges++;
        }
        
        return new int[] {vertices, edges};
    }
}