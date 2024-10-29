class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int start=0,startIndex = 0;
        int e=0;
        int n=t.length();
        char [] ch= s.toCharArray();
        int m= ch.length;
        int map[]= new int[128];
        for(char c : t.toCharArray() ){
            map[c]++;
        }
        int min=Integer.MAX_VALUE;
        while(e<m){
            if(map[ch[e++]]-- > 0){
                n--;
            }
            while(n==0){
                if(e-start < min){
                    startIndex = start;
                    min=e-start;
                }
                if(map[ch[start++]]++ ==0){
                    n++;
                }
            }
        }
        return  min==Integer.MAX_VALUE ? new String() : new String(ch,startIndex,min);
    }
}