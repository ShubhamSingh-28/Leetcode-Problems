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
    public TreeNode sortedArrayToBST(int[] nums) {
        int start=0;
        int end=nums.length-1;
        
        return merge(nums,start,end);
    }

    public TreeNode merge(int num[], int start, int end){
        if(start>end){
            return null;
        }
        int mid= start+(end-start)/2;
        TreeNode root= new TreeNode(num[mid]);
        root.left=merge(num,start,mid-1);
        root.right= merge(num,mid+1,end);
        return root;
    }
}