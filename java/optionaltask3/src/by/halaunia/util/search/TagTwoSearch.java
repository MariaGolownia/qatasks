package by.halaunia.util.search;

import by.halaunia.entities.Car;

public interface TagTwoSearch {

    Boolean tagContains(Car car, Object tag1, Object tag2);
}
