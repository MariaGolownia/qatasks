package by.halaunia.optionaltask1.util.sort;

import by.halaunia.optionaltask1.util.valid.DigitsValidation;
import by.halaunia.optionaltask1.util.valid.IncorrectDataException;

public class Sort {
    public static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void swap(String[] array, int a, int b) {
        String tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void sort(int[] array, Sorter s) {
        try {
            DigitsValidation.checkArrIfOfNumbers(array);
            s.sort(array);
        } catch (IncorrectDataException e) {
            System.out.println(e.getMessage() + e.toString());
        }
    }

    public static void sort(String[] array, Sorter s) {
        try {
            DigitsValidation.checkArrIfOfNumbers(array);
            s.sort(array);
        } catch (IncorrectDataException e) {
            System.out.println(e.getMessage() + e.toString());
        }
    }

    public class SortArrByLengthInc implements Sorter {
        public void sort(int[] arrInt) {
            bubbleSortByLengthInc(arrInt);
        }

        @Override
        public void sort(String[] arrStr) {
            bubbleSortByLengthInc(arrStr);
        }
    }

    public class SortArrByLengthDec implements Sorter {
        public void sort(int[] arrInt) {
            bubbleSortByLengthDec(arrInt);
        }

        @Override
        public void sort(String[] arrStr) {
            bubbleSortByLengthDec(arrStr);
        }
    }

    //Сортировка пузырьком array по возрастанию
    public static void bubbleSortByLengthInc(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;
        else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (Integer.toString(array[j]).length() > Integer.toString(array[j + 1]).length()) {
                        swap(array, j, j + 1);
                    }
                }
            }
        }
    }

    public static void bubbleSortByLengthInc(String[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;
        else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j].length() > array[j + 1].length()) {
                        swap(array, j, j + 1);
                    }
                }
            }
        }
    }

    //Сортировка пузырьком array по убыванию
    public static void bubbleSortByLengthDec(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;
        else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (Integer.toString(array[j]).length() < Integer.toString(array[j + 1]).length()) {
                        swap(array, j, j + 1);
                    }
                }
            }
        }
    }

    public static void bubbleSortByLengthDec(String[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;
        else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j].length() < array[j + 1].length()) {
                        swap(array, j, j + 1);
                    }
                }
            }
        }
    }
}
