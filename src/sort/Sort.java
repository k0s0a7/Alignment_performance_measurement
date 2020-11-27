package sort;

public abstract class Sort<E extends Comparable <E>> {

    private boolean _nonDereasingOrder;

    public boolean nonDecreasingOrder() {
        return this._nonDereasingOrder;
    }
    public void setNonDecreasingOrder(boolean newNonDecreasingOrder) {
        this._nonDereasingOrder = newNonDecreasingOrder;
    }

    protected void swap(E[] aList, int i, int j) {
        E tempElement = aList[i];
        aList[i] = aList[j];
        aList[j] = tempElement;
    }

    protected int compare(E anElement, E theOtherElement) {
        if(this.nonDecreasingOrder()) {
            return anElement.compareTo(theOtherElement);
        }
        else {
            return -anElement.compareTo(theOtherElement);
        }
    }

    public Sort(boolean givenSortingOrder) {
        this.setNonDecreasingOrder(givenSortingOrder);
    }

    public abstract boolean sort(E[] aList);
}
