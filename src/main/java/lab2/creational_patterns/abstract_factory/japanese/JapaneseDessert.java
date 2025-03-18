package lab2.creational_patterns.abstract_factory.japanese;

import lab2.creational_patterns.abstract_factory.interfaces.Dessert;

public class JapaneseDessert implements Dessert {
    private final String name;

    public JapaneseDessert(String name) {
        this.name = name;
    }

    @Override
    public void cool() {
        System.out.println("Cooling " + name);
        System.out.println(name + "is a japanese dessert\n");
    }
}
