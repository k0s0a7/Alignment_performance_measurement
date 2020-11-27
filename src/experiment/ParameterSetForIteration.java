package experiment;

public class ParameterSetForIteration {

    private static final int DEFAULT_NUMBER_OF_ITERATION = 10;
    private static final int DEFAULT_INCREMENT_SIZE = 1000;
    private static final int DEFAULT_STARTING_SIZE = DEFAULT_INCREMENT_SIZE;

    private int _startingSize;
    private int _numberOfIteration;
    private int _incrementSize;

    public int startingSize() {
        return this._startingSize;
    }
    public void setStartingSize(int newStartingSize) {
        this._startingSize = newStartingSize;
    }

    public int numberOfIteration() {
        return this._numberOfIteration;
    }
    public void setNumberOfIteration(int newNumberOfIteration) {
        this._numberOfIteration = newNumberOfIteration;
    }

    public int incrementSize() {
        return this._incrementSize;
    }
    public void setIncrementSize(int newIncrementSize) {
        this._incrementSize = newIncrementSize;
    }

    public int maxDataSize() {
        return (this.startingSize() + (this.incrementSize()*(this.numberOfIteration()-1)));
    }

    public ParameterSetForIteration() {
        this.setStartingSize(DEFAULT_STARTING_SIZE);
        this.setNumberOfIteration(DEFAULT_NUMBER_OF_ITERATION);
        this.setIncrementSize(DEFAULT_INCREMENT_SIZE);
    }

    public ParameterSetForIteration(int givenStartingSize, int givenNumberOfIteration, int givenIncrementSize) {
        this.setStartingSize(givenStartingSize);
        this.setNumberOfIteration(givenNumberOfIteration);
        this.setIncrementSize(givenIncrementSize);
    }
}
