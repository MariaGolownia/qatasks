package by.halaunia.optionaltask1.util.diff;

import java.util.HashSet;

public class Difference {

    public static Integer findNumberMinWithDiffDig(int[] arr) {
        int min = diffNum(arr[0]);
        int minItem = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (diffNum(arr[i]) < min) {
                min = diffNum(arr[i]);
                minItem = arr[i];
            }
        }
        return minItem;
    }

    public static int diffNum(int x) {
        HashSet<Integer> nums = new HashSet<>();
        while (x > 0) {
            nums.add(x % 10);
            x /= 10;
        }
        return nums.size();
    }
}

