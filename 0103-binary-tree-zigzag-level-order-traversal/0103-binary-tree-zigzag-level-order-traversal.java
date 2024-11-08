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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        if (root == null) {
         return res;
        }
        boolean rev= false;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size= q.size();
            List<Integer> c= new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode temp = q.poll();
                c.add(temp.val);
                    if(temp.left!=null){
                    q.offer(temp.left);
                    }
                    if(temp.right!=null){
                    q.offer(temp.right);
                    }
            }
            if(rev){
                Collections.reverse(c);
            }
            res.add(c);
            rev= !rev;
        }
        return res;
    }
}