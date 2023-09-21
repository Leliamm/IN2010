public class TestHeap {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        MaxHeap maxHeap = new MaxHeap();

        minHeap.insert(100);
        System.out.println(minHeap);
        minHeap.insert(44);
        System.out.println(minHeap);
        minHeap.insert(23);
        System.out.println(minHeap);
        minHeap.insert(22);
        System.out.println(minHeap);
        minHeap.insert(15);
        System.out.println(minHeap);
        minHeap.insert(17);
        System.out.println(minHeap);
        minHeap.insert(16);
        System.out.println(minHeap);
        minHeap.insert(10);
        System.out.println(minHeap);
        minHeap.insert(0);
        System.out.println(minHeap);

        minHeap.removeMin();
        System.out.println(minHeap);
        minHeap.removeMin();
        System.out.println(minHeap);
        minHeap.removeMin();
        System.out.println(minHeap);
        minHeap.removeMin();
        System.out.println(minHeap);


        //test maxHeap
        
        maxHeap.insert(22);
        System.out.println(maxHeap);
        maxHeap.insert(23);
        System.out.println(maxHeap);
        maxHeap.insert(44);
        System.out.println(maxHeap);
         maxHeap.insert(100);
        System.out.println(maxHeap);
        maxHeap.insert(15);
        System.out.println(maxHeap);
        maxHeap.insert(17);
        System.out.println(maxHeap);
        maxHeap.insert(16);
        System.out.println(maxHeap);
        maxHeap.insert(10);
        System.out.println(maxHeap);
        maxHeap.insert(0);
        System.out.println(maxHeap);
    
        maxHeap.removeMax();
        System.out.println(maxHeap);
        maxHeap.removeMax();
        System.out.println(maxHeap);
        maxHeap.removeMax();
        System.out.println(maxHeap);
        maxHeap.removeMax();
        System.out.println(maxHeap);

    }
}