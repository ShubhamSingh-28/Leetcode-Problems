class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> red= new ArrayList<>();
        List<List<Integer>> blue= new ArrayList<>();
        int [] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);
        // graph initialization
        for(int i=0;i<n;i++){
            red.add(new ArrayList<>());
            blue.add(new ArrayList<>());
        }

        // red graph
        for(int edge[]: redEdges){
            int u= edge[0];
            int v= edge[1];
            red.get(u).add(v);
        }

        //blue graph
        for(int edge[]: blueEdges){
            int u= edge[0];
            int v= edge[1];
            blue.get(u).add(v);
        }

        int step =0;
        Queue<Pair<Integer, Integer>> q= new LinkedList<>();
         q.add(new Pair(0, 0));
        q.add(new Pair(0, 1));
        Set<Pair<Integer, Integer>> seen= new HashSet<>();

        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                Pair<Integer, Integer> node= q.poll();
                seen.add(node);
                int cur=node.getKey();
                int color=node.getValue();
                if(color==0){
                    path[cur]=Math.min(path[cur],step);
                    for(int it: blue.get(cur)){
                       Pair<Integer, Integer> child=new Pair(it,1);
                        if(!seen.contains(child)){
                            q.add(child);
                        }
                    }
                } else{
                    path[cur]=Math.min(path[cur],step);
                    for(int it: red.get(cur)){
                        Pair<Integer, Integer> child=new Pair(it,0);
                        if(!seen.contains(child)){
                            q.add(child);
                        }
                    }
                }
            }
            step++;
        }
        for (int i = 0; i < path.length; i++) {
            if (path[i] == Integer.MAX_VALUE) {
                path[i] = -1;
            }
        }

        return path;
    }
}