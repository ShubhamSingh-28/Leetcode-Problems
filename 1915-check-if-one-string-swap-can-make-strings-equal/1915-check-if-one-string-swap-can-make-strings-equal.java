class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int c=0;
        if(s1.equals(s2)){
            return true;
        }
        //easy approach solve 123 test case
        // for(int i=0;i<s1.length();i++){
        //     if(s1.charAt(i)!=s2.charAt(i)){
        //         c++;
        //     }
        // }
        // return c==2;
        int a=0;
        int b=0;
        for(int i=0;i<s1.length();i++){
             if(s1.charAt(i)!=s2.charAt(i)){
                c++;
                if(c>2) return false;
                else{
                    if(c==1){
                        a=i;
                    } else{
                        b=i;
                    }
                }
            }
        }

        return (s1.charAt(a)==s2.charAt(b)) && (s1.charAt(b)==s2.charAt(a));
    }
}