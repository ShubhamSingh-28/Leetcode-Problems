class Solution {
    public String makeFancyString(String s) {
        StringBuilder a= new StringBuilder();
        a.append(s.charAt(0));
        int c=1;
        for(int i=1; i<s.length();i++){
            char ch= s.charAt(i);
            if(ch==a.charAt(a.length()-1)){
                c++;
                if(c<3){
                    a.append(ch);
                }
            }  else{
                c=1;
                a.append(ch);
            }
        }
        return a.toString();
    }
}