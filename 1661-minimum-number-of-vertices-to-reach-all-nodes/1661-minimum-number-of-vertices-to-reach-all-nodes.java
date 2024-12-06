class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // int [] visited= new int[n];
        // for(int i=0; i<edges.size();i++){
        //     visited[edges.get(i).get(1)]++;
        // }
        int indegree[]= new int[n];
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            indegree[to]++;
        }
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}