class Solution {
    public int findDuplicate(int[] nums) {
        cyclesort(nums);
        
        for(int i = 0; i <nums.length;i++){
            if(nums[i]!=i+1){
               return nums[i];
            }
        }
        return-1;
    }

    public void cyclesort (int arr[]){
        int n = arr.length;
        int index= 0;
        while(index<n){
            int element = arr[index];
            int actualpos = element-1;
            if(arr[index]<n && arr[index]!= arr[actualpos]){
                swap(arr, index, actualpos);
            } else {
                index++;
            }
        }
    }

    public void swap (int arr[], int i , int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }
}