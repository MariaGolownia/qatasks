package by.halaunia.util;

import by.halaunia.valid.DigitsValidation;
import by.halaunia.valid.IncorrectDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class JaggedArray {

    public static int[][] generateJaggedArrInt(Integer countRow, Integer minValue, Integer maxValue) {
        int[][] jaggedArr = new int[countRow][countRow];
        int i = 0;
        while (i < countRow) {
            for (int j = 0; j < jaggedArr[i].length; j++) {
                int[] arrRow = new int[0];
                try {
                    arrRow = RandomDigits.generateArrRandomDigits(countRow,
                            Integer.valueOf(minValue), Integer.valueOf(maxValue));
                } catch (JaggedArrayException e) {
                    System.out.println(e.getMessage() + e.toString());
                }
                jaggedArr[i][j] = arrRow[j];
            }
            i++;
        }
        return jaggedArr;
    }

    public static int[][] generateJaggedArrInt(Integer minValue, Integer maxValue) {
        int[][] jaggedArr = null;
        System.out.println("Enter row numbers of jagged arr: ");
        String numberRowStr = UserDialog.receiveDataFromConsole();
        try {
            DigitsValidation.checkIfNumber(numberRowStr);
            Integer numberRowInt = Integer.parseInt(numberRowStr);
            jaggedArr = new int[numberRowInt][numberRowInt];
            int i = 0;
            while (i < numberRowInt) {
                for (int j = 0; j < jaggedArr[i].length; j++) {
                    int[] arrRow = RandomDigits.generateRandomDigits(numberRowInt, minValue, maxValue);
                    jaggedArr[i][j] = arrRow[j];
                }
                i++;
            }
        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
        return jaggedArr;
    }

    public static void print2DArray(int[][] jaggedArray) {
        System.out.println("");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.printf("%10d", jaggedArray[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static List<String> findSuccessionInc(int[][] jaggedArray) {
        Boolean flagNext = true;
        Integer leftInt = null;
        Integer rightInt;
        int k = 0;
        List<String> successionArr = new ArrayList<>();
        if (jaggedArray.length > 0)
            leftInt = jaggedArray[0][0];
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                if (flagNext.equals(true)) {
                    successionArr.add(k, jaggedArray[i][j] + ";");
                    flagNext = false;
                    k++;
                }
                if (j != jaggedArray[i].length - 1) {
                    rightInt = jaggedArray[i][j + 1];
                } else if (i != jaggedArray.length - 1 && j == jaggedArray[i].length - 1) {
                    rightInt = jaggedArray[i + 1][0];
                    leftInt = jaggedArray[i][jaggedArray[i].length - 1];
                } else {
                    break;
                }
                if (rightInt != null && leftInt != null && rightInt > leftInt) {
                    if (k == 0) {
                        successionArr.add(k, jaggedArray[i][j] + ";");
                    } else {
                        String str = successionArr.get(k - 1);
                        successionArr.set(k - 1, str + rightInt + ";");
                    }
                } else {
                    flagNext = true;
                }
            }
        }
        return successionArr;
    }

    public static Integer findCountSuccessionInc(int[][] jaggedArray) {
        Integer countSuccess = 0;
        TreeSet<Integer> countSuccessSet = new TreeSet<>();
        Boolean flagNext = true;
        Integer leftInt = null;
        Integer rightInt;
        int k = 0;
        List<String> successionArr = new ArrayList<>();
        if (jaggedArray.length > 0)
            leftInt = jaggedArray[0][0];
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                if (flagNext.equals(true)) {
                    successionArr.add(k, jaggedArray[i][j] + ";");
                    flagNext = false;
                    k++;
                    countSuccess++;
                }
                if (j != jaggedArray[i].length - 1) {
                    rightInt = jaggedArray[i][j + 1];
                } else if (i != jaggedArray.length - 1 && j == jaggedArray[i].length - 1) {
                    rightInt = jaggedArray[i + 1][0];
                    leftInt = jaggedArray[i][jaggedArray[i].length - 1];
                } else {
                    break;
                }
                if (rightInt != null && leftInt != null && rightInt > leftInt) {
                    if (k == 0) {
                        successionArr.add(k, jaggedArray[i][j] + ";");
                        countSuccess++;
                    } else {
                        String str = successionArr.get(k - 1);
                        successionArr.set(k - 1, str + rightInt + ";");
                        countSuccess++;
                    }
                } else {
                    countSuccessSet.add(countSuccess);
                    countSuccess = 0;
                    flagNext = true;
                }
            }
        }
        return countSuccessSet.last();
    }
}