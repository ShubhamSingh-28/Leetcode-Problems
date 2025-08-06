class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) {
            return s;
        }
        int max=1;
        String Str= s.substring(0, 1);
        for(int i=0;i<s.length();i++){
            for(int j=i+max;j<=s.length();j++){
                if(j-i>max && isPalindrome(s.substring(i,j))){
                    max=j-i;
                    Str=s.substring(i,j);
                }
            }
        }
        return Str;
    }
    private boolean isPalindrome(String s){
        int st=0;
        int e=s.length()-1;
        while(st<e){
            if(s.charAt(st)!=s.charAt(e)) return false;
            st++;
            e--;
        }
        return true;
    }
}