package by.halaunia.optionaltask1.runner;

import by.halaunia.optionaltask1.util.NumberProcessing;
import by.halaunia.optionaltask1.util.UserDialog;
import by.halaunia.optionaltask1.util.average.Average;
import by.halaunia.optionaltask1.util.diff.Difference;
import by.halaunia.optionaltask1.util.sort.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // 1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        // Receive max or min number.
        // Map helps to restore count of max/min numbers, because we could have several digits with max or min length values.
        UserDialog.println("Please, input several numbers separated by space: ");
        List<Integer> listInt = UserDialog.receiveListIntFromConsole();
        Map<Integer, Integer> mapResultMax = NumberProcessing.findMaxLengthNumber(listInt);
        UserDialog.println("Max number's length is: ");
        UserDialog.printMap(mapResultMax);

        Map<Integer, Integer> mapResultMin = NumberProcessing.findMinLengthNumber(listInt);
        UserDialog.println("Min number's length is: ");
        UserDialog.printMap(mapResultMin);

        // 2.     Вывести числа в порядке возрастания (убывания) значений их длины.
        int[] arrInt = UserDialog.listToArrInt(listInt);
        UserDialog.println("Arr is before sorting: " + Arrays.toString(arrInt));
        Sort.sort(arrInt, new Sort().new SortArrByLengthInc());
        UserDialog.println("Arr is after sorting: " + Arrays.toString(arrInt));

        //3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
        UserDialog.println("Arr of digit with length less than average -> ");
        UserDialog.printMapLengthInfo(Average.findDigitLessAverLength(listInt));
        UserDialog.println("Arr of digit with length more than average -> ");
        UserDialog.printMapLengthInfo(Average.findDigitMoreAverLength(listInt));

        //4.     Найти число, в котором количество различных цифр минимально.
        // Если таких чисел несколько, найти первое из них.
        UserDialog.println("The number with min different digits -> ");
        UserDialog.println(Difference.findNumberMinWithDiffDig(arrInt).toString());

    }
}
