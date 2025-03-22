package lab3.employment;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Stuff Class Tests")
class StuffTest {

    @Test
    @DisplayName("Default constructor initializes empty list")
    void testDefaultConstructor() {
        Stuff stuff = new Stuff();
        assertTrue(stuff.getEmployees().isEmpty());
    }

    @Test
    @DisplayName("Parameterized constructor initializes with valid list")
    void testParameterizedConstructor() {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee emp = new Employee("Test", 50000);
        employees.add(emp);

        Stuff stuff = new Stuff(employees);
        assertSame(employees, stuff.getEmployees());
    }

    @Test
    @DisplayName("Parameterized constructor throws NPE for null list")
    void testNullConstructorArgument() {
        assertThrows(NullPointerException.class, () -> new Stuff(null));
    }

    @Test
    @DisplayName("getEmployees returns the actual employee list")
    void testGetEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        Stuff stuff = new Stuff(employees);
        assertSame(employees, stuff.getEmployees());
    }

    @Test
    @DisplayName("Sorts ACS by measure then name ascending")
    void testSortACS() {
        Employee alice = new Employee("Alice", 50000);
        Employee bob = new Employee("Bob", 60000);
        Employee charlie = new Employee("Charlie", 50000);

        Stuff stuff = new Stuff(new ArrayList<>(Arrays.asList(bob, alice, charlie)));
        stuff.sort(StuffSortingOptions.ACS);

        assertEquals(Arrays.asList(alice, charlie, bob), stuff.getEmployees());
    }

    @Test
    @DisplayName("Sorts DESC by measure descending then name descending")
    void testSortDESC() {
        Employee alice = new Employee("Alice", 50000);
        Employee bob = new Employee("Bob", 60000);
        Employee charlie = new Employee("Charlie", 50000);

        Stuff stuff = new Stuff(new ArrayList<>(Arrays.asList(bob, alice, charlie)));
        stuff.sort(StuffSortingOptions.DESC);

        assertEquals(Arrays.asList(bob, charlie, alice), stuff.getEmployees());
    }

    @Test
    @DisplayName("Sorts same measures by name correctly")
    void testSortSameMeasure() {
        Employee dave = new Employee("Dave", 50000);
        Employee eve = new Employee("Eve", 50000);

        Stuff stuff = new Stuff(new ArrayList<>(Arrays.asList(eve, dave)));
        stuff.sort(StuffSortingOptions.ACS);
        assertEquals(Arrays.asList(dave, eve), stuff.getEmployees());

        stuff.sort(StuffSortingOptions.DESC);
        assertEquals(Arrays.asList(eve, dave), stuff.getEmployees());
    }

    @Test
    @DisplayName("Handles empty list sorting")
    void testSortEmptyList() {
        Stuff stuff = new Stuff();
        stuff.sort(StuffSortingOptions.ACS);
        assertTrue(stuff.getEmployees().isEmpty());
    }

    @Test
    @DisplayName("Handles single element sorting")
    void testSortSingleElement() {
        Employee emp = new Employee("Single", 1000);
        Stuff stuff = new Stuff(new ArrayList<>(Arrays.asList(emp)));
        stuff.sort(StuffSortingOptions.DESC);
        assertEquals(emp, stuff.getEmployees().get(0));
    }

    @Test
    @DisplayName("Sorts negative measures correctly")
    void testSortNegativeMeasures() {
        Employee emp1 = new Employee("Neg1", -1000);
        Employee emp2 = new Employee("Neg2", -2000);

        Stuff stuff = new Stuff(new ArrayList<>(Arrays.asList(emp1, emp2)));
        stuff.sort(StuffSortingOptions.ACS);
        assertEquals(Arrays.asList(emp2, emp1), stuff.getEmployees());

        stuff.sort(StuffSortingOptions.DESC);
        assertEquals(Arrays.asList(emp1, emp2), stuff.getEmployees());
    }
}