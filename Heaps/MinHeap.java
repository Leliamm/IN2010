import java.util.ArrayList;

public class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public int parentOf(int i) {
        return (i - 1) / 2;
    }

    public int leftOf(int i) {
        return 2 * i + 1;
    }

    public int rigthOf(int i) {
        return 2 * i + 2;
    }

    public void insert(int i) {
        heap.add(i);
        int index = heap.size() - 1;

        while (0 < index && i < heap.get(parentOf(index))) {
            int temp = i;
            heap.set(index, heap.get(parentOf(index)));
            heap.set(parentOf(index), temp);
            index = parentOf(index);
        }
    }

    public int removeMin() {

        if (heap.size() == 0) {
            return -1;
        }

        int removed = heap.get(0);
        int indexLast = heap.size() - 1;
        heap.set(0, heap.get(indexLast));
        heap.remove(indexLast);

        int indexMinChild = 0;

        while (rigthOf(indexMinChild) <= heap.size()-1
                && heap.get(indexMinChild) > Math.min(heap.get(leftOf(indexMinChild)), heap.get(rigthOf(indexMinChild)))) {
            if (heap.get(leftOf(indexMinChild)) <= heap.get(rigthOf(indexMinChild))) {
                indexMinChild = leftOf(indexMinChild);
            } else {
                indexMinChild = rigthOf(indexMinChild);
            }
            int temp = heap.get(indexMinChild);
            heap.set(indexMinChild, heap.get(parentOf(indexMinChild)));
            heap.set(parentOf(indexMinChild), temp);

        }
        if(leftOf(indexMinChild) <= heap.size()-1 && heap.get(leftOf(indexMinChild)) < heap.get(indexMinChild)){
            int temp = heap.get(indexMinChild);
            heap.set(indexMinChild, heap.get(parentOf(indexMinChild)));
            heap.set(parentOf(indexMinChild), temp);
        }
        return removed;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("[");

        for (int i = 0; i < heap.size(); i++) {
            output.append(heap.get(i));

            if (i < heap.size() - 1) {
                output.append(", ");
            }
        }

        output.append("]");

        return output.toString();
    }

}