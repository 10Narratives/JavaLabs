package lab3.Measurable;

import lab3.Employment.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testConstructor() {
        Employee employee = new Employee("John Doe", 50000);
        assertEquals("John Doe", employee.getName(), "The name should be 'John Doe'");
        assertEquals(50000, employee.getMeasure(), "The salary should be 50000");
    }

    @Test
    void testGetName() {
        Employee employee = new Employee("Alice Smith", 60000);
        String name = employee.getName();
        assertEquals("Alice Smith", name, "The name should be 'Alice Smith'");
    }

    @Test
    void testGetMeasure() {
        Employee employee = new Employee("Bob Johnson", 75000);
        double measure = employee.getMeasure();
        assertEquals(75000, measure, "The salary (measure) should be 75000");
    }
}