class Solution {
    public String reverseWords(String s) {
        char arr []= s.toCharArray();
        int len = arr.length;
        int start = 0;
        for(int end = 0; end <=len; end++){
            // word will end at space or at end of string
            if(end == len || arr[end]==' '){
                reverse(arr, start, end-1);
                start = end+1;
            }
        }
        return new String(arr);
        
    }
    public void reverse(char arr[], int start, int end){
        while(start<end){
            char temp = arr[start];
            arr[start]= arr[end];
            arr[end]= temp;
            start++;
            end--;
        }
    }
}