class Solution {
    public int bfs(List<List<Integer>> adj,int n){
        int dist[]= new int[n];
        Arrays.fill(dist,-1);
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        dist[0]=0;
        while(!q.isEmpty()){
            int node= q.poll();
            for(int neigh: adj.get(node)){
                if(dist[neigh] ==-1){
                    dist[neigh]=dist[node]+1;
                    q.add(neigh);
                }
            }
        }
        return dist[n-1];
    }
    public int dijk(List<List<Integer>> adj,int n){
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0});
        int dist[]= new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;  
        while(!pq.isEmpty()){
            int node[]= pq.poll();
            int d=node[1];
            int u= node[0];
            if (d > dist[u]) {
                continue;
            }

            for(int neigh: adj.get(u)){
                int v= neigh;
                int w= 1;
                if(dist[u]+w < dist[v]){
                    dist[v]=dist[u]+w;
                    pq.add(new int []{v,dist[v]});
                }
            }
        }
        return dist[n-1];
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){  
            adj.get(i).add(i+1);
        }
        int res[] = new int[queries.length];
        int i=0;
        for(int q[] :queries){
            adj.get(q[0]).add(q[1]);
            res[i]=dijk(adj,n);
            i++;
        }
        return res;
    }
}