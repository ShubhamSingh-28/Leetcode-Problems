class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min=0;
        int max=0;
        int ans=0;
        for(int a:differences){
            ans+=a;
            min=Math.min(min,ans);
            max=Math.max(max,ans);
            if(max-min > upper-lower) return 0;
        }
        return (upper-lower)-(max-min)+1;
    }
}