class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]= new int[text1.length()+1][text2.length()+1];
        int n=dp.length;
        int m=dp[0].length;
        //tabulation
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                } else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n-1][m-1];
    }
}