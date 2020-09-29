package by.halaunia.optionaltask1.util;

import by.halaunia.optionaltask1.util.valid.DigitsValidation;
import by.halaunia.optionaltask1.util.valid.IncorrectDataException;

import java.util.*;

public class UserDialog {

    public static String receiveDataFromConsole() {
        Scanner srtFromUser = new Scanner(System.in);
        String result = srtFromUser.nextLine();
        return result;
    }

    public static List<Integer> receiveListIntFromConsole() {
        List<Integer> arrInt = null;
        String resultStr = receiveDataFromConsole();
        String[] arrStr = resultStr.split(" ");
        try {
            arrInt = new ArrayList<>();
            for (int i = 0; i < arrStr.length; i++) {
                if (!arrStr[i].trim().equals("")) {
                    DigitsValidation.checkIfNumber(arrStr[i]);
                    arrInt.add(Integer.parseInt(arrStr[i]));
                }
            }
        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
        return arrInt;
    }

    public static int[] receiveArrIntFromConsole() {
        List<Integer> listInt = receiveListIntFromConsole();
        int[] arrInt = listToArrInt(listInt);
        return arrInt;
    }

    public static int[] listToArrInt(List<Integer> listInt) {
        int[] arrInt = new int [listInt.size()];
        for (int i = 0; i < listInt.size(); i++) {
            arrInt[i] = listInt.get(i);
        }
        return arrInt;
    }

    public static void printMap(Map<Integer, Integer> mapPrint) {
        Iterator<Map.Entry<Integer, Integer>> iterator = mapPrint.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> pair = iterator.next();
            System.out.println(pair.getKey() + ":" + pair.getValue());
        }
    }

    public static void printMapLengthInfo(Map<Integer, Integer> mapPrint) {
        Iterator<Map.Entry<Integer, Integer>> iterator = mapPrint.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> pair = iterator.next();
            System.out.println(pair.getKey() + ": number - " + pair.getValue() + ", length - " + Integer.toString(pair.getValue()).length());
        }
    }

    public static void println(String strPrint) {
        System.out.println(strPrint);
    }
}
