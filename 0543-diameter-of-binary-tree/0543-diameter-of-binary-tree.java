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
    public int diameterOfBinaryTree(TreeNode root) {
        // we use array because if we use normal variable we will always get 0.
        int res[]=new int[1];
        depth(root,res);
        return res[0];
    }
    public int depth(TreeNode root, int [] res){
      if(root==null){
        return 0;
      }
      int lh = depth(root.left,res);
      int rh = depth(root.right, res);

      res[0]= Math.max(res[0], lh+rh);
      return (1+Math.max(lh,rh));
    }
}