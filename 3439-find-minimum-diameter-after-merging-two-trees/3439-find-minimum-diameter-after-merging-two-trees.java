class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int[] tree1= func(edges1.length+1,edges1);
        int[] tree2= func(edges2.length+1,edges2);
        return Math.max(Math.max(tree1[1], tree2[1]),tree1[0]+tree2[0]+1);
    }

    public int[] func(int n, int[][]edges){
        if(n<=2) return new int[]{n-1,n-1};
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int [] degree= new int[n];
        for(int[] ed: edges){
            adj.get(ed[0]).add(ed[1]);
            degree[ed[0]]+=1;
            adj.get(ed[1]).add(ed[0]);
            degree[ed[1]]+=1;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                q.add(i);
            }
        }
        int height=0;
        int lastSize=0;

        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                int node= q.poll();
                for(int neigh: adj.get(node)){
                    degree[neigh]-=1;
                    if(degree[neigh]==1){
                        q.add(neigh);
                    }
                }
            }
            lastSize=size;
            height+=1;
        }
        height-=1;
        int diameter= 2*height;
        if(lastSize>1){
            height+=1;
            diameter+=1;
        }
        return new int[]{height,diameter};
    }
}