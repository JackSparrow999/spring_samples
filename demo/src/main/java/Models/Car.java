package Models;

/**
 * Created by DELL on 7/10/2020.
 */
public class Car {

    String name;
    String speed;

    public Car(){}

    public Car(String name, String speed){
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
