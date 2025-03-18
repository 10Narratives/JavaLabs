package lab2.creational_patterns.abstract_factory.italian;

import lab2.creational_patterns.abstract_factory.interfaces.Dessert;
import lab2.creational_patterns.abstract_factory.interfaces.FirstCourse;
import lab2.creational_patterns.abstract_factory.interfaces.KitchenFactory;
import lab2.creational_patterns.abstract_factory.interfaces.MainCourse;

public class ItalianKitchenFactory implements KitchenFactory {
    @Override
    public FirstCourse createFirstCourse() {
        return new ItalianFirstCourse("Zuppa Toscana");
    }

    @Override
    public MainCourse createMainCourse() {
        return new ItalianMainCourse("Risotto");
    }

    @Override
    public Dessert createDessert() {
        return new ItalianDessert("Gelato");
    }
}
