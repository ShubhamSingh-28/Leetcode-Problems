class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int in[]= new int[numCourses];

        for(int edge[] :prerequisites){
            adj.get(edge[1]).add(edge[0]);
            in[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        int c=0;

        while(!q.isEmpty()){
            int node= q.poll();
            c++;
            for(int a : adj.get(node)){
                in[a]--;
                if(in[a]==0){
                    q.add(a);
                }
            }
        }
        return c==numCourses ;

    }
}