class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        double ans = 0.0;  //1,2,3,4
        int arr[] = new int[n+m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            arr[k++] = nums1[i];
        }
        for (int i = 0; i < m; i++) {
            arr[k++] = nums2[i];
        }
        Arrays.sort(arr);
        if (arr.length%2==1) {
            ans = arr[arr.length/2];
        } else{
            ans = (double)(arr[(arr.length)/2]+arr[(arr.length/2-1)])/2;
        }

        return ans;
    }
}