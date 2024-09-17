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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         HashMap<Integer, Integer>hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        int m =inorder.length-1;
        int n = postorder.length-1;
        TreeNode root= construct(postorder, inorder,hashMap, 0,n,0,m);
        return root;
    }
    public TreeNode construct(int postorder[], int inorder[], HashMap<Integer, Integer>hashMap,
      int postIndStart, int postIndEnd,int inIndStart, int inIndEnd) {

        if (postIndStart>postIndEnd || inIndStart> inIndEnd) {
            return null;
        }
        int rootVal = postorder[postIndEnd];
        int rootIndex= hashMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftTreeSize= rootIndex-inIndStart;
        int rightTreeSize=inIndEnd-rootIndex;
        root.left= construct( postorder, inorder, hashMap, postIndStart, postIndStart+leftTreeSize-1,inIndStart, rootIndex-1);
        root.right= construct( postorder, inorder, hashMap, postIndStart+leftTreeSize, postIndStart+leftTreeSize+rightTreeSize-1,rootIndex+1, inIndEnd);
        return root;
     }
}