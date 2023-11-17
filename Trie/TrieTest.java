public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("canada");

        System.out.println("Contains can (false)");
        System.out.println(trie.contains("can"));
        System.out.println("Contains canada (true)");
        System.out.println(trie.contains("canada"));
        System.out.println("Contains cat (true)");
        System.out.println(trie.contains("cat"));
    }
}
