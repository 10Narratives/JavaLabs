package lab2.creational_patterns.abstract_factory;

import lab2.creational_patterns.abstract_factory.interfaces.Dessert;
import lab2.creational_patterns.abstract_factory.interfaces.FirstCourse;
import lab2.creational_patterns.abstract_factory.interfaces.KitchenFactory;
import lab2.creational_patterns.abstract_factory.interfaces.MainCourse;
import lab2.creational_patterns.abstract_factory.italian.ItalianKitchenFactory;
import lab2.creational_patterns.abstract_factory.japanese.JapaneseKitchenFactory;

public class Main {
    public static void main(String[] args) {
        KitchenFactory factory = new ItalianKitchenFactory();

        FirstCourse firstCourse = factory.createFirstCourse();
        firstCourse.boil();

        MainCourse mainCourse = factory.createMainCourse();
        mainCourse.roast();

        Dessert dessert = factory.createDessert();
        dessert.cool();

        factory = new JapaneseKitchenFactory();

        firstCourse = factory.createFirstCourse();
        firstCourse.boil();

        mainCourse = factory.createMainCourse();
        mainCourse.roast();

        dessert = factory.createDessert();
        dessert.cool();
    }
}
