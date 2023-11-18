import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    Node root;

    public Trie() {
        root = new Node(' ');
    }

    public Trie(String word) {
        root = new Node(' ');
        insert(word);
    }

    public Trie(ArrayList<String> words) {
        root = new Node(' ');
        for (String word : words) {
            insert(word);
        }
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

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void insertNode(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public void removeChild(char ch) {
            children.remove(ch);
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
        if (word == null)
            return false;
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

    public boolean containsRecursive(String word) {
        if (word == null)
            return false;
        return containsRecursive(word, root, 0);
    }

    private boolean containsRecursive(String word, Node root, int index) {

        if (index == word.length())
            return root.isEndOfWord;
        if (root == null)
            return false;

        char ch = word.charAt(index);
        root = root.getChild(ch);
        return containsRecursive(word, root, index + 1);
    }

    //Pre order traversal
    public void traversePre() {
        traversePre(root);
    }

    private void traversePre(Node root) {
        System.out.println(root.value);
        //visit children
        for (Node n : root.getChildren()) {
            traversePre(n);
        }
    }

    //post order traversal
    public void traversePost() {
        traversePost(root);
    }

    private void traversePost(Node root) {
        for (Node n : root.getChildren()) {
            traversePost(n);
        }
        System.out.println(root.value);

    }

    public int countWords() {
        return countWords(root);
    }

    private int countWords(Node root) {
        int totalWords = 0;
        if (root.isEndOfWord)
            totalWords++;

        for (Node n : root.getChildren()) {
            totalWords += countWords(n);
        }
        return totalWords;
    }

    public void remove(String word) {
        if (!contains(word))
            return;
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }
        char ch = word.charAt(index);
        Node current = root.getChild(ch);
        if (current == null)
            return;

        remove(current, word, index + 1);
        if (!current.hasChildren() && !current.isEndOfWord) {
            root.removeChild(ch);
        }
    }

    //*********AUTOCOMPLETE METHODS**********
    private Node findLastNodeOF(String prefix) {
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            Node child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }

    public ArrayList<String> findWords(String prefix) {
        if (prefix == null)
            return null;
        ArrayList<String> words = new ArrayList<>();
        Node lastNode = findLastNodeOF(prefix);
        findwords(lastNode, prefix, words);
        return words;

    }

    private void findwords(Node root, String prefix, List<String> words) {
        if (root == null)
            return;
        if (root.isEndOfWord)
            words.add(prefix);

        for (Node child : root.getChildren()) {
            findwords(child, prefix + child.value, words);
        }
    }

    public ArrayList<String> trieToList() {
        return findWords("");
    }

    //finds first shortest word aphabetically.
    public String getShortest() {
        return getShortest(trieToList());
    }

    private static String getShortest(ArrayList<String> words) {
        if (words == null || words.size() == 0)
            return "";
        String shortestWord = words.get(0);
        for (String word : words) {
            if (shortestWord.length() > word.length()) {
                shortestWord = word;
            }
        }
        return shortestWord;

    }

    public static String longestCommonPrefix(ArrayList<String> listOfWords) {
        if (listOfWords == null)
            return "";
        Trie trie = new Trie(listOfWords);
        Node root = trie.root;
        return longestCommonPrefix(root, listOfWords);
    }

    private static String longestCommonPrefix(Node root, ArrayList<String> listOfWords) {
        String commonPrefix = "";
        int maxLength = getShortest(listOfWords).length();
        while (commonPrefix.length() < maxLength) {
            Node[] children = root.getChildren();
            if (children.length != 1)
                break;
            root = children[0];
            commonPrefix += root.value;
        }
        return commonPrefix;
    }

    public String longestCommonPrefix() {
        return longestCommonPrefix(root);
    }

    private String longestCommonPrefix(Node root) {
        String commonPrefix = "";
        int maxLength = getShortest().length();
        Node current = root;

        while (commonPrefix.length() < maxLength) {
            Node[] children = current.getChildren();
            if (children.length != 1)
                break;
            current = children[0];
            commonPrefix += current.value;
        }
        return commonPrefix;
    }
}