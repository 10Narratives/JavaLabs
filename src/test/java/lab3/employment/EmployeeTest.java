package lab3.employment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Employee Class Tests")
public class EmployeeTest {

    @Test
    @DisplayName("Constructor initializes name and salary correctly")
    void testConstructorInitialization() {
        // Arrange
        String expectedName = "John Doe";
        double expectedSalary = 75000.0;

        // Act
        Employee employee = new Employee(expectedName, expectedSalary);

        // Assert
        assertEquals(expectedName, employee.getName(), "Name should match constructor parameter");
        assertEquals(expectedSalary, employee.getMeasure(), 0.001, "Salary should match constructor parameter");
    }

    @Test
    @DisplayName("getName() returns correct employee name")
    void testGetName() {
        // Arrange
        Employee employee = new Employee("Jane Smith", 60000.0);

        // Act
        String actualName = employee.getName();

        // Assert
        assertEquals("Jane Smith", actualName, "Should return the correct employee name");
    }

    @Test
    @DisplayName("getMeasure() returns correct salary value")
    void testGetMeasure() {
        // Arrange
        double expectedSalary = 90000.50;
        Employee employee = new Employee("Alice Johnson", expectedSalary);

        // Act
        double actualSalary = employee.getMeasure();

        // Assert
        assertEquals(expectedSalary, actualSalary, 0.001, "Should return the employee's salary");
    }

    @Test
    @DisplayName("Handles zero salary correctly")
    void testZeroSalary() {
        // Arrange
        Employee employee = new Employee("Bob", 0.0);

        // Act & Assert
        assertEquals(0.0, employee.getMeasure(), 0.001, "Should handle zero salary");
    }

    @Test
    @DisplayName("Handles negative salary values")
    void testNegativeSalary() {
        // Arrange
        Employee employee = new Employee("Charlie", -50000.0);

        // Act & Assert
        assertEquals(-50000.0, employee.getMeasure(), 0.001, "Should allow negative salary values");
    }
}