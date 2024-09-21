/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set= new HashSet<>();
        int target=k;
        int count[]=new int[1];
        dfs(root,set, target, count);
        if(count[0] >0){
            return true;
        } else{
        return false;
        }
    }
    public void dfs(TreeNode root, HashSet<Integer> set, int k, int[] count){
        if(root==null){
            return;
        }
        if(set.contains(root.val)){
                 count[0]++;
         }

        set.add(k-root.val);
        dfs(root.left, set,k,count);
        dfs(root.right, set,k,count);
    }
}