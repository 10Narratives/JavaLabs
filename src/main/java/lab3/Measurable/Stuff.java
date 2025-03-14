package lab3.Measurable;

import java.util.ArrayList;
import java.util.Comparator;

public final class Stuff {
    private final ArrayList<Employee> employees;

    public Stuff() {
        this.employees = new ArrayList<>();
    }

    public Stuff(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void sort(StuffSortingOptions option) {
        Comparator<Employee> comparator = Comparator
                .comparingDouble(Employee::getMeasure)
                .thenComparing(Employee::getName);
        if (option == StuffSortingOptions.INC) {
            comparator = comparator.reversed();
        }
        this.employees.sort(comparator);
    }
}
