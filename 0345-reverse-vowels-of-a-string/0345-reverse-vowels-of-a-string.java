class Solution {
    public String reverseVowels(String s) {
        char arr []= s.toCharArray();
        int start = 0, end = s.length()-1;
        String vowels = "aeiouAEIOU";
        while (start<end) {
          while (start < end && vowels.indexOf(arr[start])==-1) {
            start++;
          }

          while (start < end && vowels.indexOf(arr[end])==-1) {
            end--;
          }
          
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
    }
}