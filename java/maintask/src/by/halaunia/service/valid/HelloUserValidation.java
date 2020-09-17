package by.halaunia.service.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloUserValidation {
    private static final String NAME_NAME_REGEX = "[A-Za-zА-Яа-я]{2,50}";
    private static final Pattern NAME_NAME_PATTERN = Pattern.compile(NAME_NAME_REGEX);

    /**
     * Checks the name  matches the required format.
     *
     * @param name name to be checked
     * @throws IncorrectDataException if the name does not represent a string of letters
     *                                without any numbers in length from 2 to 50 symbols.
     */
    public static void checkName(String name) throws IncorrectDataException {
        if (name != null && !name.trim().equals("")) {
            Matcher matcher = NAME_NAME_PATTERN.matcher(name);
            if (!matcher.matches()) {
                System.out.println("Name: " + name + " is incorrect!");
                throw new IncorrectDataException("Name: " + name + " is incorrect, because" +
                        " or less than 2 words or longer than 50 words or includes special symbols or digits!");
            }
        }
    }

    public static Boolean checkIfNameArrIsNotEmpty(String[] nameArr) throws IncorrectDataException {
        Boolean result = false;
        if (nameArr != null) {
            Integer countNamesInArrIsNotEmpty = 0;
            for (int i = 0; i < nameArr.length; i++) {
                if (nameArr[i] != null || !nameArr[i].trim().equals("")) {
                    countNamesInArrIsNotEmpty++;
                }
            }
            result = (countNamesInArrIsNotEmpty > 0) ? true : false;
        }
        return result;
    }
}
