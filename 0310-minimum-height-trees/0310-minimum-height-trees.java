class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
         if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;++i){
            adj.add(new HashSet<>());
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<n;++i){
            if(adj.get(i).size()==1) list.add(i);
        }
        while(n>2){
            n-=list.size();
            List<Integer> newlist= new ArrayList<>();
            for(int i:list){
                int j=adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if(adj.get(j).size()==1) newlist.add(j);
            }
            list=newlist;
        }
        return list;

    }
}