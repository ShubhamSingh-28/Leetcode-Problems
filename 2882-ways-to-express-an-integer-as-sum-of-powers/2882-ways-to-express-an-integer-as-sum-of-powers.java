class Solution {
        public int MOD = (int) 1e9 + 7;
        private long[][] dp = new long[301][301];
    public int numberOfWays(int n, int x) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return (int)(f(1,0,n,x)%MOD);
    }
    long f(int s, int i, int n, int x){
        if(s>n || i>n) return i==n ? 1:0;
        if(i == n) {
            dp[s][i]=1;
            return 1;
        }
        if(dp[s][i]!=-1){
            return dp[s][i];
        }
        long ans =0;
        ans+=f(s+1,i,n,x)%MOD;
        ans+=f(s+1,(int)(i+Math.pow(s,x)),n,x)%MOD;
        return dp[s][i]=ans; 
    }
}