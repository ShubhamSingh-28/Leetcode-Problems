// class Solution {
//     public int subsetXORSum(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         subset(nums,0,res,new ArrayList<>());
//         int ans=0;
//         for(List<Integer> ns:res){
//             int x=0;
//             for(int s:ns){
//                 x^=s;
//             }
//             ans+=x;
//         }
//         return ans;
//     }
//     public void subset(int nums[],int i,List<List<Integer>> res,List<Integer> cur){
//         res.add(new ArrayList<>(cur));
//         for(int ind=i;ind<nums.length;ind++){
//             cur.add(nums[ind]);
//             subset(nums,ind+1,res,cur);
//             cur.remove(cur.size()-1);
//         }

//     }
// }
class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // Generate all of the subsets
        generateSubsets(nums, 0, new ArrayList<>(), subsets);

        // Compute the XOR total for each subset and add to the result
        int result = 0;
        for (List<Integer> subset : subsets) {
            int subsetXORTotal = 0;
            for (int num : subset) {
                subsetXORTotal ^= num;
            }
            result += subsetXORTotal;
        }
        return result;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> subsets) {
        // Base case: index reached end of nums
        // Add the current subset to subsets
        if (index == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        // Generate subsets with nums[i]
        subset.add(nums[index]);
        generateSubsets(nums, index + 1, subset, subsets);
        subset.remove(subset.size() - 1);

        // Generate subsets without nums[i]
        generateSubsets(nums, index + 1, subset, subsets);
    }
}