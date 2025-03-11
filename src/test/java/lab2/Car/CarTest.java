package lab2.Car;

import lab2.Point.PointModifiable;
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
            "3.0, 4.0, true, 90.0",       // Successful move: Distance = 5.0, Fuel required = 10.0
            "60.0, 80.0, false, 100.0",   // Insufficient fuel: Distance = 100.0, Fuel required = 200.0
            "0.0, 0.0, true, 100.0",      // Same position: No movement, fuel remains unchanged
            "-3.0, -4.0, true, 90.0",     // Negative coordinates: Distance = 5.0, Fuel required = 10.0
            "10.0, 0.0, true, 80.0"       // Horizontal movement: Distance = 10.0, Fuel required = 20.0
    })
    void testMoveTo(double destinationX, double destinationY, boolean expectedReached, double expectedFuel) {
        PointModifiable destination = new PointModifiable(destinationX, destinationY);

        boolean reached = car.moveTo(destination);

        assertEquals(expectedReached, reached, "The car should " + (expectedReached ? "" : "not ") + "reach the destination");
        assertEquals(expectedFuel, car.getRemainingFuel(), 0.0001, "Remaining fuel should match");

        if (reached) {
            assertEquals(destinationX, car.getPosition().getX(), 0.0001, "X coordinate should match destination");
            assertEquals(destinationY, car.getPosition().getY(), 0.0001, "Y coordinate should match destination");
        } else {
            assertEquals(0.0, car.getPosition().getX(), 0.0001, "X coordinate should remain at origin");
            assertEquals(0.0, car.getPosition().getY(), 0.0001, "Y coordinate should remain at origin");
        }
    }

    @ParameterizedTest
    @CsvSource({
            "100, 2, 100, 2",          // Valid fuel level and consumption rate
            "50, 1, 50, 1",            // Lower fuel level and consumption rate
            "0, 3, 0, 3"               // Zero fuel level
    })
    void testConstructor(double initialFuelLevel, double fuelConsumptionRate, double expectedFuelLevel, double expectedConsumptionRate) {
        Car car = new Car(initialFuelLevel, fuelConsumptionRate);

        assertEquals(expectedFuelLevel, car.getRemainingFuel(), 0.0001, "Initial fuel level should match");
        assertEquals(expectedConsumptionRate, car.getFuelCosts(), 0.0001, "Fuel consumption rate should match");
    }

    @ParameterizedTest
    @CsvSource({
            "100, 0",                  // Invalid: Consumption rate is zero
            "0, 0"                     // Invalid: Both fuel level and consumption rate are zero
    })
    void testConstructor_InvalidFuelConsumptionRate(double initialFuelLevel, double fuelConsumptionRate) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car(initialFuelLevel, fuelConsumptionRate);
        });
        assertEquals("Fuel costs cannot be equal to zero", exception.getMessage());
    }
}