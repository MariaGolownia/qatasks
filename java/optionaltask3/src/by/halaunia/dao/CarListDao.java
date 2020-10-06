package by.halaunia.dao;

import by.halaunia.entities.Car;
import by.halaunia.util.search.TagOneSearch;
import by.halaunia.util.search.TagTwoSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarListDao implements CarDao {

    private List<Car> carListDao = new ArrayList<>();

    public CarListDao() {
    }

    public CarListDao(List<Car> carListDao) {
        Integer i = 0;
        for (Car carItem : carListDao) {
            carItem.setId(i++);
        }
        this.carListDao = carListDao;
    }

    public List<Car> getCarListDao() {
        return carListDao;
    }

    public void setCarListDao(List<Car> carListDao) {
        this.carListDao = carListDao;
    }

    @Override
    public void addCar(Car car) {
        try {
            car.generateId(getCarListDao());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        carListDao.add(car);
    }

    public void addCar(Car... car) {
        for (int i = 1; i < car.length; i++) {
            try {
                car[i].generateId(getCarListDao());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            addCar(car[i]);
        }
    }

    @Override
    public void removeCar(Car car) throws Exception {
        if (carListDao == null || carListDao.size() == 0) {
            throw new Exception("Error: you are trying to delete a car from an empty list!");
        } else {
            int idOfRemCar = 0;
            for (Car carItem : carListDao) {
                if (carItem.compareTo(car) == 0) {
                    idOfRemCar = carItem.getId();
                }
            }
            if (idOfRemCar != 0) {
                carListDao.remove(car);
            } else {
                throw new Exception("Error: cannot find wishful car because it wasn't found at list!");
            }
        }
    }

    @Override
    public Car get(Integer id) {
        Car car = null;
        for (int i = 0; i < carListDao.size(); i++) {
            if (carListDao.get(i).getId() == id) {
                car = carListDao.get(i);
            }
        }
        return car;
    }


    public int size() {
        return carListDao.size();
    }

    public Boolean contains(Object obj) {
        return carListDao.contains(obj);
    }


    public void sort(Comparator<Car> c) {
        carListDao.sort(c);
    }

    public void sort() {
        Collections.sort(carListDao);
    }

    public List<Car> searchByTag(TagOneSearch tagContains, Object tagValue) {
        List<Car> rezList = new ArrayList<Car>();
        for (Car carItem : carListDao) {
            if (tagContains.tagContains(carItem, tagValue)) {
                rezList.add(carItem);
            }
        }
        return rezList;
    }

    public List<Car> searchByTagMore(TagOneSearch tagContains, Object tagValue) {
        List<Car> rezList = new ArrayList<Car>();
        for (Car carItem : carListDao) {
            if (tagContains.tagMore(carItem, tagValue)) {
                rezList.add(carItem);
            }
        }
        return rezList;
    }

    public List<Car> searchByTagLess(TagOneSearch tagContains, Object tagValue) {
        List<Car> rezList = new ArrayList<Car>();
        for (Car carItem : carListDao) {
            if (tagContains.tagLess(carItem, tagValue)) {
                rezList.add(carItem);
            }
        }
        return rezList;
    }

    public List<Car> searchByTag(TagTwoSearch tagContains, Object tagValue1, Object tagValue2) {
        List<Car> rezList = new ArrayList<Car>();
        for (Car carItem : carListDao) {
            if (tagContains.tagContains(carItem, tagValue1, tagValue2)) {
                rezList.add(carItem);
            }
        }
        return rezList;
    }

    @Override
    public String toString() {
        String str = "";
        for (Car carItem : carListDao) {
            str += String.format("\n[%s, %s, %s, %s, %s, %s, %s]",
                    carItem.getId(), carItem.getMake(), carItem.getModel(), carItem.getYear(),
                    carItem.getColor(), carItem.getPrice(), carItem.getRegistryNumber());
        }
        return str;
    }

}
