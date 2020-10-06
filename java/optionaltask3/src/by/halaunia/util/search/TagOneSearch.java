package by.halaunia.util.search;

import by.halaunia.entities.Car;

public interface TagOneSearch {

    Boolean tagContains(Car car, Object tag);
    Boolean tagMore(Car car, Object tag);
    Boolean tagLess(Car car, Object tag);
}
