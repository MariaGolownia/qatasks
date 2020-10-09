package by.halaunia.runner;

import by.halaunia.dao.CarCustomDao;
import by.halaunia.dao.CarListDao;
import by.halaunia.entities.Car;
import by.halaunia.entities.en_um.CarMake;
import by.halaunia.print.Print;
import by.halaunia.util.search.Search;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Car car1 = null;
//        Car car2 = null;
//        Car car3 = null;
//        Car car4 = null;
//        try {
//            car1  = new Car(CarMake.PEUGEOT, CarMake.PEUGEOT.getModels("406"), Short.valueOf("1999"), "blue",
//                    BigDecimal.valueOf(3000.00), "3676 II-7");
//            car2 = new Car(CarMake.AUDI, CarMake.AUDI.getModels("A6"), Short.valueOf("2010"), "white",
//                    BigDecimal.valueOf(15000.00), "7777 OP-7");
//            car3 = new Car(CarMake.BMW, CarMake.BMW.getModels("X5"), Short.valueOf("2015"), "black",
//                    BigDecimal.valueOf(29000.00), "3535 IO-5");
//            car4 = new Car(CarMake.BMW, CarMake.BMW.getModels("X6"), Short.valueOf("2000"), "red",
//                    BigDecimal.valueOf(22000.00), "7878 IO-5");
//
//            Print.println(car1);
//            Print.println(car2);
//            Print.println(car3);
//            Print.println(car4);
//        } catch (Exception e) {
//            Print.println(e.getMessage());
//            e.printStackTrace();
//        }
//
//        List<Car> cars = Arrays.asList(car1, car2, car3, car4);
//        CarListDao carListDao = new CarListDao(cars);
//        Print.println(carListDao.toString());
//
//        CarCustomDao carListDaoCustom = new CarCustomDao(carListDao);
//        // Search by tag
//        // список автомобилей заданной марки;
//        Print.println("Cписок автомобилей заданной марки: ");
//        Print.println(carListDaoCustom.getConnection().searchByTag(new Search.TagByMakeOne(),"BMW"));
//
//        // список автомобилей заданной модели, которые эксплуатируются больше n лет;
//        Print.println("Cписок автомобилей заданной модели, которые эксплуатируются больше n лет: ");
//        Print.println(carListDaoCustom.getConnection().searchByTag(new Search.TagByModelAndYear(),"BMW", 8));
//
//        //  список автомобилей заданного года выпуска, цена которых больше указанной.
//        Print.println("Cписок автомобилей заданного года выпуска, цена которых больше указанной: ");
//        Print.println(carListDaoCustom.getConnection().searchByTagMore(new Search.TagByPriceOne(), BigDecimal.valueOf(20000)));
        
    }
}
