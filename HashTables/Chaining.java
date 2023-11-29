import java.util.LinkedList;

public class Chaining {
    LinkedList<Entry>[] list;

    public Chaining() {
        list = new LinkedList[5];
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

    private Entry getEntry(int key) {
        LinkedList<Entry> bucket = getBucket(key);
        if (bucket != null) {
            for (Entry e : bucket) {
                if (e.key == key) {
                    return e;
                }
            }
        }
        return null;
    }

    private LinkedList<Entry> getBucket(int key) {
        return list[hashing(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        int index = hashing(key);
        LinkedList<Entry> bucket = list[index];
        if (bucket == null) {
            list[index] = new LinkedList<>();
            bucket = list[index];
        }
        return bucket;
    }

    public void put(int key, String value) {
        LinkedList<Entry> bucket = getOrCreateBucket(key);
        Entry entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }
        bucket.addLast(new Entry(key, value));
    }

    public String get(int key) {
        Entry entry = getEntry(key);
        return (entry != null) ? entry.value : "Cannot get: not in the list";
    }

    public void remove(int key) {
        Entry entry = getEntry(key);
        if (entry != null) {
            getBucket(key).remove(entry);
            return;
        }
        System.out.println("Cannot remove: Not in the list");
    }
}
