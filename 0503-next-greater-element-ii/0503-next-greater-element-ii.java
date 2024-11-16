class Solution {
    public int[] nextGreaterElements(int[] nums) {
         int ans[]= new int[nums.length];
        Stack<Integer> s= new Stack<>();
        for(int i=nums.length*2-2;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=nums[i%nums.length]) s.pop();
            if(s.isEmpty()){
               ans[i%nums.length]=-1;
            } else{
                ans[i%nums.length]=s.peek();
            }
            s.push(nums[i%nums.length]);
        }
        
        return ans;
    }
}