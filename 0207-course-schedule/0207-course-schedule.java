class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int indegree[]= new int[numCourses];
        for(int n[]:prerequisites){
            int u=n[0];
            int v= n[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if (indegree[i]==0 ){
               q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int src=q.poll();
            count++;
            for(int child:adj.get(src)){
                indegree[child]--;
                if(indegree[child]==0){
                    q.add(child);
                }
            }
        }
        return count==numCourses;
    }
}