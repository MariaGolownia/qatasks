package by.halaunia.runner;

import by.halaunia.util.UserDialog;
import by.halaunia.util.sort.Sort;
import by.halaunia.util.JaggedArray;
import by.halaunia.util.JaggedArrayException;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Ввести с консоли n - размерность матрицы a [n] [n].
//        Задать значения элементов матрицы в интервале значений от -M до M с помощью генератора случайных чисел (класс Random).
        int[][] jaggedArray = UserDialog.createJaggedArrayByUserDialog();
        UserDialog.println("Before sorting: ");
        JaggedArray.print2DArray(jaggedArray);

//1.     Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
        try {
            UserDialog.println("Please, input number of row for sorting: ");
            Integer numberRowSort = UserDialog.receiveIntFromConsole();
            Sort.sort(jaggedArray, numberRowSort, new Sort().new SortArrInc());
            UserDialog.println("After sorting: ");
            JaggedArray.print2DArray(jaggedArray);
        } catch (JaggedArrayException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }

//2.     Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
        List<String> arrSuccess = JaggedArray.findSuccessionInc(jaggedArray);
        UserDialog.println(Arrays.toString(arrSuccess.toArray()));
        UserDialog.println(JaggedArray.findCountSuccessionInc(jaggedArray).toString());

    }
}
