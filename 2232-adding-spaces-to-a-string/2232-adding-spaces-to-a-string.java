class Solution {
    public String addSpaces(String s, int[] spaces) {
        int i=0;
        StringBuilder st= new StringBuilder();
        for(int j=0;j<s.length();j++){
            if(i < spaces.length && j==spaces[i]){
                st.append(" ");
                i++;
            }
            st.append(s.charAt(j));
        }
        return st.toString();
    }
}