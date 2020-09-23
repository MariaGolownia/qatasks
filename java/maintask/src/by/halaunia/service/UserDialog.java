package by.halaunia.service;

import java.util.Scanner;

public class UserDialog {

    public static String receiveDataFromCommandLine() {
        Scanner srtFromUser = new Scanner(System.in);
        String result = srtFromUser.nextLine();
        return result;
    }
}
