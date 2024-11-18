/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private  String MARkER ="M";
    private  int m=1;

     void dfs(TreeNode root, List<String> list){
        if(root==null){
            String s= Integer.toString(m);
            list.add(MARkER +s);
            m++;
            return;
        }
        list.add(String.valueOf(root.val));
        dfs(root.left,list);
        dfs(root.right,list);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list= new ArrayList<>();
        dfs(root,list);
        return String.join(",",list);
    }

     TreeNode dfsdeserialize(List<String> list){
        String val= list.remove(list.size()-1);
        if(val.charAt(0)==MARkER.charAt(0)){
            return null;
        }
        TreeNode root= new TreeNode(Integer.parseInt(val));
        root.left=dfsdeserialize(list);
        root.right=dfsdeserialize(list);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list= new ArrayList<>(Arrays.asList(data.split(",")));
        Collections.reverse(list);
       TreeNode root= dfsdeserialize(list);
       return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));