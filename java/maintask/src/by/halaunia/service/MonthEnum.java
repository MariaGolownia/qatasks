package by.halaunia.service;

import by.halaunia.service.valid.IncorrectDataException;
import by.halaunia.service.valid.MonthValidation;

public enum MonthEnum {
    MONTH_1("January"),
    MONTH_2("February"),
    MONTH_3("March"),
    MONTH_4("April"),
    MONTH_5("May"),
    MONTH_6("June"),
    Month_7("July"),
    MONTH_8("August"),
    MONTH_9("September"),
    MONTH_10("October"),
    MONTH_11("November"),
    MONTH_12("December");

    private String value;

    MonthEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Month analyzeMonth(String monthStr) {
        String resultMonth = "";
        String monthStrNew = "";
        Month month = null;
        try {
            for (int i = 0; i < monthStr.length()-1; i++) {
                if (i <= (monthStr.length()-1)) {
                    if (monthStr.substring(i, i+1).equals("0")) {
                        monthStrNew = monthStr.substring(i+1);
                    }
                }
            }
            MonthValidation.checkIfMonthNumber(monthStrNew);
            MonthEnum monthEnum = MonthEnum.valueOf("MONTH_"+ monthStrNew);
            resultMonth = monthEnum.getValue();
            month = new Month(resultMonth, Integer.parseInt(monthStrNew));

        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
        return month;
    }
}
