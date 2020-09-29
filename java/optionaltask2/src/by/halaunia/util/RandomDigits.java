package by.halaunia.util;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDigits {
    public static final Integer MAX_DIGIT = Integer.MAX_VALUE;
    public static final Integer MIN_DIGIT = Integer.MIN_VALUE;

    public static int[] generateRandomDigits(Integer numberRowInt, Integer minValue, Integer count) {
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(MIN_DIGIT, MAX_DIGIT);
        }
        return arr;
    }

    public static int[] generateArrRandomDigits(int count, Integer minValue, Integer maxValue) throws JaggedArrayException {
        Random random = new Random();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        return arr;
    }
}
