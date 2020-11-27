package experiment;

import app.AppView;
import sort.Sort;

public class Experiment {

    private static final boolean DEBUG_MODE = false;
    private static void showDebugMessage(String aMessage) {
        if(Experiment.DEBUG_MODE) {
            AppView.outputDebugMessage(aMessage);
        }
    }

    private static Integer[] copyListOfGivenSize(Integer[] aList, int givenSize) {
        if(givenSize <= aList.length) {
            Integer[] copiedList = new Integer[givenSize];
            for(int i = 0; i < givenSize; i++) {
                copiedList[i] = aList[i];
            }
            return copiedList;
        }
        return null;
    }

    public static long durationOfSingleSort(Sort<Integer>aSort, Integer[] aList) {
        Timer.start();
        {
            aSort.sort(aList);
        }
        Timer.stop();
        return Timer.duration();
    }

    private ParameterSetForMeasurement _parameterSetForMeasurement;

    private ParameterSetForMeasurement parameterSetForMeasurment() {
        return this._parameterSetForMeasurement;
    }
    private void setParameterSetForMeasurment(ParameterSetForMeasurement newParameterSet) {
        this._parameterSetForMeasurement = newParameterSet;
    }

    public Experiment(ParameterSetForMeasurement givenParameterSet) {
        this.setParameterSetForMeasurment(givenParameterSet);
    }

    public long[] durationsOfSort(Sort<Integer> sort, Integer[] list) {
        long[] durations = new long[this.parameterSetForMeasurment().numberOfIteration()];
        for(int i = 0, size = this.parameterSetForMeasurment().startingSize();
            i < this.parameterSetForMeasurment().numberOfIteration();
            i++, size += this.parameterSetForMeasurment().incrementSize()) {
            long sumOfDurations = 0;
            for(int repeated = 0;
                repeated < this.parameterSetForMeasurment().numberOfRepetitionOfSingleSort();
                repeated++)
            {
                Integer[] currentList = Experiment.copyListOfGivenSize(list, size);
                sumOfDurations += Experiment.durationOfSingleSort(sort, currentList);
            }
            durations[i] = sumOfDurations / this.parameterSetForMeasurment().numberOfRepetitionOfSingleSort();
            Experiment.showDebugMessage("[Debug.Experiment]" + sort.toString() + "(" + i + ")\n");
        }
        return durations;
    }
}
