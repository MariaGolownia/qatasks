package by.halaunia.service.valid;

public class CommonValidation {

    public static Boolean checkIfStrArrIsNotEmpty(String[] strArr) throws IncorrectDataException {
        Boolean result = false;
        if (strArr != null) {
            Integer countStrInArrIsNotEmpty = 0;
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i] != null || !strArr[i].trim().equals("")) {
                    countStrInArrIsNotEmpty++;
                }
            }
            result = (countStrInArrIsNotEmpty > 0) ? true : false;
        }
        return result;
    }
}
