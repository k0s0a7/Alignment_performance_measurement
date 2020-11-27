package experiment;

public enum ListOrder {
    Random,
    Ascending,
    Descending;

    public String orderName() {
        if(this.equals(ListOrder.Random)) {
            return "무작위";
        }
        else if(this.equals(ListOrder.Ascending)) {
            return "오름차순";
        }
        else {
            return "내림차순";
        }
    }
}
