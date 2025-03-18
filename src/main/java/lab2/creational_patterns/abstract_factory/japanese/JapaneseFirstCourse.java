package lab2.creational_patterns.abstract_factory.japanese;

import lab2.creational_patterns.abstract_factory.interfaces.FirstCourse;

public class JapaneseFirstCourse implements FirstCourse {
    private final String name;

    public JapaneseFirstCourse(String name) {
        this.name = name;
    }

    @Override
    public void boil() {
        System.out.println("Boiling " + name);
        System.out.println(name + "is a japanese first course\n");
    }
}
