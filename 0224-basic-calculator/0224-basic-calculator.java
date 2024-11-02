class Solution {
    public int calculate(String s) {
        int res=0;
        int num=0;
        int sign=1;
        Stack<Integer> st= new Stack<>();
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            } else if(ch=='+'){
                res=res+(sign*num);
                num=0;
                sign=1;
            } else if(ch=='-'){
                res=res+(sign*num);
                num=0;
                sign=-1;
            } else if(ch=='('){
                st.push(res);
                st.push(sign);
                res=0;
                num=0;
                sign=1;
            } else if(ch==')'){
                 res=res+(sign*num);
                num=0;
                int prevS=st.pop();
                int prev=st.pop();
                res=prev+prevS*res;
            }
        }
        res=res+sign*num;
        return res;
    }
}