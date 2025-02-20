class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder res = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            char ch = (nums[i].charAt(i)=='0'?'1':'0');
            res.append(ch);
        }
        return res.toString();
    }
}