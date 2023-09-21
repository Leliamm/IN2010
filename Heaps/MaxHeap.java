import java.util.ArrayList;

public class MaxHeap {
      ArrayList<Integer> heap;

    public MaxHeap() {
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

        while (0 < index && i > heap.get(parentOf(index))) {
            int temp = i;
            heap.set(index, heap.get(parentOf(index)));
            heap.set(parentOf(index), temp);
            index = parentOf(index);
        }
    }

    public int removeMax() {

        if (heap.size() == 0) {
            return -1;
        }

        int removed = heap.get(0);
        int indexLast = heap.size() - 1;
        heap.set(0, heap.get(indexLast));
        heap.remove(indexLast);

        int indexMaxChild = 0;

        while (rigthOf(indexMaxChild) <= heap.size()-1
                && heap.get(indexMaxChild) < Math.max(heap.get(leftOf(indexMaxChild)), heap.get(rigthOf(indexMaxChild)))) {
            if (heap.get(leftOf(indexMaxChild)) >= heap.get(rigthOf(indexMaxChild))) {
                indexMaxChild = leftOf(indexMaxChild);
            } else {
                indexMaxChild = rigthOf(indexMaxChild);
            }

            int temp = heap.get(indexMaxChild);
            System.out.println("Storst barn " + temp);
            System.out.println("Parent to be swapt " + heap.get(parentOf(indexMaxChild)));
            System.out.println("Før sawp: " + heap);
            heap.set(indexMaxChild, heap.get(parentOf(indexMaxChild)));
            heap.set(parentOf(indexMaxChild), temp);
            System.out.println("Etter sawp: " + heap);

        }
        if(leftOf(indexMaxChild) <= heap.size()-1 && heap.get(leftOf(indexMaxChild)) > heap.get(indexMaxChild)){
            System.out.println("Før sawp: " + heap);
            int temp = heap.get(indexMaxChild);
            heap.set(indexMaxChild, heap.get(parentOf(indexMaxChild)));
            heap.set(parentOf(indexMaxChild), temp);
            System.out.println("Etter sawp: " + heap);
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
