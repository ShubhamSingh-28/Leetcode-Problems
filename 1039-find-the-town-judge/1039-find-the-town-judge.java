class Solution {
    public int findJudge(int n, int[][] trust) {
        int in[]= new int[n+1];
        int out[]= new int[n+1];
        for(int t[]: trust){
            int u=t[0];
            int v=t[1];
            in[u]++;
            out[v]++;
        }
        int ans =-1;
        for(int i=1;i<=n;i++){
            if(in[i]==0 && out[i]==n-1){
                ans=i;
            }
        }
        return ans;
    }
}