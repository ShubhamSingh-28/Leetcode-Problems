class Solution {
    public int minimumRecolors(String blocks, int k) {
        int start=0;
        int end=0;
        int min=Integer.MAX_VALUE;
        int white=0;

        while(end < blocks.length()){
            char ch = blocks.charAt(end);
            if(ch=='W') white++;
            if(end-start+1 > k){
                char temp = blocks.charAt(start);
                if(temp=='W') white--;
                start++;
            }
            if(end-start+1 == k){
                min= Math.min(min,white);
            }
            
            end++;
        }
        return min;
    }
}