class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]= new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                if(j==0){
                    dp[i][j]=i;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1];
                }else{
                    int ans1= dp[i][j-1]+1;
                    int ans2 =dp[i-1][j]+1;
                    int ans3=  dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(ans1,Math.min(ans2,ans3));
                }
            }
        }
        return dp[n][m];
    }
}