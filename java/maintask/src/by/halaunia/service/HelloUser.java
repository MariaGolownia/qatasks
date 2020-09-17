package by.halaunia.service;

import by.halaunia.service.valid.HelloUserValidation;

import java.util.Scanner;

public class HelloUser {
    public static final Integer MAX_COUNT_WORDS_IN_NAME = 5;
    public static final String WELCOME_STR_USER = "Please, input your name: ";
    public static final String HELLO_STR_UNKNOWN_USER = "Hello, unknown user!";
    public static final String HELLO_STR_KNOWN_USER = "Hello, ";
    public static final String INFORM_LONG_NAME = "Are you sure that you have your name longer than " +
            MAX_COUNT_WORDS_IN_NAME + " words? Please, input your short name!";

    public static void welcomeUser() {
        System.out.print(WELCOME_STR_USER);
        Scanner userName = new Scanner(System.in);
        try {
            String result = HelloUser.sayHelloUser(userName);
            if (result != null && !result.trim().equals(""))
                System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String sayHelloUser(Scanner userName) throws Exception {
        String result = "";
        if (userName == null) {
            throw new Exception("Scanner exception!");
        } else {
            result = userName.nextLine();
            String[] strArr = result.split(" ");
            if (strArr == null) {
                result = HELLO_STR_UNKNOWN_USER;
            } else if (!HelloUserValidation.checkIfNameArrIsNotEmpty(strArr)) {
                result = HELLO_STR_UNKNOWN_USER;
            } else if (strArr.length > MAX_COUNT_WORDS_IN_NAME) {
                System.out.println(INFORM_LONG_NAME);
                welcomeUser();
                result = null;
            } else {
                for (int i = 0; i < strArr.length; i++) {
                    HelloUserValidation.checkName(strArr[i]);
                }
                result = HELLO_STR_KNOWN_USER + result.substring(0, 1).toUpperCase() + result.substring(1) + "!";
            }
        }
        return result;
    }
}
