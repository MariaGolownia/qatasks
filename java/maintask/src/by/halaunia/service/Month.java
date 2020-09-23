package by.halaunia.service;

import java.util.Scanner;

public class Month {
    private String name;
    private int monthNumber;

    public Month(String name, int monthNumber) {
        this.name = name;
        this.monthNumber = monthNumber;
    }

    public Month(String monthNumber) {
        Month month = MonthEnum.analyzeMonth(monthNumber);
        if (month != null) {
            this.name = month.getName();
            this.monthNumber = month.getMonthNumber();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public static void treatMonthCMD() {
        String resultMonth = UserDialog.receiveDataFromCommandLine();
        Month month = new Month(resultMonth);
        if (month != null && !month.getName().trim().equals("")) {
            System.out.println("It's " + month.getName() + "!");
        }
    }
}
