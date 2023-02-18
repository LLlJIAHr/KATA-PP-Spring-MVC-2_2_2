package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.LinkedList;
import java.util.List;

@Component
public class ServiceImpl implements Service {

    private List<Car> list = new LinkedList<>();

    @Override
    public void addFiveCars() {
        if (list.isEmpty()) {
            for (int i = 1; i < 6; i++) {
                list.add(new Car(i, "Model " + i, i * 100));
            }
        }
    }

    @Override
    public List<Car> getList(int count) {
        addFiveCars();
        if (count < 5) {
//            List<Car> tempList = new LinkedList<>();
//            for (int i = 0; i < count; i++) {
//                tempList.add(list.get(count));
//            }
            return list.stream().limit(count).toList();

        } else {
            return list;
        }

    }


}