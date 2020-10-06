package by.halaunia.entities;

import by.halaunia.entities.en_um.CarMake;
import by.halaunia.print.Print;
import by.halaunia.valid.DataValidator;
import by.halaunia.valid.IncorrectDataException;

import java.math.BigDecimal;
import java.util.Objects;

public class Car extends Entity implements Comparable<Car> {

    private CarMake make;
    private String model;
    private Short year;
    private String color;
    private BigDecimal price;
    private String registryNumber;

    public Car() {
        this.make = null;
        this.model = null;
        this.year = null;
        this.color = null;
        this.price = null;
        this.registryNumber = null;
    }

    public Car(CarMake make, String model, Short year, String color, BigDecimal price, String registryNumber) {
        this.make = make;
        this.model = model;
        try {
            DataValidator.checkPositiveBigDecimal(price);
            DataValidator.checkYear(year);
        } catch (IncorrectDataException e) {
            Print.println(e.getMessage());
            e.printStackTrace();
        }
        this.year = year;
        this.color = color;
        this.price = price;
        this.registryNumber = registryNumber;
    }

    public CarMake getMake() {
        return make;
    }

    public void setMake(CarMake make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        try {
            DataValidator.checkYear(year);
        } catch (IncorrectDataException e) {
            Print.println(e.getMessage());
            e.printStackTrace();
        }
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        try {
            DataValidator.checkPositiveBigDecimal(price);
        } catch (IncorrectDataException e) {
            Print.println(e.getMessage());
            e.printStackTrace();
        }
        this.price = price;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }


    @Override
    public String toString() {
        return super.toString() +
                " Car{" +
                "make='" + make.toString() + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", registryNumber='" + registryNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this == o) {
            return true;
        } else if (!this.getClass().equals(o.getClass())) {
            return false;
        } else if (!super.equals(o)) return false;
        else {
            Car car = (Car) o;
            return Objects.equals(getMake(), car.getMake()) &&
                    Objects.equals(getModel(), car.getModel()) &&
                    Objects.equals(getYear(), car.getYear()) &&
                    Objects.equals(getColor(), car.getColor()) &&
                    Objects.equals(getPrice(), car.getPrice()) &&
                    Objects.equals(getRegistryNumber(), car.getRegistryNumber());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMake(), getModel(), getYear(), getColor(), getPrice(), getRegistryNumber());
    }

    @Override
    public int compareTo(Car o) {
        int result = -1;
        if (o == null) return result;

        result = getMake().toString().compareTo(o.getMake().toString());
        if(result !=0) return result;

        result = getModel().compareTo(o.getModel());
        if(result !=0) return result;

        return getYear().compareTo(o.getYear());
    }
}
