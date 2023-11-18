import java.util.ArrayList;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("canada");
        //Test Contains iterative
        System.out.println("Contains can (false)");
        System.out.println(trie.contains("can"));
        System.out.println("Contains canada (true)");
        System.out.println(trie.contains("canada"));
        System.out.println("Contains cat (true)");
        System.out.println(trie.contains("cat"));
        System.out.println("Contains empty string (true)");
        System.out.println(trie.contains(" "));
        System.out.println("Contains null (false)");
        System.out.println(trie.contains(null));
        //Test Contains recursive
        System.out.println("Test Recursive \nContains can (false)");
        System.out.println(trie.containsRecursive("can"));
        System.out.println("Contains canada (true)");
        System.out.println(trie.containsRecursive("canada"));
        System.out.println("Contains cat (true)");
        System.out.println(trie.containsRecursive("cat"));
        System.out.println("Contains empty string (false)");
        System.out.println(trie.containsRecursive(""));
        System.out.println("Contains null (false)");
        System.out.println(trie.containsRecursive(null));

        //traversal tests
        System.out.println("Test pre-order traversel ");
        trie.traversePre();
        System.out.println("Test post-order traversel ");
        trie.traversePost();

        //tests remove/add/contains of words
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
        //Tests number of words
        System.out.println("Test number words");
        System.out.println(trie.countWords());
        System.out.println("Test number words after adding a random word");
        trie.insert("egg");
        System.out.println(trie.countWords());
        System.out.println("Test number words after removing an existing  word");
        trie.remove("egg");
        System.out.println(trie.countWords());
        System.out.println("Test number words after removing a non-existing  word");
        trie.remove("egg");
        System.out.println(trie.countWords());

        //Tests autocomplete list of words
        System.out.println("Test autocomplet can");
        trie.insert("canada");
        trie.insert("candid");
        trie.insert("candice");
        System.out.println(trie.findWords("can"));

        System.out.println("Test autocomplet candi");
        System.out.println(trie.findWords("candi"));

        System.out.println("Test autocomplet empty string");
        System.out.println(trie.findWords(""));
        System.out.println("Test autocomplet null");
        System.out.println(trie.findWords(null));

        //Trie to list
        System.out.println("Test trie to list");
        System.out.println(trie.findWords(""));
        System.out.println("Test trie to list after adding egg");
        trie.insert("egg");
        System.out.println(trie.findWords(""));

        //List to trie
        System.out.println("Test list to trie");
        ArrayList<String> words = new ArrayList<>();
        words.add("egg");
        words.add("bacon");
        words.add("flour");
        words.add("flours");
        words.add("flourish");
        Trie listToTrie = new Trie(words);
        System.out.println(listToTrie.findWords(""));

        //Shortest word
        System.out.println(listToTrie.getShortest());
        System.out.println("Shortest after removing egg");
        listToTrie.remove("egg");
        System.out.println(listToTrie.getShortest());
        System.out.println("Shortest after removing bacon");
        listToTrie.remove("bacon");
        System.out.println(listToTrie.getShortest());
        System.out.println("Shortest after addding floor and aaaa");
        listToTrie.insert("floor");
        listToTrie.insert("aaaa");
        System.out.println(listToTrie.getShortest());
        listToTrie.remove("aaaa");

        //Longest common prefix on trie
        System.out.println("Longest commom prefix for the trie");
        System.out.println(listToTrie.trieToList());
        System.out.println(listToTrie.longestCommonPrefix());

        //Longest common prefix on arrays
        System.out.println("Longest commom prefix for the list of words \nInput: “card”, “care” Output: “car”");
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("car");
        wordList.add("care");
        System.out.println("Wordlist: " + wordList);
        System.out.println(Trie.longestCommonPrefix(wordList));

        System.out.println("Longest commom prefix for the list of words \nInput: “car”, “dog” Output: “”");
        ArrayList<String> wordList1 = new ArrayList<>();
        wordList1.add("car");
        wordList1.add("dog");
        System.out.println("Wordlist: " + wordList1);
        System.out.println(Trie.longestCommonPrefix(wordList1));
        System.out.println("Longest commom prefix for the list of words \nInput: “car” Output: “car” ");
        ArrayList<String> wordList2 = new ArrayList<>();
        wordList2.add("car");
        System.out.println("Wordlist: " + wordList2);
        System.out.println(Trie.longestCommonPrefix(wordList2));

    }
}
