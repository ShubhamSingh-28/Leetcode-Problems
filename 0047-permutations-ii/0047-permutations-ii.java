class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //Arrays.sort(nums);
        solve(nums,0,res);
        return res;
    }
     public void solve(int[] nums, int ind, List<List<Integer>> res){
        int n = nums.length;
        //base case
        if(ind == n-1){
            List<Integer> sublist = new ArrayList<Integer>();
            for(int i : nums){
                sublist.add(i);
            }
            res.add(new ArrayList<>(sublist));
            return;
        }
        // task
        HashSet<Integer> hp = new HashSet<>();
        for (int i=ind; i<n; i++){
            if(hp.contains(nums[i])) continue;
            hp.add(nums[i]);
            swap(nums, i , ind);
            solve(nums,ind+1,res);
             swap(nums, i , ind);

             // for skipping duplicate arrays

             while (i < n - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
        }
    }

    public void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    } 
}