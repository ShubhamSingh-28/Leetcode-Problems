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
    public int maxDepth(TreeNode root) {
        //return depth(root);
        if (root == null) {
            return 0;  // Base case: an empty tree has a depth of 0
        }

         Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        int c=0;
        while (!queue.isEmpty()) {
                        int levelSize = queue.size();  // Get the number of nodes at the current level
            c++;  // Increment depth for each level processed
            
            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();  // Get the next node
                if (node.left != null) {
                    queue.offer(node.left);  // Add left child to the queue
                }
                if (node.right != null) {
                    queue.offer(node.right);  // Add right child to the queue
                }
            }
        }
        return c;
    }

    // public int depth(TreeNode root){
    //     if(root==null){
    //         return 0;
    //     }
    //     int lh= depth(root.left);
    //     int rh=depth(root.right);

    //     return (1+Math.max(lh,rh));
    // }
}