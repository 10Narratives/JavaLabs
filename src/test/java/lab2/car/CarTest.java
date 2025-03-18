package lab2.car;

import lab2.point.PointModifiable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(100, 2);
    }

    @ParameterizedTest
    @CsvSource({
            "3.0, 4.0, true, 97.5",
            "60.0, 80.0, true, 50.0",
            "0.0, 0.0, true, 100.0",
            "-3.0, -4.0, true, 97.5",
            "10.0, 0.0, true, 95.0"
    })
    void testMoveTo(double destinationX, double destinationY, boolean expectedReached, double expectedFuel) {
        PointModifiable destination = new PointModifiable(destinationX, destinationY);

        boolean reached = car.moveTo(destination);

        System.out.println(car.getFuelLevel());

        assertEquals(expectedReached, reached);
        assertEquals(expectedFuel, car.getFuelLevel());
    }

    @ParameterizedTest
    @CsvSource({
            "100, 2, 100, 2",          // Valid fuel level and consumption rate
            "50, 1, 50, 1",            // Lower fuel level and consumption rate
            "0, 3, 0, 3"               // Zero fuel level
    })
    void testConstructor(double initialFuelLevel, double fuelConsumptionRate, double expectedFuelLevel, double expectedConsumptionRate) {
        Car car = new Car(initialFuelLevel, fuelConsumptionRate);

        assertEquals(expectedFuelLevel, car.getFuelLevel(), 0.0001, "Initial fuel level should match");
        assertEquals(expectedConsumptionRate, car.getMovementCost(), 0.0001, "Fuel consumption rate should match");
    }

    @ParameterizedTest
    @CsvSource({
            "100, 0",                  // Invalid: Consumption rate is zero
            "0, 0" ,                    // Invalid: Both fuel level and consumption rate are zero
            "-100, 100",
            "100, -100"
    })
    void testConstructor_InvalidArguments(double initialFuelLevel, double initialMovementCost) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(initialFuelLevel, initialMovementCost);
        });
    }
}