class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int [] visited= new int[n];
        for(int i=0; i<edges.size();i++){
            visited[edges.get(i).get(1)]++;
        }
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}