class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      List<List<Integer>> adjlist= new ArrayList<>();
      int indegree[] = new int[numCourses];
      for (int i = 0; i < numCourses; i++) {
            adjlist.add(new ArrayList<>());
        }
      for(int p[]:prerequisites){
        int u=p[0];
        int v=p[1];
        adjlist.get(v).add(u);
        indegree[u]++;
      }
      Queue<Integer> q = new LinkedList<>();
      for(int i=0;i<numCourses;i++){
        if(indegree[i]==0){
            q.add(i);
        }
      }
      int ans[]= new int[numCourses];
        int i=0;
      while(!q.isEmpty()){
        int node=q.poll();
        ans[i++]=node;
        for(int neigh:adjlist.get(node)){
            indegree[neigh]--;
            if(indegree[neigh]==0){
                q.add(neigh);
            }
        }
      }
      return i==numCourses?ans:new int[0];
    }
}