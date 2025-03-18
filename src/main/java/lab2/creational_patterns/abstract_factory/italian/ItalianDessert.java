package lab2.creational_patterns.abstract_factory.italian;

import lab2.creational_patterns.abstract_factory.interfaces.Dessert;

public class ItalianDessert implements Dessert {
    private final String name;

    public ItalianDessert(String name) {
        this.name = name;
    }

    @Override
    public void cool() {
        System.out.println("Cooling " + name);
        System.out.println(name + "is a italian dessert\n");
    }
}
