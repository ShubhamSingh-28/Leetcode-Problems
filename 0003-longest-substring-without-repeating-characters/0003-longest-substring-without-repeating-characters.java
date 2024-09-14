class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int end=0;
        int maxlen=Integer.MIN_VALUE;
        HashMap<Character, Integer> map=new HashMap<>();
        int n= s.length();
        while(end<n){
            char ch= s.charAt(end);
            // shrinking phase
            if(map.containsKey(ch) && map.get(ch)>=start){
                start=map.get(ch)+1;
            }
            map.put(ch,end);
            maxlen=Math.max(maxlen,end-start+1);
            end++;
        }
        return (maxlen==Integer.MIN_VALUE)? 0:maxlen;
    }
}