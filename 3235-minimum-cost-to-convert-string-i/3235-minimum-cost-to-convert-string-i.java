class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int [][] dist= new int [26][26];
        for(int i=0;i<26;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i]=0;
        }

        for(int i=0;i<cost.length;i++){
            int s=original[i]-'a';
            int e=changed[i]-'a';
            dist[s][e]=Math.min(dist[s][e],cost[i]);
        }

        for(int k =0; k<26;k++){
            for(int i =0; i<26;i++){
                if(dist[i][k]<Integer.MAX_VALUE){
                    for(int j =0; j<26;j++){
                        if(dist[k][j]<Integer.MAX_VALUE){
                            dist[i][j]= Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                        }
                    }
                }
            }
        }

        long ans= 0L;
        for(int i=0;i<source.length();i++){
            int c1=source.charAt(i)-'a';
            int c2=target.charAt(i)-'a';
            if(dist[c1][c2 ]== Integer.MAX_VALUE){
                return -1L;
            } else {
                ans+= (long)dist[c1][c2];
            }
        }
        return ans;
    }
}