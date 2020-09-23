package by.halaunia.service;

import by.halaunia.service.valid.CommonValidation;
import by.halaunia.service.valid.IncorrectDataException;

public class ReverseOrder {

    public static String[] reverseStrArr(String[] args) {
        String[] argsReverse = null;
        try {
            if (args == null) {
                System.out.println("Please, input several args for reversing!");
            } else if (!CommonValidation.checkIfStrArrIsNotEmpty(args)) {
                System.out.println("Please, input several not null or not empty args for reversing!");
            } else {
                argsReverse = flip(args);
            }
        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
        return argsReverse;
    }

    public static String[] flip(String[] args) {
        String[] argsFlip = new String[args.length];
        for (int i = 0, j = args.length - 1; i < args.length; i++, j--) {
            argsFlip[i] = args[j];
        }
        return argsFlip;
    }
}
