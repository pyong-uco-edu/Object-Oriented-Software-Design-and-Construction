package test;

import java.util.ArrayList;

import model.idemo.Animal;
import model.idemo.Bird;
import model.idemo.Dog;

public class AnimalTest {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog(50, 50, "Bulldog", 3, "white"));
        animals.add(new Bird(100, 100, "Eagle", 5, 10));
        animals.add(new Dog(150, 150, "Poodle", 3, "white"));
        animals.add(new Bird(100, 100, "Eagle", 5, 10));

        for (var a: animals) {
            System.out.println(a);
        }

        for (var a: animals) {
            String m = "" + a;
            if (a instanceof Dog) {
                assert m.contains("Dog");
            } else if (a instanceof Bird) {
                assert m.contains("Bird");
            }
        }
    }
}
