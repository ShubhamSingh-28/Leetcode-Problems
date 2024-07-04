class Solution {
    public int[] twoSum(int[] arr, int target) {
         int newArr[] = new int[2];
       
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if ((arr[i]+arr[j]) == target) {
                    newArr[0]= i;
                    newArr[1]= j;
                }
            }
        }
        return newArr;
    }

    
}