package lab3.employment;

import java.util.ArrayList;
import java.util.Comparator;

/// Represents a collection of employees and provides functionality to sort them.
public final class Stuff {
    private final ArrayList<Employee> employees;

    ///  Constructs an empty {@code Stuff} object with no employees.
    public Stuff() {
        this.employees = new ArrayList<>();
    }

    /**
     * Constructs a {@code Stuff} object with the specified list of employees.
     *
     * @param employees the list of employees to be managed by this instance
     * @throws NullPointerException if the provided list is null
     */
    public Stuff(ArrayList<Employee> employees) {
        if (employees == null) {
            throw  new NullPointerException("cannot construct Stuff instance: provided list is null");
        }
        this.employees = employees;
    }

    /// Retrieves employees from Stuff object.
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Sorts the employees in this {@code Stuff} instance based on the specified sorting option.
     *
     * <p>
     * The sorting is performed using a {@link Comparator} with two keys:
     * <ol>
     *   <li><b>Primary Key:</b> The employee's measure (e.g., salary), accessed via {@link Employee#getMeasure()}.</li>
     *   <li><b>Secondary Key:</b> The employee's name, accessed via {@link Employee#getName()}.</li>
     * </ol>
     *
     * <p>
     * The sorting order depends on the provided {@link StuffSortingOptions}:
     * <ul>
     *   <li>{@link StuffSortingOptions#ACS}: Sorts employees by measure in ascending order, then by name in ascending order.</li>
     *   <li>{@link StuffSortingOptions#DESC}: Sorts employees by measure in descending order, then by name in ascending order.</li>
     * </ul>
     *
     * @param option the sorting option to apply; must be one of {@link StuffSortingOptions#ACS} or {@link StuffSortingOptions#DESC}
     */
    public void sort(StuffSortingOptions option) {
        Comparator<Employee> comparator = Comparator
                .comparingDouble(Employee::getMeasure)
                .thenComparing(Employee::getName);
        if (option == StuffSortingOptions.DESC) {
            comparator = comparator.reversed();
        }
        this.employees.sort(comparator);
    }
}
