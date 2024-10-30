class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> map= new HashSet<>();
        while(n!=1 && !map.contains(n)){
            map.add(n);
            n=sq(n);
        }
        return n==1;
    }
    public int sq(int n){
        int s=0;
        while(n>0){
            int d=n%10;
            s+=d*d;
            n/=10;
        }
        return s;
    }
}