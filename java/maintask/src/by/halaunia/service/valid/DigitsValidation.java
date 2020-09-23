package by.halaunia.service.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitsValidation {

    private static final String NUMBER_REGEX = "^\\d+$";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

    /**
     * Checks the number  matches the required format.
     *
     * @param number to be checked
     * @throws IncorrectDataException if the number is not digit
     */
    public static void checkIfNumber(String number) throws IncorrectDataException {
        if (number == null) {
            throw new IncorrectDataException("Number is null!");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(number);
        if (!matcher.matches()) {
            throw new IncorrectDataException("Number: is incorrect! Please, input only integer digits!");
        }
    }

    public static void checkArrIfOfNumbers(String[] args) throws IncorrectDataException {
        if (args == null) {
            throw new IncorrectDataException("Args of string is null!");
        } else {
            for (int i = 0; i < args.length; i++) {
                checkIfNumber(args[i]);
            }
        }

    }
}
