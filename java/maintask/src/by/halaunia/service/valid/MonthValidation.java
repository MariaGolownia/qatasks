package by.halaunia.service.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MonthValidation {
    private static final String MONTH_REGEX = "^([1-9]|1[012])$";
    private static final Pattern MONTH_PATTERN = Pattern.compile(MONTH_REGEX);
    /**
     * Checks the month of month is real.
     *
     * @param month to be checked
     * @throws IncorrectDataException if the month is not real
     */
    public static void checkIfMonthNumber(String month) throws IncorrectDataException {
        if (month == null || month.trim().equals("")) {
            throw new IncorrectDataException("Month is null!");
        }
        Matcher matcher = MONTH_PATTERN.matcher(month);
        if (!matcher.matches()) {
            throw new IncorrectDataException("Number of month: is incorrect! Please, input only integer digits from 1 to 12!");
        }
    }
}
