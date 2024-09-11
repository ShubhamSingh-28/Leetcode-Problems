class Solution {
    public int longestConsecutive(int[] arr) {
         int maxlen=0;
        HashSet<Integer> set= new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int prev=arr[i]-1;
            if (!set.contains(prev)) {
                int len=1;
                int next=arr[i]+1;
                while (set.contains(next)) {
                    len++;
                    next++;
                } 
            maxlen= Math.max(len,maxlen);
            }
        }
        return maxlen;
    }
}