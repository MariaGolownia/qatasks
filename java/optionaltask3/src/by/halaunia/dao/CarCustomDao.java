package by.halaunia.dao;

public class CarCustomDao {

    private final CarDao connection;

    public CarCustomDao (CarDao connection) {
        this.connection = connection;
    }

    public CarDao getConnection() {
        return connection;
    }
}
