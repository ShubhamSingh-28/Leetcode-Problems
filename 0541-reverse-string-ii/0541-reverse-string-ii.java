class Solution {
    public String reverseStr(String s, int k) {
        char arr[]= s.toCharArray();
        int n = arr.length;
        for(int i=0; i<n-1; i+=2*k){
            int b=Math.min(i+k-1, s.length()-1);
               reverse(arr, i, b);

        }
        return new String(arr);
    }

    public void reverse(char[] arr, int start, int end){
        while(start<end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end]= temp;
            start++;
            end--;
        }
    }

}