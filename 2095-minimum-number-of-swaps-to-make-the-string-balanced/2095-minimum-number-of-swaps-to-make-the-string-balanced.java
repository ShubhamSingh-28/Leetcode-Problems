class Solution {
    public int minSwaps(String s) {
         Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='['){
                stack.push(ch);
            } else{
                if (stack.isEmpty() || stack.peek() != '[') {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
        }
        int totalBrackets = stack.size();
        int closed = totalBrackets/2;
        return ((closed+1)/2);
    }
}