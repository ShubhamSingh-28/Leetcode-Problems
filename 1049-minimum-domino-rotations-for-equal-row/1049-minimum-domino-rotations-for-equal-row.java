class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int a[]=new int[7];
        int b[]=new int[7];
        int same[]=new int[7];
        for(int i=0;i<tops.length;i++){
            a[tops[i]]++;
            b[bottoms[i]]++;
            if(tops[i]==bottoms[i]) {
                same[tops[i]]++;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=6;i++){
            if(a[i]+b[i]-same[i]==tops.length){
                min=Math.min(min,Math.min(a[i],b[i])-same[i]);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}