class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> set = new HashSet<>();
        int res=0;
        for(char c :s.toCharArray()){
            set.add(c);
        }
        for(char c: set){
            int st=s.indexOf(c);
            int end=s.lastIndexOf(c);
            if(st<end){
                Set<Character> charSet = new HashSet<>();
                for (int i = st + 1; i < end; i++) {
                    charSet.add(s.charAt(i));
                }
                res += charSet.size();
            }
        }
        return res;
    }
  
}