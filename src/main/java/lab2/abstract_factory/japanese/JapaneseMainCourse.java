package lab2.abstract_factory.japanese;

import lab2.abstract_factory.interfaces.MainCourse;

public class JapaneseMainCourse implements MainCourse {
    private final String name;

    public JapaneseMainCourse(String name) {
        this.name = name;
    }

    @Override
    public void roast() {
        System.out.println("Roasting " + name);
        System.out.println(name + "is an japanese main course\n");
    }
}
