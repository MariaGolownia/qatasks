package by.halaunia.entities.en_um;

import by.halaunia.entities.Car;

import java.util.Arrays;
import java.util.List;

public enum CarMake {
    AUDI ("A2", "A4", "A6"),
    BMW ("X5", "X6"),
    VOLVO ("XC40", "XC60"),
    PEUGEOT ("406", "407");

    private List<String> models;

    CarMake(String ... values) {
        this.models = Arrays.asList(values);
    }

    public List<String> getModels() {
        return models;
    }

    public void setModels(List<String> models) {
        this.models = models;
    }

    public String getModels (String carModel) throws Exception {
        String modelResult = null;
        List<String> models = getModels();
        for (String model : models) {
            if (model.toUpperCase().equals(carModel.toUpperCase().trim())) {
                modelResult = model;
            }
        }
        if (modelResult == null) {
            throw new Exception("The model " + carModel + " is not in system! Please, define more exactly it!");
        }
        return modelResult;
    }
}
