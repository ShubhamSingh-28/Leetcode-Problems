class Solution {
    public void rotate(int[] nums, int k) {
         int n = nums.length;
          k%=n;
        revese(nums,0,n-1);
        revese(nums,0,k-1);
        revese(nums,k,n-1);
    }

     void revese(int arr[], int start, int end){
       while (start<end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
       }
    }

}