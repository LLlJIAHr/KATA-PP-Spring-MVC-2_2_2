package web.service;

import web.model.Car;

import java.util.List;

public interface Service {
    void addFiveCars();

    List<Car> getList(int count);
}
