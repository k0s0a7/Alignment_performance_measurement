package experiment;

public class ParameterSetForMeasurement extends ParameterSetForIteration{

    private static final int DEFAULT_NUMBER_OFREPETITION_OF_SINGLE_SORT = 1;

    private int _numberOfRepetitionOfSingleSort;

    public int numberOfRepetitionOfSingleSort() {
        return this._numberOfRepetitionOfSingleSort;
    }
    public void setNumberOfRepetitionOfSingleSort(int newNumberOfRepetitionOfSingleSort) {
        this._numberOfRepetitionOfSingleSort = newNumberOfRepetitionOfSingleSort;
    }

    public ParameterSetForMeasurement() {
        super();
        this.setNumberOfRepetitionOfSingleSort(DEFAULT_NUMBER_OFREPETITION_OF_SINGLE_SORT);;
    }
    public ParameterSetForMeasurement(int givenStartingSize, int givenNumberOfIteration,
                                      int givenIncrementSize, int givenNumberOfRepetitionOfSingleSort) {
        super(givenStartingSize,givenNumberOfIteration,givenIncrementSize);
        this.setNumberOfRepetitionOfSingleSort(givenNumberOfRepetitionOfSingleSort);
    }
}
