package lab3.Employment;

import lab3.Measurable.Measurable;

/**
 * Represents an employee with a name and salary.
 * This class implements the {@link Measurable} interface,
 * using the employee's salary as the measurement value.
 */
public class Employee implements Measurable {
    /**
     * The name of the employee.
     */
    String name;

    /**
     * The salary of the employee.
     */
    double salary;

    /**
     * Constructs an Employee with the specified name and salary.
     *
     * @param name   the name of the employee
     * @param salary the salary of the employee
     */
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    /**
     * Returns the name of the employee.
     *
     * @return the employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the measurement value of the employee,
     * which is the salary in this implementation.
     *
     * @return the salary of the employee
     */
    @Override
    public double getMeasure() {
        return salary;
    }
}
