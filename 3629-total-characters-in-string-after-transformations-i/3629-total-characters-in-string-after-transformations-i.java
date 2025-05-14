class Solution {
     private static final int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
         int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            ++cnt[ch - 'a'];
        }
        for (int round = 0; round < t; ++round) {
            int[] nxt = new int[26];
            nxt[0] = cnt[25];
            nxt[1] = (cnt[25] + cnt[0]) % MOD;
            for (int i = 2; i < 26; ++i) {
                nxt[i] = cnt[i - 1];
            }
            cnt = nxt;
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans = (ans + cnt[i]) % MOD;
        }
        return ans;

        // Time Limit Exceeded 502 / 824 testcases passed
        // for(int i=0;i<t;i++){
        //     StringBuilder sb= new StringBuilder();
        //     for(char ch:s.toCharArray()){
        //         int a=ch-'a';
        //         if(a>=0 && a<25){
        //             sb.append((char)(ch+1));
        //         } else{
        //             sb.append('a');
        //             sb.append('b');
        //         }
        //     }
        //     s=sb.toString();
        // }
        // return s.length();
    }
}