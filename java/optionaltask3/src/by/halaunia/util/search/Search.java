package by.halaunia.util.search;

import by.halaunia.entities.Car;

import java.math.BigDecimal;
import java.sql.Time;

public class Search {

    public static class TagByMakeOne implements TagOneSearch {
        @Override
        public Boolean tagContains(Car car, Object tag) {
            return car.getMake().toString().contains((String)tag);
        }

        @Override
        public Boolean tagMore(Car car, Object tag) {
            //TODO
            return false;
        }

        @Override
        public Boolean tagLess(Car car, Object tag) {
            //TODO
            return false;
        }
    }

    public static class TagByModelAndYear implements TagTwoSearch{
        public Boolean tagContains(Car car, Object tag1, Object tag2) {
            Boolean result = false;
            result = new TagByMakeOne().tagContains(car, tag1);
            if (result.equals(true)) {
                java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
                calendar.setTime(new java.util.Date());
                int currentYear = calendar.get(java.util.Calendar.YEAR);
                result = new TagByYearOne().tagLess(car, (short)(currentYear - (int)tag2));
            }
            return result;
        }
    }

    public static class TagByRegistryNumberOne implements TagOneSearch {
        @Override
        public Boolean tagContains(Car car, Object tag) {
            return car.getRegistryNumber().contains((String)tag);
        }

        @Override
        public Boolean tagMore(Car car, Object tag) {
            //TODO
            return false;
        }

        @Override
        public Boolean tagLess(Car car, Object tag) {
            //TODO
            return false;
        }
    }

    public static class TagByYearOne implements TagOneSearch {
        @Override
        public Boolean tagContains(Car car, Object tag) {
            return car.getYear().equals((Short) tag);
        }

        @Override
        public Boolean tagMore(Car car, Object tag) {
            return (car.getYear().compareTo((Short) tag)) > 0;
        }

        @Override
        public Boolean tagLess(Car car, Object tag) {
            return (car.getYear().compareTo((Short) tag)) < 0;
        }
    }

    public static class TagByColorOne implements TagOneSearch {
        @Override
        public Boolean tagContains(Car car, Object tag) {
            return car.getColor().contains((String)tag);
        }

        @Override
        public Boolean tagMore(Car car, Object tag) {
            //TODO
            return false;
        }

        @Override
        public Boolean tagLess(Car car, Object tag) {
            //TODO
            return false;
        }
    }

    public static class TagByPriceOne implements TagOneSearch {
        @Override
        public Boolean tagContains(Car car, Object tag) {
            return car.getPrice().equals((BigDecimal)tag);
        }

        public Boolean tagMore(Car car, Object tag) {
            return (car.getPrice().compareTo((BigDecimal)tag) > 0);
        }

        public Boolean tagLess(Car car, Object tag) {
            return (car.getPrice().compareTo((BigDecimal)tag) < 0);
        }

        public Boolean tagBetween(Car car, Object tag1, Object tag2) {
            return (car.getPrice().compareTo((BigDecimal)tag1) > 0)
                    && (car.getPrice().compareTo((BigDecimal)tag2) < 0);
        }
    }
}
