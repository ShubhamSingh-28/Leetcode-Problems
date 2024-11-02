class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s= new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                s.push(tokens[i]);
            } else{
                int ans=0;
                int val1=Integer.parseInt(s.pop());
                int val2=Integer.parseInt(s.pop());
                if(tokens[i].equals("+")){
                    ans=val1+val2;
                } else if(tokens[i].equals("-")){
                    ans=val2-val1;
                } else if(tokens[i].equals("*")){
                    ans=val1*val2;
                } else if(tokens[i].equals("/")){
                    ans=val2/val1;
                }
                String temp= Integer.toString(ans);
                s.push(temp);
            }
        }

        return Integer.parseInt(s.peek());
    }
}