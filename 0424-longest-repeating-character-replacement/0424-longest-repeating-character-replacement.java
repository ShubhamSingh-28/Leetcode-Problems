class Solution {
    public int characterReplacement(String s, int k) {
        int st=0;
        int e=0;
        int n=s.length();
        int maxlen=0;
        int f[]= new int[26];
        int res=0;
        while(e<n){
            char ch=s.charAt(e);
            f[ch-'A']++;
            maxlen=Math.max(maxlen,f[ch-'A']);
            if(e-st+1-maxlen>k){
                char ch2=s.charAt(st);
                f[ch2-'A']--;
                st++;
            }
            res=Math.max(res,e-st+1);
            e++;
        }
        return res;
    }
}