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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l= new ArrayList<>();
        if(root==null) return l;
        searchBst(l,root,"");
        return l;
    }
    public void searchBst(List<String> l, TreeNode root,String s){
        if(root.left==null && root.right==null){
            l.add(s+root.val);
        }
        if(root.left!=null) searchBst(l,root.left,s+root.val+"->");
        if(root.right!=null) searchBst(l,root.right,s+root.val+"->");

    }
}