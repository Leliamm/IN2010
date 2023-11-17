import java.util.HashMap;

public class Trie {
    Node root;

    public Trie() {
        root = new Node(' ');
    }

    private class Node {
        private char value;
        private HashMap<Character, Node> children;
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
            children = new HashMap<>();
            isEndOfWord = false;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void insertNode(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        @Override
        public String toString() {
            return "value = " + value;
        }
    }

    public void insert(String s) {
        char[] chars = s.toCharArray();
        insert(chars);
    }

    private void insert(char[] chars) {
        Node current = root;
        for (char ch : chars) {
            if (!current.hasChild(ch))
                current.insertNode(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if(word == null) return false;
        char[] chars = word.toCharArray();
        return contains(chars);
    }

    private boolean contains(char[] chars) {
        Node current = root;

        for (char ch : chars) {
            if (current.hasChild(ch))
                current = current.getChild(ch);
            else
                return false;
        }
        return current.isEndOfWord;
    }
}