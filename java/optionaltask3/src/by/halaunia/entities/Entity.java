package by.halaunia.entities;

import by.halaunia.dao.CarListDao;
import by.halaunia.dao.EntityDao;

import java.util.List;
import java.util.Objects;

public abstract class Entity {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void generateId(List<? extends Entity> entityList) throws Exception {
        Integer maxIdValueTemp = -1;
        if (entityList != null && entityList.size() > 0) {
            if (entityList.get(0) instanceof Car) {
                List<Car> carList = (List<Car>) entityList;
                for (Car car : carList) {
                    maxIdValueTemp = car.getId();
                    if (car.getId() > maxIdValueTemp) {
                        maxIdValueTemp = car.getId();
                    }
                }
            } else {
                throw new Exception("Couldn't generate a new id for object of not Car class!");
            }
            if (maxIdValueTemp == Integer.MAX_VALUE) {
                throw new Exception("Couldn't generate a new id, because of big generated value! " +
                        "Please, call a support!");
            }
        }
        this.id = maxIdValueTemp++;
    }

    @Override
    public String toString() {
        return "\nEntity{" +
                "id='" + id + '\'' +
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
        } else {
            Entity entity = (Entity) o;
            return Objects.equals(getId(), entity.getId());
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
