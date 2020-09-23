package by.halaunia.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDigits {
    public static final Integer MAX_DIGIT = Integer.MAX_VALUE - 1;
    public static final Integer MIN_DIGIT = Integer.MIN_VALUE;

    public static void printRandomDigits(int count, Boolean ifNewLine) {
        List<Integer> arr = generateRandomDigits(count);
        if (ifNewLine.equals(false)) {
            System.out.println(Arrays.toString(arr.toArray()));
        } else {
            for (int item : arr) {
                System.out.println(item + " ");
            }
        }
    }

    public static List<Integer> generateRandomDigits(int count) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int numberRnd = ThreadLocalRandom.current().nextInt(MIN_DIGIT, MAX_DIGIT+ 1);
            arr.add(numberRnd);
        }
        return arr;
    }

}
