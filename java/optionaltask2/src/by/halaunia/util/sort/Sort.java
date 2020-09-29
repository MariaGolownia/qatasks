package by.halaunia.util.sort;


import by.halaunia.util.JaggedArrayException;

public class Sort {
    public static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void sort(int[] array, Sorter s) {
        s.sort(array);
    }

    public static void sort(int[][] jaggedArray, int row, Sorter s) throws JaggedArrayException {
        int[] arrRow = null;
        if ((row < jaggedArray.length) || (row > 0)) {
            for (int i = 0; i < jaggedArray.length; i++) {
                if (i == row) {
                    arrRow = new int[jaggedArray.length];
                    for (int j = 0; j < jaggedArray[i].length; j++) {
                        arrRow[j] = jaggedArray[i][j];
                    }
                }
            }
            if (arrRow != null) {
                s.sort(arrRow);
            }
            for (int i = 0; i < jaggedArray.length; i++) {
                if (i == row) {
                    for (int j = 0; j < jaggedArray[i].length; j++) {
                        jaggedArray[i][j] = arrRow[j];
                    }
                }
                System.out.print("\n");
            }
        } else {
            throw new JaggedArrayException("Desired row is not of current array!");
        }

    }

    public class SortArrInc implements Sorter {
        public void sort(int[] arrInt) {
            bubbleSortByLengthInc(arrInt);
        }


        public class SortArrDec implements Sorter {
            public void sort(int[] arrInt) {
                bubbleSortByLengthDec(arrInt);
            }
        }
    }

    //Сортировка пузырьком array по возрастанию
    public static void bubbleSortByLengthInc(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;
        else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
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
                    if (array[j] < array[j + 1]) {
                        swap(array, j, j + 1);
                    }
                }
            }
        }
    }
}
