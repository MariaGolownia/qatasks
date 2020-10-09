package by.halaunia.valid;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class contains basic client-side validation methods for users.
 */

public class DataValidator {
    public static final short MIN_CAR_YEAR = 1000;

    private DataValidator() {
    }

    public static void checkYear(short year) throws IncorrectDataException {
        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        calendar.setTime(new java.util.Date());
        Integer currentYear = calendar.get(java.util.Calendar.YEAR);
        if (year < MIN_CAR_YEAR) {
            throw new IncorrectDataException("A year of car cannot be less than min year " + MIN_CAR_YEAR + "!");
        }
        else if ((currentYear).compareTo((int)year) < 0) {
            throw new IncorrectDataException("A year of car cannot be later than the current year!");
        }
    }

    public static void checkPositiveBigDecimal(BigDecimal value) throws IncorrectDataException {
             if (value.compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IncorrectDataException("A price of car must be positive!");
        }
    }
}
