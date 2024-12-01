class Trie {
    class Node{
        Node children[]=new Node[26];
        boolean eaw=false;
        Node(){
            for(int i=0;i<children.length;i++){
                children[i]=null;
            }
        }
    }
    public Node root= new Node();
    public Trie() {
        
    }
    
    public void insert(String word) {
        Node cur= root;
        for(int i=0;i<word.length();i++){
            int ind= word.charAt(i)-'a';
            if(cur.children[ind]==null){
                cur.children[ind]=new Node();
            }
            cur=cur.children[ind];
        }
        cur.eaw=true;
    }
    
    public boolean search(String word) {
        Node cur= root;
        for(int i=0;i<word.length();i++){
            int ind= word.charAt(i)-'a';
            if(cur.children[ind]==null){
                return false;
            }
            cur=cur.children[ind];
        }
        return cur.eaw==true;
    }
    
    public boolean startsWith(String prefix) {
        Node cur= root;
        for(int i=0;i<prefix.length();i++){
            int ind= prefix.charAt(i)-'a';
            if(cur.children[ind]==null){
                return false;
            }
            cur=cur.children[ind];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */