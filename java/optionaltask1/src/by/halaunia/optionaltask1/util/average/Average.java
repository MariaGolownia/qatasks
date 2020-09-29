package by.halaunia.optionaltask1.util.average;

import java.util.*;

public class Average {
    public static Integer findAverageLength(List<Integer> arrInt) {
        Integer sum = 0;
        for (int i = 0; i < arrInt.size(); i++) {
            sum += arrInt.get(i).toString().length();
        }
        return sum / arrInt.size();
    }

    public static Map<Integer, Integer> findDigitLessAverLength(List<Integer> arrInt) {
        Integer count = 0;
        Map<Integer, Integer> mapInt = new Hashtable<>();
        Integer averageArrLengrh = findAverageLength(arrInt);
        ListIterator<Integer> arrIntIter = arrInt.listIterator();
        while (arrIntIter.hasNext()) {
            Integer digitInt = arrIntIter.next();
            if (Integer.toString(digitInt).length() < averageArrLengrh) {
                mapInt.put (++count, digitInt);
            }
        }
        return mapInt;
    }

    public static Map<Integer, Integer> findDigitMoreAverLength(List<Integer> arrInt) {
        Integer count = 0;
        Map<Integer, Integer> mapInt = new Hashtable<>();
        Integer averageArrLengrh = findAverageLength(arrInt);
        ListIterator<Integer> arrIntIter = arrInt.listIterator();
        while (arrIntIter.hasNext()) {
            Integer digitInt = arrIntIter.next();
            if (Integer.toString(digitInt).length() > averageArrLengrh) {
                mapInt.put (++count, digitInt);
            }
        }
        return mapInt;
    }
}
