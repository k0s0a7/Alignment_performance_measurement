package experiment;

import java.util.Random;

public final class DataGenerator {

    private DataGenerator() {};

    public static Integer[] ascendingList(int aSize) {
        if(aSize > 0) {
            Integer[] list = new Integer[aSize];
            for(int i = 0; i < aSize; i++) {
                list[i] = i;
            }
            return list;
        }
        return null;
    }

    public static Integer[] descendingList(int aSize) {
        if(aSize > 0) {
            Integer[] list = new Integer[aSize];
            for(int i = 0; i < aSize; i++) {
                list[i] = aSize - i - 1;
            }
            return list;
        }
        return null;
    }

    public static Integer[] randomList(int aSize) {
        if(aSize > 0) {
            Integer[] list = new Integer[aSize];
            Random random = new Random();
            for(int i = 0; i < aSize; i++) {
                list[i] = random.nextInt(aSize);
            }
            return list;
        }
        return null;
    }
}
