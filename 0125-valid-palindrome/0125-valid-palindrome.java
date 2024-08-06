class Solution {
    public boolean isPalindrome(String s) {
        String newString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = newString.length()-1;
        while (start<=end) {
            if (newString.charAt(start) != newString.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}