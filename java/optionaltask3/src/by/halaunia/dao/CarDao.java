package by.halaunia.dao;

import by.halaunia.entities.Car;
import by.halaunia.util.search.TagOneSearch;
import by.halaunia.util.search.TagTwoSearch;

import java.util.Comparator;
import java.util.List;

public interface CarDao extends  EntityDao {

    public void addCar(Car car);
    public void addCar(Car... car);
    public void removeCar(Car car) throws Exception;
    public Car get(Integer id);
    public int size();
    public void sort();
    public void sort(Comparator<Car> c);
    public List<Car> searchByTag(TagOneSearch tagOneSearch, Object tagValue);
    public List<Car> searchByTagMore(TagOneSearch tagOneSearch, Object tagValue);
    public List<Car> searchByTagLess(TagOneSearch tagOneSearch, Object tagValue);
    public List<Car> searchByTag (TagTwoSearch tagOneSearch, Object tagValue1, Object tagValue2);
}
