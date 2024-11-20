class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map= new HashMap<>();

        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count = map.size();
        int startindex=-1;
        int start=0;
        int end=0;
        int min=Integer.MAX_VALUE;

        while(end<s.length()){
            char ch = s.charAt(end);
            // expand phase
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                  count--;
                }
            }
            // shrinking phase
            while(count==0){
                int len= end-start+1;
                if(len<min){
                  min= len;
                  startindex= start;
                }
               ch = s.charAt(start);
               if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
                  if(map.get(ch)>0){
                   count++;
                  }
                }
                start++;
            }
            end++;
        }

        // 1st approach
        // if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
        //         s.length() < t.length()) {
        //     return new String();
        // }
        // int start=0,startIndex = 0;
        // int e=0;
        // int n=t.length();
        // char [] ch= s.toCharArray();
        // int m= ch.length;
        // int map[]= new int[128];
        // for(char c : t.toCharArray() ){
        //     map[c]++;
        // }
        // int min=Integer.MAX_VALUE;
        // while(e<m){
        //     if(map[ch[e++]]-- > 0){
        //         n--;
        //     }
        //     while(n==0){
        //         if(e-start < min){
        //             startIndex = start;
        //             min=e-start;
        //         }
        //         if(map[ch[start++]]++ ==0){
        //             n++;
        //         }
        //     }
        // }
        return  startindex==-1 ? new String() :  s.substring(startindex,startindex+min);
    }
}