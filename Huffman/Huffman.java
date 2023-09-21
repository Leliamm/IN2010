import java.util.PriorityQueue;
import java.util.HashMap;

public class Huffman {

    static PriorityQueue<Node> huffman;

    public Huffman() {
        huffman = new PriorityQueue<>();
    }

    static class Node implements Comparable<Node> {
        char car;
        int f;
        Node left;
        Node right;

        public Node(char car, int frequency, Node leftChild, Node rightChild) {
            this.car = car;
            f = frequency;
            left = leftChild;
            right = rightChild;
        }

        @Override
        public int compareTo(Node n) {
            return this.f - n.f;
        }

        @Override
        public String toString() {
            return "char: " + car + " frekvens: " + f;
        }
    }

    private static void buildCode(Node n, String code, HashMap<Character, String> maps) {
        if (n == null) {
            return;
        }
        if (n.car != '\0') {
            maps.put(n.car, code);
        }
        buildCode(n.left, code + "0", maps);
        buildCode(n.right, code + "1", maps);
    }

    public static HashMap<Character, String> buildCodes(String s) {
        int antallChar = 0;
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (charFrequency.containsKey(c)) {
                int updateFreq = charFrequency.get(c) + 1;
                charFrequency.put(c, updateFreq);
            } else {
                charFrequency.put(c, 1);
                antallChar++;
            }
        }
        // System.out.println("antall char " + antallChar);

        // Node[] frequencyArray = new Node[antallChar];
        // int anrrayIndex = 0;
        // for (char c : charFrequency.keySet()) {
        //     frequencyArray[anrrayIndex] = new Node(c, charFrequency.get(c), null, null);
        //     // System.out.println("char array: " + c + " " + charFrequency.get(c));
        //     // System.out.println(frequencyArray[anrrayIndex].toString());
        //     anrrayIndex++;
        // }

        // //selectionSort to sort the array based on frequencies
        // for (int i = 0; i < frequencyArray.length; i++) {
        //     int k = i;
        //     for (int j = i + 1; j < frequencyArray.length; j++) {
        //         // System.out.println("J er nå: " + j + " Noden er: " + frequencyArray[j].toString());
        //         if (frequencyArray[j].f < frequencyArray[k].f) {
        //             k = j;
        //         }
        //     }
        //     if (i != k) {
        //         Node temp = frequencyArray[i];
        //         frequencyArray[i] = frequencyArray[k];
        //         frequencyArray[k] = temp;
        //     }

        // }

        // leger alt i PrioritetsKø
        for (char c : charFrequency.keySet()) {
            huffman.add(new Node(c, charFrequency.get(c), null, null));
        }
        // huffman.add(new Node('A', 106, null, null));
        // huffman.add(new Node('B', 200, null, null));
        // huffman.add(new Node('C', 500, null, null));
        // huffman.add(new Node('D', 701, null, null));
        // huffman.add(new Node('E', 305, null, null));

        //lager tre
        while (huffman.size() > 1) {
            Node v1 = huffman.poll();
            Node v2 = huffman.poll();
            int newFrequency = v1.f + v2.f;
            huffman.add(new Node('\0', newFrequency, v1, v2));
        }

        //lager root til treet
        Node root = huffman.peek();
        HashMap<Character, String> huffmanCodes = new HashMap<>();
        buildCode(root, "", huffmanCodes);
        System.out.println("Codes: " + huffmanCodes);
        return huffmanCodes;
    }

    public static String encode(String s) {
        HashMap<Character, String> codes = buildCodes(s);
        String encodedText = "";
        for (char c : s.toCharArray()) {
            encodedText += codes.get(c);
        }

        decode(s, codes);
        return encodedText;
    }

    //til dekoding
    private static Node buildDecode(String s, int index, HashMap<Character, String> codes) {
        System.out.println("Jeg er i private static Node buildDecode. ");

        Node current = huffman.peek();
        
        while (index < s.length()) {
            char bit = s.charAt(index);
            System.out.println("char " + bit + " at index " + index);
            
            if (bit == '0') {
                if (current.left == null) {
                    return current;
                }
                current = current.left;

            } else {
                if (current.right == null) {
                    return current;
                }
                current = current.right;
            }
            if (codes.containsKey(current.car)) {
                break;
            }
            index++;
        }
        return current;

    }

    public static String decode(String s, HashMap<Character, String> codes) {
        StringBuilder decodedText = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            Node current = buildDecode(s, index, codes);
            decodedText.append(current.car);
            index++;
        }
        return decodedText.toString();
    }

}