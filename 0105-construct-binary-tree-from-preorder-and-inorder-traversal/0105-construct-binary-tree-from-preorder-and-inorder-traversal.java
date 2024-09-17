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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer>hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        int m =inorder.length-1;
        int n = preorder.length-1;
        TreeNode root= construct(preorder, inorder,hashMap, 0,n,0,m);
        return root;
    }

     public TreeNode construct(int preorder[], int inorder[], HashMap<Integer, Integer>hashMap,
      int preIndStart, int preIndEnd,int inIndStart, int inIndEnd) {

        if (preIndStart>preIndEnd || inIndStart> inIndEnd) {
            return null;
        }
        int rootVal = preorder[preIndStart];
        int rootIndex= hashMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftTreeSize= rootIndex-inIndStart;
        int rightTreeSize=inIndEnd-rootIndex;
        root.left= construct( preorder, inorder, hashMap, preIndStart+1, preIndStart+leftTreeSize,inIndStart, rootIndex-1);
        root.right= construct( preorder, inorder, hashMap, preIndStart+leftTreeSize+1, preIndStart+leftTreeSize+rightTreeSize,rootIndex+1, inIndEnd);
        return root;
     }
}