package se.doverfelt.prog2.kap4.extrauppg;

/**
 * Filnamn: Carowner.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-09-30
 */
public class Carowner extends Person {

    private Car car;

    public Carowner(String name, String address, int age) {
        super(name, address, age);
    }

    public Car owns() {
        return car;
    }

    public void sellCar() {
        if (this.car != null) {
            car.sold();
        }
        car = null;
    }

    public void buyCar(Car newCar) {
        if (newCar.owner() == null) {
            car = newCar;
            car.bought(this);
        }
    }

    @Override
    public String toString() {
        return getName() + " " + getAge() + " years" + "\nAddress: " + getAddress();
    }
}
