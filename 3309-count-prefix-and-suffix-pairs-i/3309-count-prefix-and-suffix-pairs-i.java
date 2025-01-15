class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int c=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPrefixAndSuffix(words[i],words[j])) c++;
            }
        }
        return c;
    }
    public boolean isPrefixAndSuffix(String a, String b){
        if(b.startsWith(a) && b.endsWith(a)){
            return true;
        } else{
            return false;
        }
    }
}