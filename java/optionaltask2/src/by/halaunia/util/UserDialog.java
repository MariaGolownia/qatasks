package by.halaunia.util;

import by.halaunia.valid.DigitsValidation;
import by.halaunia.valid.IncorrectDataException;

import java.util.*;

public class UserDialog {

    public static String receiveDataFromConsole() {
        Scanner srtFromUser = new Scanner(System.in);
        String result = srtFromUser.nextLine();
        return result;
    }

    public static Integer receiveIntFromConsole() {
        Scanner srtFromUser = new Scanner(System.in);
        Integer number = null;
        try {
            String resultStr = srtFromUser.nextLine();
            DigitsValidation.checkIfNumber(resultStr);
            number = Integer.parseInt(resultStr);
        } catch (IncorrectDataException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return number;
    }

    public static void println(String strPrint) {
        System.out.println(strPrint);
    }


    public static int[][] createJaggedArrayByUserDialog() {
        int[][] jaggedArr = null;
        System.out.println("Enter row numbers of jagged arr: ");
        String numberRowStr = UserDialog.receiveDataFromConsole();
        try {
            DigitsValidation.checkIfNumber(numberRowStr);
            System.out.println("Enter min int value of jagged arr: ");
            String minValueStr = UserDialog.receiveDataFromConsole();
            try {
                DigitsValidation.checkIfNumber(minValueStr);
                Integer minValueInt = Integer.valueOf(minValueStr);
                System.out.println("Enter max int value of jagged arr: ");
                String maxValueStr = UserDialog.receiveDataFromConsole();
                try {
                    DigitsValidation.checkIfNumber(maxValueStr);
                    Integer maxValueInt = Integer.valueOf(maxValueStr);
                    Integer numberRowInt = Integer.parseInt(numberRowStr);
                    DigitsValidation.checkIfMaxBiggerMin(minValueInt, maxValueInt);
                    //jaggedArr = new int[numberRowInt][numberRowInt];
                    jaggedArr = JaggedArray.generateJaggedArrInt(numberRowInt, minValueInt, maxValueInt);
                } catch (IncorrectDataException e) {
                    System.out.println("Error in row number! " + e.getMessage());
                    e.printStackTrace();
                }
            } catch (IncorrectDataException e) {
                System.out.println("Error in min value of array! " + e.getMessage());
                e.printStackTrace();
            }
        } catch (IncorrectDataException e) {
            System.out.println("Error in max value of array! " +e.getMessage());
            e.printStackTrace();
        }
        return jaggedArr;
    }
}
