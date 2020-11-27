package sort;

public class QuickSortByPivotMedian<E extends Comparable<E>> extends QuickSort<E> {

    public QuickSortByPivotMedian(boolean givenSortingOrder) {
        super(givenSortingOrder);
    }

    @Override
    protected int pivot(E[] aList, int left, int right) {
        if((right-left) < 3) {
            return left;
        }
        int mid = (left+right)/2;
        if (this.compare(aList[left], aList[mid])<0) {
            if(this.compare(aList[mid], aList[right])<0) {
                return mid;
            }
            else {
                if(this.compare(aList[left], aList[right])<0) {
                    return right;
                }
                else {
                    return left;
                }
            }
        }
        else {
            if(this.compare(aList[left], aList[right])<0) {
                return left;
            }
            else {
                if(this.compare(aList[mid], aList[right])<0) {
                    return right;
                }
                else {
                    return mid;
                }
            }
        }
    }
}
