package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.Service;

@Controller

public class CarController {

    private Service service;



    @Autowired
    public CarController(Service service) {
        this.service = service;
    }
    @RequestMapping("/cars")

    public String printAll(Model model, @RequestParam(value = "count", defaultValue = "5") int count) {









        model.addAttribute("cars", service.getList(count));
        return "cars";
    }
}
