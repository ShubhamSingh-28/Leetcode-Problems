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
    public int maxPathSum(TreeNode root) {

        int sum[]=new int[1];
        sum[0]= Integer.MIN_VALUE;
        helper(root,sum);
        return sum[0] ;
    }
    int helper(TreeNode root, int[] sum){
        if(root== null){
            return 0;
        }
        
        int lf=Math.max(0,helper(root.left,sum));
        int rf= Math.max(0,helper(root.right,sum));
        sum[0]=Math.max(sum[0],lf+rf+root.val);
        return root.val + Math.max(lf,rf);

    }
}