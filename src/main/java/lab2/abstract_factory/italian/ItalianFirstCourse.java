package lab2.abstract_factory.italian;

import lab2.abstract_factory.interfaces.FirstCourse;

public class ItalianFirstCourse implements FirstCourse {
    private final String name;

    public ItalianFirstCourse(String name) {
        this.name = name;
    }

    @Override
    public void boil() {
        System.out.println("Boiling " + name);
        System.out.println(name + "is a italian first course\n");
    }
}
