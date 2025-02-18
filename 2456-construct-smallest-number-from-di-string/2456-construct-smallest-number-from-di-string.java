class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb= new StringBuilder();
        StringBuilder cur= new StringBuilder();

        for(int i=0;i<=pattern.length();i++){
            cur.append(i+1);
            if(i==pattern.length() || pattern.charAt(i)=='I'){
                sb.append(cur.reverse());
                cur.setLength(0);
            }
        }
        return sb.toString();
    }
}