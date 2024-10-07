class Solution {
    class Pair implements Comparable<Pair>{
        String a;
        int b;
        Pair(String a, int b){
            this.a=a;
            this.b=b;
        }
        public int compareTo(Pair that){
            if(this.b==that.b){
                return this.a.compareTo(that.a);
            }
            return this.b-that.b;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        HashSet<Integer> visited= new HashSet<>();
        List<Pair> res= new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        q.offer(id);
        visited.add(id);
        int curlevel=0;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i= 0; i<size; i++){
                int node= q.poll();
                for(int f: friends[node]){
                    if(!visited.contains(f)){
                        q.offer(f);
                        visited.add(f);
                    }
                }
            }
            curlevel++;
            if(curlevel==level){
                break;
            }
        }
        HashMap<String, Integer> map= new HashMap<>();
        while(!q.isEmpty()){
            int cur= q.poll();
            for(String a: watchedVideos.get(cur)){
                map.put(a, map.getOrDefault(a,0)+1);
            }
        }

        for(String a: map.keySet()){
            res.add(new Pair(a,map.get(a)));
        }
        Collections.sort(res);
        List<String> ret = new ArrayList<>();

        for(Pair p: res){
            ret.add(p.a);
        }
        return ret;
    }
}