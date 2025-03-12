class Solution {
    private boolean hasAll(int freq[]){
        return (freq[0]>0 && freq[1]>0 && freq[2]>0);
    }
    public int numberOfSubstrings(String s) {
        int res=0;
        int freq[]= new int[3];
        int j=0;
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
            while(hasAll(freq)){
                res+=len-i;
                char c = s.charAt(j);
                freq[c-'a']--;
                j++;
            }
        }
        return res;
    }
}