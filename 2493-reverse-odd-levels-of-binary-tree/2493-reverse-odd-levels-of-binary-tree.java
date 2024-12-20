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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int s=q.size();
            List<TreeNode> l= new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode node=q.poll();
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                if(level%2!=0){
                    l.add(node);
                }
            }
            if(level%2!=0){
                int start=0;
                int end=l.size()-1;
                while(start<end){
                  int temp=l.get(start).val;
                  l.get(start).val=l.get(end).val;
                  l.get(end).val=temp;
                  start++;
                  end--;
                }
            }
            level++;
        }
        return root;
    }
}