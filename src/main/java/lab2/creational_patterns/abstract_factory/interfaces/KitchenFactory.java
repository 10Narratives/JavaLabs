package lab2.creational_patterns.abstract_factory.interfaces;

public interface KitchenFactory {
    FirstCourse createFirstCourse();
    MainCourse createMainCourse();
    Dessert createDessert();
}
