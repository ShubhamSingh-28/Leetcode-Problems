class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int s=0;
        int e=numbers.length-1;
        while(s<e){
            int total=numbers[s]+numbers[e];
            if(total==target){
                return new int[]{s+1,e+1};
            }else if(total>target){
                e--;
            } else{
                s++;
            }
        }
        return new int[]{0,0};
    }
}