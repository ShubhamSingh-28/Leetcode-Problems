class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch=='#'){
                if(!s1.isEmpty()){
                    s1.pop();
                }
                continue;
            } 
            s1.push(ch);
        }
        for(char ch : t.toCharArray()){
            if(ch=='#'){
                if(!s2.isEmpty()){
                    s2.pop();
                }
                continue;
            } 
            s2.push(ch);
            
        }
        String res = "";
        String ans = "";
        while(!s1.isEmpty()){
            res+=s1.pop();
        }
        while(!s2.isEmpty()){
            ans+=s2.pop();
        }

        System.out.println(res);
        System.out.println(ans);

        return res.equals(ans);
    }
}