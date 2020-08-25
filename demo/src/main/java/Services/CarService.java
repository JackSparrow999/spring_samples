package Services;

import Models.Car;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 7/10/2020.
 */

@Service
public class CarService {

    List<Car> arr;

    public List<Car> getArr() {
        return arr;
    }

    public void setArr(List<Car> arr) {
        this.arr = arr;
    }

    public CarService(){
        arr = new ArrayList<Car>();
        arr.add(new Car("Camaro", "200"));
        arr.add(new Car("Veyron", "300"));
    }

    public Car getThatCar(String carName){
        for(Car temp: arr)
            if(temp.getName().equals(carName))
                return temp;
        return null;
    }

    public void addCar(Car newCar){
        System.out.println("Services called!");
        arr.add(newCar);
    }

    public Car updateCar(String name, String speed){
        for(Car temp: arr)
            if(temp.getName().equals(name)){
                temp.setSpeed(speed);
                return temp;
            }
        return null;
    }

    public void deleteCar(String name){
        for(int i=0;i<arr.size();i++)
            if(arr.get(i).getName().equals(name)){
                arr.remove(i);
                break;
            }
    }

}
