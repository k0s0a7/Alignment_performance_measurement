package sort;

public class HeapSort<E extends Comparable<E>>extends Sort<E> {

    private static final int HEAP_ROOT = 1;

    public HeapSort(boolean givenSortingOrder) {
        super(givenSortingOrder);
    }

    private E removeMax(E[] aList, int heapSize) {
        E removedElement = aList[HeapSort.HEAP_ROOT];
        aList[HeapSort.HEAP_ROOT] = aList[heapSize];
        this.adjust(aList, HeapSort.HEAP_ROOT, heapSize-1);
        return removedElement;
    }

    private void adjust(E[] aList, int root, int endOfHeap) {
        int parent = root;
        E rootElement = aList[root];
        while((parent*2) <= endOfHeap) {
            int biggerChild = parent*2;
            int rightChild = biggerChild+1;
            if((rightChild <= endOfHeap) &&
                    (this.compare(aList[biggerChild], aList[rightChild]) < 0)) {
                biggerChild = rightChild;
            }
            if(this.compare(rootElement, aList[biggerChild]) >=0 ) {
                break;
            }
            aList[parent] = aList[biggerChild];

            parent = biggerChild;
        }
        aList[parent] = rootElement;
    }

    private void makeInitHeap(E[] aList) {
        for(int rootOfSubtree = (aList.length-1)/2; rootOfSubtree >= 1; rootOfSubtree--) {
            this.adjust(aList, rootOfSubtree, aList.length-1);
        }
    }

    public boolean sort(E[] aList) {
        if(aList.length <= 1) {
            return false;
        }
        int minLoc = 0;
        for(int i = 1; i < aList.length; i++) {
            if(this.compare(aList[minLoc], aList[i]) > 0) {
                minLoc = i;
            }
        }
        this.swap(aList, minLoc, 0);

        this.makeInitHeap(aList);
        for(int heapSize = aList.length-1; heapSize > 1; heapSize--) {
            E maxElement = this.removeMax(aList, heapSize);
            aList[heapSize] = maxElement;
        }
        return true;
    }
}
