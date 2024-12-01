class WordDictionary {
    class Node {
        Node children[] = new Node[26];
        boolean eaw = false; // end of a word flag

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public Node root = new Node();

    public WordDictionary() {}

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (cur.children[ind] == null) {
                cur.children[ind] = new Node();
            }
            cur = cur.children[ind];
        }
        cur.eaw = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, Node node) {
        if (index == word.length()) {
            return node.eaw; // Check if the current node marks the end of a word
        }

        char currentChar = word.charAt(index);

        if (currentChar == '.') {
            // If the character is '.', check all children nodes
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && searchHelper(word, index + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            int ind = currentChar - 'a';
            if (node.children[ind] == null) {
                return false;
            }
            return searchHelper(word, index + 1, node.children[ind]);
        }
    }
}
