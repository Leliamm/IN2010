import java.util.Arrays;

public class LiniarProbing {
    private Entry[] list;
    private int elements = 0;

    public LiniarProbing(int size) {
        list = new Entry[size];
    }

    private class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hashing(int key) {
        return key % list.length;
    }

    private boolean isFull() {
        return elements == size();
    }

    public boolean contains(int key) {
        return getEntry(key) != null;
    }

    private Entry getEntry(int key) {
        int index = hashing(key);
        int counting = 0;
        while (list[index] != null && counting <= size()) {
            if (list[index].key == key) {
                return list[index];
            }
            counting++;
            index++;
            if (index == list.length)
                index = 0;
        }
        return null;
    }

    private int getEntryIndex(int key){
         int index = hashing(key);
        int counting = 0;
        while (list[index] != null && counting <= size()) {
            if (list[index].key == key) {
                return index;
            }
            counting++;
            index++;
            if (index == list.length)
                index = 0;
        }
        return -1;
    }

    public void put(int key, String value) {
        if (isFull() && !contains(key)) {
            System.out.println("Array is full");
            return;
        }

        int index = hashing(key);
        while (list[index] != null) {
            if (list[index].key == key) {
                list[index] = new Entry(key, value);
                return;
            }
            index++;
            if (index == list.length)
                index = 0;
        }

        list[index] = new Entry(key, value);
        elements++;
    }

    public String get(int key) {
        if (getEntry(key) != null)
            return getEntry(key).value;
        return "not found";
    }

    public void remove(int key) {
        if (contains(key)) {
            int index = getEntryIndex(key);
            list[index] = null;
            elements--;
        }
    }

    public int size() {
        return list.length;
    }

     @Override
    public String toString() {
        return Arrays.toString(list);
    }
}
