class Solution {
    public String decodeString(String s) {
        Stack<Pair<String,Integer>> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for(char ch :s.toCharArray()){
            if(Character.isDigit(ch)){
               n=n*10+(ch-'0');
            }else if(ch=='['){
                st.push(new Pair<>(sb.toString(),n));
                sb.setLength(0);
                n=0;
            }else if(ch==']'){
                Pair<String,Integer> ls = st.pop();
                StringBuilder temp = new StringBuilder(ls.getKey());
                for(int i=0;i<ls.getValue();i++){
                    temp.append(sb);
                }
                sb=temp;
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
        // Stack<StringBuilder> st1 = new Stack<>();
        // StringBuilder sb = new StringBuilder();
        // int n = 0;
        // for(char ch :s.toCharArray()){
        //     if(Character.isDigit(ch)){
        //         n=n*10+(ch-'0');
        //     }else if(ch=='['){
        //         st.push(n);
        //         n=0;
        //         st1.push(sb);
        //         sb = new StringBuilder();
        //     }else if(ch==']'){
        //         int k=st.pop();
        //         StringBuilder temp = sb;
        //         sb=st1.pop();
        //         while(k-- >0){
        //             sb.append(temp);
        //         }
        //     } else{
        //         sb.append(ch);
        //     }
        // }
        // return sb.toString();
    }
}