package Controllers;

import Models.Car;
import Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DELL on 7/10/2020.
 */

@RestController
public class HelloController {

    @Autowired
    private CarService cs;

    @RequestMapping("/cars")
    public List<Car> func(){
        System.out.println("Endpoint Hit!");
        return cs.getArr();
    }

    @RequestMapping(value = "/cars/{car_name}")
    public Car getThatCar(@PathVariable("car_name") String carName){
        return cs.getThatCar(carName);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public Car addCar(@RequestBody Car newCar){
        System.out.println("Endpoint hit!");
        cs.addCar(newCar);
        return newCar;
    }

    @RequestMapping(value = "/cars/{name}", method = RequestMethod.PUT)
    public Car updateCar(@PathVariable("name") String carname, @RequestBody Car c_speed){
        return cs.updateCar(carname, c_speed.getSpeed());
    }

    @RequestMapping(value = "/cars/{name}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable("name") String carName){
        cs.deleteCar(carName);
    }

}
