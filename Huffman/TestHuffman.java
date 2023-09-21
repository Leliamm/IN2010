import java.util.HashMap;

public class TestHuffman {
    public static void main (String[] args){
        Huffman huffman = new Huffman();

        String huffmanCoded = Huffman.encode("Hei!");
        // HashMap<Character, String> codes = Huffman.buildCodes(huffmanCoded);

        System.out.println(huffmanCoded);

        //  String huffmanDecode = Huffman.decode(huffmanCoded, codes);
        //  System.out.println(huffmanDecode);

    }
}
