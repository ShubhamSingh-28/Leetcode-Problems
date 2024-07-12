class Solution {
    public int kthSmallest(int[][] arr, int k) {
        int R= arr.length;
        int C = arr[0].length;
         int n = R*C;
        int median = k-1;
        int start = arr[0][0];
        int end = arr[R-1][C-1];
        while (start<=end) {
            int mid= start+(end-start)/2;
            int leaser = smallernum(arr,mid);
            if (leaser<=median) {
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        return start;
    }

    int smallernum (int arr[][], int median){
        int Rows = 0;
        for (int i = 0; i < arr.length; i++) {
            int start= 0;
            int end = arr[i].length-1;
            while (start<=end) {
                int mid = start+(end-start)/2;
                if (arr[i][mid]<= median) {
                    start=mid+1;
                } else  {
                    end = mid-1;
                }
            }
            Rows = Rows+start;
        }

        return Rows;
    }


}