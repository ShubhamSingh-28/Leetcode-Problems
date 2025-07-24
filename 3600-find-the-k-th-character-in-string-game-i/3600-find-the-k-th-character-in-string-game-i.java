class Solution {
    public char kthCharacter(int k) {
        String word="a";
        while(word.length()<k){
            int len=word.length();
            for(int j=0;j<len;j++){
                char ch=(char)((word.charAt(j)-'a'+1)%26+'a');
                word+=ch;
            }
        }
        return word.charAt(k-1);
    }
}