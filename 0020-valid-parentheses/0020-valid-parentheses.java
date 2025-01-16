class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        Stack<Character> st= new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                st.push(ch);
            } else{
                if(st.isEmpty()){
                    st.push(ch);
                } 
                 char t= st.peek();
                if(t=='(' && ch==')'){ 
                    st.pop();
                } else if(t=='[' && ch==']'){ 
                    st.pop();
                } else if(t=='{' && ch=='}'){ 
                    st.pop();
                } else{
                    return false;
                }
            }
        }
        return st.size()==0;
    }
}