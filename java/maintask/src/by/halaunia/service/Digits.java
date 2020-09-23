package by.halaunia.service;

import by.halaunia.service.valid.DigitsValidation;
import by.halaunia.service.valid.IncorrectDataException;

import java.util.ArrayList;
import java.util.List;

public class Digits {
    List<Integer> intArr = new ArrayList<>();
    Integer sum = null;
    Integer mult = null;

    public Digits(List<Integer> intArr) {
        this.intArr = intArr;
    }

    public Digits(String[] args) {
        try {
            List<Integer> intArrTemp = new ArrayList<>();
            DigitsValidation.checkArrIfOfNumbers(args);
            this.sum = 0;
            this.mult = 1;
            for (int i = 0; i < args.length; i++) {
                Integer numberTemp = Integer.parseInt(args[i]);
                intArrTemp.add(numberTemp);
                sum += numberTemp;
                mult *= numberTemp;
            }
            this.intArr = intArrTemp;

        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getIntArr() {
        return intArr;
    }

    public void setIntArr(List<Integer> intArr) {
        this.intArr = intArr;
    }

    public Integer getSum() {
        return sum;
    }

    public Integer getMult() {
        return mult;
    }
}
