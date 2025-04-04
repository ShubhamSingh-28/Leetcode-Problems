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
    class Pair{
        TreeNode key;
        int val;
        Pair(TreeNode key,int val){
            this.key=key;
            this.val=val;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).key;
    }
    public Pair dfs(TreeNode root){
        if(root==null){
            return new Pair(null,0);
        }
        Pair l= dfs(root.left);
        Pair r= dfs(root.right);
        if(l.val>r.val){
            return new Pair(l.key,l.val+1);
        }
        if(l.val<r.val){
            return new Pair(r.key,r.val+1);
        }
        return new Pair(root,l.val+1);
    }
}