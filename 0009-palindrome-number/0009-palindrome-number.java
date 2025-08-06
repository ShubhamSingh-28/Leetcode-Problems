class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int a =x;
        int res =0;
        while(a!=0){
            int c=a%10;
            res=res*10+c;
            a/=10;
        }
        return (res==x) ? true :false;
    }
}