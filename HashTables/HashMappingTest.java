public class HashMappingTest {

    public static void main(String[] args) {
        HashMapping myTable = new HashMapping();
        char ch = myTable.firstNonRepetingChar("hello hun!");
        System.out.println("First non-repeting character: " + ch);
        System.out.println("First repeting character: " + myTable.firstRepetedChar("Hello hunee!"));

        //Hashcodes
        String s = "orange";
        System.out.println(s.hashCode());
        System.out.println(myTable.hashFunction(s));
        //Should print 1
        System.out.println(myTable.hashFunction(11, 10));

        //most repeted int in a array
        int[] array = { 1, 2, 3, 2, 1, 12, 4, 3, 21, 2, 1, 2, 2, 2 };
        System.out.println("Most repeated int is 2: " + myTable.mostRepetedInt(array));
        int[] array2 = { 1, 3, 1, 1, 12, 4, 3, 21, 2, 1, 2, 2 };
        System.out.println("Most repeated int is 1: " + myTable.mostRepetedInt(array2));

        //countPairsWithDiff 
        int[] diff = { 1, 7, 5, 9, 2, 12, 3 };
        System.out.println("Counting pairs 4: " + myTable.countPairsWithDiff(diff, 2));

        //twoSum
        int[] arraySum = { 2, 7, 11, 15 };
        int[] svar = myTable.twoSum(arraySum, 9);
        System.out.println("Counting pairs 4: " + svar.toString());

        // Chaining
        Chaining list = new Chaining();
        list.put(22, "hello");
        System.out.println(list.get(22));
        System.out.println(list.get(21));
        list.put(2, "meew");
        list.put(33, "hei!");
        var entry = list.get(33);
        System.out.println(entry);
        //removing
        System.out.println("Removing");
        list.remove(22);
        System.out.println(list.get(22));
        list.remove(22);
        //Liniar probing
        System.out.println("***Liniar Probing");
        System.out.println("Put");
        LiniarProbing liniarProbing = new LiniarProbing(5);
        liniarProbing.put(6, "bhu");
        liniarProbing.put(7, "bhu");
        liniarProbing.put(8, "bau");
        liniarProbing.put(9, "bau");
        liniarProbing.put(10, "bau");
        liniarProbing.put(11, "bau");
        liniarProbing.put(6, "bau");

        System.out.println("get");
        System.out.println("Get bau: " + liniarProbing.get(6));
        System.out.println("Get hbu: " + liniarProbing.get(7));
        System.out.println("Get null: " + liniarProbing.get(63));

        System.out.println("remove");
        System.out.println("contains true: " + liniarProbing.contains(6));
        liniarProbing.remove(6);
        liniarProbing.remove(6);
        System.out.println("contains false: " + liniarProbing.contains(6));

    }
}
