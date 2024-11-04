class Solution {
    public String compressedString(String word) {
       
        // HashMap<Character,Integer> map= new HashMap<>();
        // for(char s: word.toCharArray()){
        //     map.put(s,map.getOrDefault(s,0)+1);
        // }

        StringBuilder st= new StringBuilder();
        int count=1;
        char ch= word.charAt(0);
        for(int i=1;i<word.length();i++){
            char ch2= word.charAt(i);
            if(ch==ch2 && count<9){
                count++;
            }else{
                st.append(count);
                st.append(ch);
                ch=word.charAt(i);
                count=1;
            }
        }
        st.append(count);
        st.append(ch);

        // for(int i=0;i<word.length();i++){
        //     char ch= word.charAt(i);
        //     if(map.containsKey(ch)){
        //         int count= map.get(ch);
        //         if(count>9){
        //             st.append('9');
        //             st.append(ch);
        //             map.put(ch,count%9);
        //         } else{
        //             st.append(count);
        //             st.append(ch);
        //             map.put(ch,0);
        //             if(map.get(ch)==0){
        //                 map.remove(ch);
        //             }
        //         }

        //     }
        // }

        return st.toString();
    }
}