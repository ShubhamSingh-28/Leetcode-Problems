class Solution {
    public boolean checkIfExist(int[] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i==j) continue;
                if(isDouble(arr,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isDouble(int arr[], int i,int j){
        return arr[i]==arr[j]*2;
    }
}