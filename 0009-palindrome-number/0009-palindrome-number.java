class Solution {
    public boolean isPalindrome(int x) {
        int copy = x;
        int res = 0;
        while(x>0){
            int a = x%10;
            res = res*10+a;
            x/=10;
        }

        if(res==copy){
            return true;
        } else {
            return false;
        }
    }
}