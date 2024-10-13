class Solution {
    public int lengthOfLastWord(String s) {
        String[] myArray = s.split(" ");
        int length= myArray[myArray.length-1].length();
        return length;
    }
}