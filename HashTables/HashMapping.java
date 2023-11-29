import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashMapping {
    char karakter;

    private HashMap<Character, Integer> stringToHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        var chars = s.toCharArray();
        for (char ch : chars) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                int repetitions = map.get(ch);
                map.put(ch, ++repetitions);
            }
        }

        return map;
    }

    private HashMap<Integer, Integer> arrayToHashmap(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int repetitions = 1;
        for (int i : array) {
            if (map.containsKey(i)) {
                repetitions = map.get(i) + 1;
            }
            map.put(i, repetitions);
        }
        return map;
    }

    public int mostRepetedInt(int[] array) {
        HashMap<Integer, Integer> map = arrayToHashmap(array);
        int mostRepeted = -1;
        int count = -1;
        for (int key : map.keySet()) {
            if (map.get(key) > count) {
                count = map.get(key);
                mostRepeted = key;
            }
        }
        return mostRepeted;
    }

    public char firstNonRepetingChar(String s) {
        HashMap<Character, Integer> map = stringToHashMap(s);
        var chars = s.toCharArray();
        for (char ch : chars) {
            if (map.get(ch) == 1)
                return ch;
        }
        return Character.MIN_VALUE;

    }

    public char firstRepetedChar(String s) {
        HashMap<Character, Integer> map = stringToHashMap(s);
        var chars = s.toCharArray();
        for (char ch : chars) {
            if (map.get(ch) >= 2)
                return ch;
        }
        return Character.MIN_VALUE;

    }

    public int hashFunction(int i, int length) {
        return i % length;
    }

    public int hashFunction(String key) {
        int hash = 0;
        for (char ch : key.toCharArray())
            hash += ch;
        return hash % 100;
    }

    public int countPairsWithDiff(int[] array, int diff) {

        Set<Integer> set = new HashSet<>();
        for (var number : array)
            set.add(number);

        var count = 0;
        for (var number : array) {
            if (set.contains(number + diff))
                count++;
            if (set.contains(number - diff))
                count++;
            set.remove(number);
        }
        // Time complexity of this method is O(n).
        return count;
    }

    public int[] twoSum(int[] array, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < array.length; index++) {
            int compelent = sum - array[index];
            if (map.containsKey(compelent))
                return new int[] { map.get(compelent), index };

            map.put(array[index], index);
        }
        return null;
    }
}