package sort;

public class QuickSort<E extends Comparable<E>> extends Sort<E> {

    public QuickSort(boolean givenSortingOrder) {
        super(givenSortingOrder);
    }

    protected int pivot(E[] aList, int left, int right) {
        return left;
    }

    protected int partition(E[] aList, int left, int right) {
        int pivot = this.pivot(aList, left, right);
        this.swap(aList, left, pivot);
        E pivotElement = aList[left];
        int toRight = left;
        int toLeft = right+1;
        do {
            do { toRight++; } while(this.compare(aList[toRight], pivotElement) < 0);
            do { toLeft--; } while(this.compare(aList[toLeft], pivotElement) > 0);
            if(toRight < toLeft) {
                this.swap(aList, toRight, toLeft);
            }
        }while(toRight < toLeft);
        this.swap(aList, left, toLeft);
        return toLeft;
    }

    protected void quickSortRecursively(E[] aList, int left, int right) {
        if(left < right){
            int mid = partition(aList, left, right);
            quickSortRecursively(aList, left, mid-1);
            quickSortRecursively(aList, mid+1, right);
        }
    }

    public boolean sort(E[] aList) {
        if(aList.length < 1) {
            return false;
        }
        if(aList.length > 1) {
            int maxLoc = 0;
            for(int i = 1 ; i < aList.length; i++) {
                if(this.compare(aList[maxLoc], aList[i]) < 0) {
                    maxLoc = i;
                }
            }
            this.swap(aList, maxLoc, aList.length-1);
            this.quickSortRecursively(aList, 0, aList.length-2);
        }
        return true;
    }
}
