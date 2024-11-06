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
    public int sumNumbers(TreeNode root) {
        int sum[]={0};
        healper(root, 0,sum);
        return sum[0];
    }
    public void healper(TreeNode root, int cur, int sum[]){
        if (root==null) return ;

        cur= cur*10+root.val;
        if(root.left==null && root.right==null){
            sum[0]+=cur;
            return;
        }
        healper(root.left,cur,sum);
        healper(root.right,cur,sum);
    }
}