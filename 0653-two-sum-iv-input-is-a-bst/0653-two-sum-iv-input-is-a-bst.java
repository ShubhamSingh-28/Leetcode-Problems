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
 /*
      1 approach with set
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set= new HashSet<>();
       // int target=k;
        int count[]=new int[1];
        dfs(root,set, k, count);
        if(count[0] >0){
            return true;
        } else{
        return false;
        }
    }
    public void dfs(TreeNode root, HashSet<Integer> set, int k, int[] count){
        if(root==null){
            return;
        }
        if(set.contains(root.val)){
                 count[0]++;
         }

        set.add(k-root.val);
        dfs(root.left, set,k,count);
        dfs(root.right, set,k,count);
    }
}
*/

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list= new ArrayList<>();
        dfs(root,list);
        int s=0;
        int e= list.size()-1;
        while(s<e){
            int sum= list.get(s)+list.get(e);
            if(sum==k){
                return true;
            }
            if(sum<k){
                s++;
            } else{
                e--;
            }
        }
        return false;
    }
    public void dfs(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}