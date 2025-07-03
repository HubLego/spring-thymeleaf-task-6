package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {
    private final CarService carService;          // Сервис для работы с автомобилями

    @Autowired
    public CarController(CarService carService) {   // Внедрение зависимости через конструктор
        this.carService = carService;
    }

    /*
       Обрабатывает запросы на /cars
       @param count количество автомобилей для отображения (параметр запроса)
       @param model объект модели для передачи данных в представление
       @return имя представления
     */

    @GetMapping("/cars")
    public String showCars(@RequestParam (value = "count", required = false, defaultValue = "5") int count,
    Model model) {
        // Добавляем список автомобилей в модель
        model.addAttribute("cars", carService.getCars(count));
        return "cars";         // Возвращаем имя Thymeleaf-шаблона
    }
}
