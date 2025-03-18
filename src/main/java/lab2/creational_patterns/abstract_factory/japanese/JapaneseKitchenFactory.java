package lab2.creational_patterns.abstract_factory.japanese;

import lab2.creational_patterns.abstract_factory.interfaces.Dessert;
import lab2.creational_patterns.abstract_factory.interfaces.FirstCourse;
import lab2.creational_patterns.abstract_factory.interfaces.KitchenFactory;
import lab2.creational_patterns.abstract_factory.interfaces.MainCourse;

public class JapaneseKitchenFactory implements KitchenFactory {
    @Override
    public FirstCourse createFirstCourse() {
        return new JapaneseFirstCourse("Miso");
    }

    @Override
    public MainCourse createMainCourse() {
        return new JapaneseMainCourse("Sushi");
    }

    @Override
    public Dessert createDessert() {
        return new JapaneseDessert("Moti");
    }
}
