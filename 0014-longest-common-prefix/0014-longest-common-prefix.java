class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Arrays.sort(strs);
        // int i=0;
        // String s1=strs[0];
        // String s2=strs[strs.length-1];
        // while(i<s1.length() && i<s2.length()){
        //     if(s1.charAt(i)==s2.charAt(i)){
        //         i++;
        //     } else{
        //         break;
        //     }
        // }
        // return s1.substring(0,i);

        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;

    }
}