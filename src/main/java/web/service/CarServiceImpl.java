package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.*;
@Service
public class CarServiceImpl implements CarService {

    private List<Car> list = new LinkedList<>();

    { // убрать
        for (int i = 1; i < 6; i++) {
            list.add(new Car(i, "Model " + i, i * 100));
        }
    }

    @Override
    public List<Car> getList(int count) {
        if (count < 5) {

            return list.stream().limit(count).toList();
        } else {
            return list;
        }

    }


}