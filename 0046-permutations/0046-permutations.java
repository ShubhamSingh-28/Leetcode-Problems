class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        solve(nums,0,res);
        return res;
    }

    public void solve(int[] nums, int ind, List<List<Integer>> res){
        int n = nums.length;
        //base case
        if(ind == n){
            List<Integer> sublist = new ArrayList<Integer>();
            for(int i : nums){
                sublist.add(i);
            }
            res.add(new ArrayList<>(sublist));
            return;
        }
        // task
        for (int i=ind; i<n; i++){
            swap(nums, i , ind);
            solve(nums,ind+1,res);
             swap(nums, i , ind);
        }
    }

    public void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    } 
}