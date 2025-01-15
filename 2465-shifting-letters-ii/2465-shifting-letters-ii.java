class Solution {
    public String shiftingLetters(String s, int[][] shifts) {

        // for(int a[]: shifts){
        //     int st=a[0];
        //     int end=a[1];
        //     int dir= a[2];
        //     if(dir==0){
        //         s=backwardShift(s,st,end);
        //     } else{
        //         s=forwardShift(s,st,end);
        //     }
        // }
        // return s;
        int n = s.length();
        int[] shift = new int[n + 1];

        for (int[] shiftOp : shifts) {
            int start = shiftOp[0], end = shiftOp[1], direction = shiftOp[2];
            shift[start] += (direction == 1 ? 1 : -1);
            if (end + 1 < n) shift[end + 1] -= (direction == 1 ? 1 : -1);
        }

        int currentShift = 0;
        for (int i = 0; i < n; ++i) {
            currentShift += shift[i];
            shift[i] = currentShift;
        }

        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < n; ++i) {
            int netShift = (shift[i] % 26 + 26) % 26;
            result.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + netShift) % 26));
        }

        return result.toString();
    }
    // private String backwardShift(String s, int start, int end) {
    //    char[] chars = s.toCharArray();
    //    for(int i=start;i<=end;i++){
    //         chars[i] = (char) ((chars[i] - 'a' - 1 + 26)% 26 + 'a');
    //    }
    //    return new String(chars);
    // }

    // private String forwardShift(String s, int start, int end) {
    //    char[] chars = s.toCharArray();
    //    for(int i=start;i<=end;i++){
    //         chars[i] = (char) ((chars[i] - 'a' + 1)% 26 + 'a');
    //    }
    //    return new String(chars);
    // }
}