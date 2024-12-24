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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int swap=0;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node= q.poll();
                level.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            swap+=countswap(level);
        }
        return swap;
    }
    public int countswap(List<Integer> val){
        List<Integer> sorted=new ArrayList<>(val);
        Collections.sort(sorted);
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<val.size();i++){
            map.put(val.get(i),i);
        }
        int s=0;
        for(int i=0;i<val.size();i++){
            if(!val.get(i).equals(sorted.get(i))){
                s++;
                int pos= map.get(sorted.get(i));
                map.put(val.get(i), pos);
               Collections.swap(val, i, pos);
            }
        }
        return s;        
    }

}