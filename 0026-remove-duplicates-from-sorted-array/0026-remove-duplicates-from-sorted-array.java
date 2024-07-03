class Solution {
    public int removeDuplicates(int[] arr) {
         int ans = 0;
       for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] != arr[i+1]) {
                        arr[ans++] = arr[i];
                    }
                }
                arr[ans++] = arr[arr.length-1];
        return ans;
    }
}