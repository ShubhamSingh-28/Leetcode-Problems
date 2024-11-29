class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int n[]:prerequisites){
            int u=n[1];
            int v= n[0];
            adj.get(u).add(v);
        }
       int []indegree=new int[numCourses];
        for (int index = 0; index < adj.size(); index++) {
            for (int a : adj.get(index)) {
                indegree[a]++;
            }
        }
         Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i]==0) {
                q.offer(i);
            }
        }
        //ArrayList<Integer> l= new ArrayList<>();
        int ans[]= new int[numCourses];
        int i=0;
        while (!q.isEmpty()) {
            int node =q.poll();
            ans[i++]=node;
            for (int a : adj.get(node)) {
                indegree[a]--;
                if (indegree[a]==0) {
                    q.offer(a);
                }
            }
        }
        return i==numCourses?ans:new int[0];
    }
}