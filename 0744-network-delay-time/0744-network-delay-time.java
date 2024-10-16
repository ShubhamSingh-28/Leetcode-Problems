class Solution {
    public int[] dijstra(int src, int n,ArrayList<ArrayList<int[]>> adj){
        PriorityQueue<int[]> pq= new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[]a,int[]b){
                return a[1]-b[1];
            }
        });
        int dist[]= new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        pq.offer(new int[]{src,0});
        while(!pq.isEmpty()){
            int node[] = pq.poll();
            int u = node[0];
            int d = node[1];
            if(d>dist[u]) continue;
            for(int [] a: adj.get(u)){
                int v= a[0];
                int w= a[1];
                if(dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    pq.offer(new int[]{v,dist[v]});
                }
            }
        }
        return dist;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
       ArrayList<ArrayList<int[]>> adj= new ArrayList<>();
       for(int i=0; i<n; i++){
        adj.add(new ArrayList<>());
       }
       for(int[]t : times){
        int u=t[0]-1;
        int v=t[1]-1;
        int w= t[2];
        adj.get(u).add(new int[]{v,w});
       }

       int a[]=dijstra(k-1,n,adj);
       int res= Integer.MIN_VALUE;
       for(int t:a){
        res= Math.max(res,t);
       }
       return (res== Integer.MAX_VALUE)?-1:res;
    }

}