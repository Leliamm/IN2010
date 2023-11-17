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

        System.out.println("Test pre-order traversel ");
        trie.traversePre();
        System.out.println("Test post-order traversel ");
        trie.traversePost();

        System.out.println("Test remove can");
        trie.remove("can");
        System.out.println("Contains can? " + trie.contains("can"));
        System.out.println("Contains canada? " + trie.contains("canada"));

        System.out.println("Add back can and remove canada");
        trie.insert("can");
        trie.remove("canada");
        System.out.println("Contains canada? " + trie.contains("canada"));
        System.out.println("Contains can? " + trie.contains("can"));

        System.out.println("Test remove null");
        trie.remove(null);
        System.out.println("Test remove empty string");
        trie.remove("");

        System.out.println("Test autocomplet can");
        trie.insert("canada");
        trie.insert("candid");
        trie.insert("candice");
        System.out.println(trie.autocompletion("can"));

        System.out.println("Test autocomplet candi");
        System.out.println(trie.autocompletion("candi"));

         System.out.println("Test autocomplet empty string");
        System.out.println(trie.autocompletion(""));
          System.out.println("Test autocomplet null");
        System.out.println(trie.autocompletion(null));

    }
}
