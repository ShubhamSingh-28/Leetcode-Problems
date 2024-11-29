// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         int m = words.length*words[0].length();
//         int start=0;
//         int end=0;
//         List<Integer> list= new ArrayList<>();
//             StringBuilder str=new StringBuilder();
//         while(end<s.length()){
//             str.append(s.charAt(end));
//             if(str.length()==m){
//                 if(valid(str.toString(),words)){
//                     list.add(start);
//                 }
//                 str.delete(0,1);
//                 start+=1;
//             }
//             end++;
//         }
//         return list;
//     }

//     public boolean valid(String s,String[] words){
//         HashMap<String,Integer> map= new HashMap<>();
//         for(String x:words){
//             map.put(x,map.getOrDefault(x,0)+1);
//         }
//         int w = words[0].length();
//         for(int i=0;i<s.length();i+=w){
//             String sub= s.substring(i,i+w);
//             if(!map.containsKey(sub) || map.get(sub)<=0){
//                 return false;
//             }
//             map.put(sub,map.get(sub)-1);
//         }
//         return true;
//     }
    
// }

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        List<Integer> result = new ArrayList<>();

        // Create a map for word frequencies.
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Check each starting position in the string up to the length of one word.
        for (int i = 0; i < wordLen; i++) {
            int start = i;
            int end = i;
            HashMap<String, Integer> currentMap = new HashMap<>();

            while (end + wordLen <= s.length()) {
                // Extract the word at the current 'end' position.
                String word = s.substring(end, end + wordLen);
                end += wordLen;

                // Add the word to the current map or update its count.
                currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);

                // If there are more instances of the word than allowed, remove words from the start.
                while (currentMap.get(word) > wordCountMap.getOrDefault(word, 0)) {
                    String startWord = s.substring(start, start + wordLen);
                    currentMap.put(startWord, currentMap.get(startWord) - 1);
                    start += wordLen;
                }

                // Check if the current window matches the required length.
                if (end - start == totalLen) {
                    result.add(start);
                }
            }
        }

        return result;
    }
}
