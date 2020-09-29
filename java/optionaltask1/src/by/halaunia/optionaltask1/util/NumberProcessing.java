package by.halaunia.optionaltask1.util;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class NumberProcessing {

    public static Map<Integer, Integer> findMaxLengthNumber(List<Integer> arrInt) {
        Map<Integer, Integer> maxNumberMap = null;
        Integer countMaxNumber = null;
        Integer numberMax = arrInt.get(0);
        for (int i = 0; i < arrInt.size(); i++) {
            if (numberMax.toString().length() < arrInt.get(i).toString().length()) {
                numberMax = arrInt.get(i);
                maxNumberMap = new Hashtable<>();
                maxNumberMap.put(0, numberMax);
                continue;
            }
            if (numberMax.toString().length() == arrInt.get(i).toString().length()) {
                if (maxNumberMap != null) {
                    numberMax = arrInt.get(i);
                    countMaxNumber = Integer.parseInt(maxNumberMap.keySet().toArray()[0].toString());
                    maxNumberMap.put(++countMaxNumber, numberMax);
                } else {
                    maxNumberMap = new Hashtable<>();
                    maxNumberMap.put(1, numberMax);
                }
            }
        }
        return maxNumberMap;
    }


    public static Map<Integer, Integer> findMinLengthNumber(List<Integer> arrInt) {
        Map<Integer, Integer> minNumberMap = null;
        Integer countMinNumber = null;
        Integer numberMin = arrInt.get(0);
        for (int i = 0; i < arrInt.size(); i++) {
            if (numberMin.toString().length() > arrInt.get(i).toString().length()) {
                numberMin = arrInt.get(i);
                minNumberMap = new Hashtable<>();
                minNumberMap.put(1, numberMin);
                continue;
            }
            if (numberMin.toString().length() == arrInt.get(i).toString().length()) {
                if (minNumberMap != null) {
                    numberMin = arrInt.get(i);
                    countMinNumber = Integer.parseInt(minNumberMap.keySet().toArray()[0].toString());
                    minNumberMap.put(++countMinNumber, numberMin);
                } else {
                    minNumberMap = new Hashtable<>();
                    minNumberMap.put(0, numberMin);
                }
            }
        }
        return minNumberMap;
    }
}
