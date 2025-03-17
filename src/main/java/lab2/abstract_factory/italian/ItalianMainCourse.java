package lab2.abstract_factory.italian;

import lab2.abstract_factory.interfaces.MainCourse;

public class ItalianMainCourse implements MainCourse {
    private final String name;

    public ItalianMainCourse(String name) {
        this.name = name;
    }

    @Override
    public void roast() {
        System.out.println("Roasting " + name);
        System.out.println(name + "is an italian main course\n");
    }
}
