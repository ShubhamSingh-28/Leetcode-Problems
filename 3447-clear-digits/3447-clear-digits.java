class Solution {
    public String clearDigits(String s) {
        StringBuilder sb= new StringBuilder();
        //Stack<Character> st= new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }else{
                sb.deleteCharAt(sb.length()-1);
            }
        }
        // while(!st.isEmpty()){
        //     sb.append(st.pop());
        // }
        // sb.reverse();
        return sb.toString();
    }
}