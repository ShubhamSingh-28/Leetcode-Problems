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
    public int minDepth(TreeNode root) {
        return depth(root);
    }

    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh= depth(root.left);
        int rh=depth(root.right);

        return (lh==0 || rh==0)?1+lh+rh: (1+Math.min(lh,rh));
    }
}