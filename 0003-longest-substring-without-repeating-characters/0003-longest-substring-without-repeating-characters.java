class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int st=0;int e=0;
        int max=Integer.MIN_VALUE;
        while(e<s.length()){
            char ch= s.charAt(e);
            if(map.containsKey(ch) && map.get(ch)>=st){
                st=map.get(ch)+1;
            }
            max= Math.max(max,e-st+1);
            map.put(ch,e);
            e++;
        }
        return (max==Integer.MIN_VALUE)? 0:max;

    }
}