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
    public boolean s(TreeNode root, TreeNode subRoot){
        if(root==null){
            return false;
        }
        if(root.val==subRoot.val){
            if(issame(root,subRoot)){
                return true;
            }
        }
        return s(root.left,subRoot) || s(root.right,subRoot);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return s(root,subRoot);
    }
    public boolean issame(TreeNode root, TreeNode subRoot){
        if(root== null && subRoot == null){
            return true;
        }
        if(root== null || subRoot == null || root.val!=subRoot.val){
            return false;
        }
        return issame(root.left,subRoot.left) && issame(root.right,subRoot.right);
    }
}