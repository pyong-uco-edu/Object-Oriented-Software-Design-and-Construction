package test;

import java.util.ArrayList;

import model.idemo.Airplane;
import model.idemo.Car;
import model.idemo.Vehicle;

public class VehicleTest {
    public static void main(String[] args) {
        ArrayList<Vehicle> veh = new ArrayList<>();
        veh.add(new Car(4, 10, "Ford", 9000, "Sedan"));
        veh.add(new Airplane(100, 100, "Boeing", 500000, 350));
        veh.add(new Car(40, 60, "GM", 8500, "SUV"));
        veh.add(new Airplane(500, 700, "Airbus", 700000, 250));

        for (var v: veh) {
            System.out.println(v);
        }

        for (var v: veh) {
            String m = "" + v;
            if (v instanceof Car) {
                assert m.contains("Car");
            } else if (v instanceof Airplane) {
                assert m.contains("Airplane");
            }
        }
    }
}
