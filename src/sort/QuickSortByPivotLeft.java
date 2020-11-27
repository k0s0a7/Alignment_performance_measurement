package sort;

public class QuickSortByPivotLeft<E extends Comparable<E>> extends QuickSort<E> {

    public QuickSortByPivotLeft(boolean givenSortingOrder) {
        super(givenSortingOrder);
    }

    @Override
    protected int pivot(E[] aList, int left, int right) {
        return left;
    }
}
