class Solution {
    public String countAndSay(int n) {
        String s="1";
        for(int i=2; i<=n; i++){
            s=solve(s);
        }
        return s;
    }

    public String solve(String s){
        StringBuilder sb= new StringBuilder();
        int c=1;
        char ch= s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(ch==s.charAt(i)){
                c++;
            }else{
                sb.append(c);
                sb.append(ch);
                ch=s.charAt(i);
                c=1;
            }
        }
        sb.append(c);
        sb.append(ch);
        return sb.toString();
    }

}