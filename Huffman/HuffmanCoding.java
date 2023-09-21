import java.util.PriorityQueue;
import java.util.HashMap;

class HuffmanNode implements Comparable<HuffmanNode> {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.frequency - o.frequency;
    }
}

public class HuffmanCoding {
    public static HashMap<Character, String> encode(String text) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();
        for (char c : frequencyMap.keySet()) {
            minHeap.add(new HuffmanNode(c, frequencyMap.get(c)));
        }

        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();
            HuffmanNode merged = new HuffmanNode('\0', left.frequency + right.frequency);
            merged.left = left;
            merged.right = right;
            minHeap.add(merged);
        }

        HuffmanNode root = minHeap.peek();
        HashMap<Character, String> huffmanCodes = new HashMap<>();
        buildHuffmanCodes(root, "", huffmanCodes);

        return huffmanCodes;
    }

    private static void buildHuffmanCodes(HuffmanNode node, String code, HashMap<Character, String> huffmanCodes) {
        if (node == null) {
            return;
        }

        if (node.data != '\0') {
            huffmanCodes.put(node.data, code);
        }

        buildHuffmanCodes(node.left, code + "0", huffmanCodes);
        buildHuffmanCodes(node.right, code + "1", huffmanCodes);
    }

    public static String decode(HashMap<Character, String> huffmanCodes, String encodedText) {
        StringBuilder decodedText = new StringBuilder();
        int index = 0;

        while (index < encodedText.length()) {
            HuffmanNode current = minHeapDecode(encodedText, index, huffmanCodes);
            decodedText.append(current.data);
            index += current.frequency;
        }

        return decodedText.toString();
    }

    private static HuffmanNode minHeapDecode(String encodedText, int index, HashMap<Character, String> huffmanCodes) {
        HuffmanNode root = new HuffmanNode('\0', 0);
        HuffmanNode current = root;

        while (index < encodedText.length()) {
            char bit = encodedText.charAt(index);
            if (bit == '0') {
                if (current.left == null) {
                    current.left = new HuffmanNode('\0', 0);
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new HuffmanNode('\0', 0);
                }
                current = current.right;
            }

            if (huffmanCodes.containsKey(current.data)) {
                break;
            }

            index++;
        }

        return current;
    }

    public static void main(String[] args) {
        String text = "hello world";
        HashMap<Character, String> huffmanCodes = encode(text);

        System.out.println("Huffman Codes:");
        for (char c : huffmanCodes.keySet()) {
            System.out.println(c + ": " + huffmanCodes.get(c));
        }

        String encodedText = "";
        for (char c : text.toCharArray()) {
            encodedText += huffmanCodes.get(c);
        }
        System.out.println("Encoded Text: " + encodedText);

        String decodedText = decode(huffmanCodes, encodedText);
        System.out.println("Decoded Text: " + decodedText);
    }
}

