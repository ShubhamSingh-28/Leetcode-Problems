class Solution {
    public int removeElement(int[] nums, int val) {
        int k = removeElements(nums, val);
        for (int i : nums) {
    System.out.print(i);
   }
   return k;
    }

     public static int removeElements(int arr[], int val){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[res] = arr[i];
                res ++;
            }
        }
        return res;
    }

}