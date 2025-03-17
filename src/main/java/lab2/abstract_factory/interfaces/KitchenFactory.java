package lab2.abstract_factory.interfaces;

public interface KitchenFactory {
    FirstCourse createFirstCourse();
    MainCourse createMainCourse();
    Dessert createDessert();
}
