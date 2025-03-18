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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res= new ArrayList<>();
        back( root,targetSum,res,new ArrayList<>());
        return res;
    }
    public void back(TreeNode root, int targetSum,List<List<Integer>> res,List<Integer> cur){
        if(root==null){
            return;
        }
        cur.add(root.val);
        if(root.left==null && root.right==null && root.val==targetSum){
            res.add(new ArrayList<>(cur));
        }else{
          back( root.left,targetSum-root.val,res,cur);
          back( root.right,targetSum-root.val,res,cur);
        }
        cur.remove(cur.size()-1);
    }
}