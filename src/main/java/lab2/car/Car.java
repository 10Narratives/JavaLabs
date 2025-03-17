package lab2.car;

import lab2.point.PointModifiable;

/// Represents a car that can move to specified destinations based on its fuel level and fuel consumption rate.
public class Car {
    private final PointModifiable position;
    private final double fuelCosts;
    private double remainingFuel;

    /**
     * Constructs a new {@code Car} instance with the specified fuel level and fuel consumption rate.
     *
     * @param fuelLevel the initial amount of fuel in the car
     * @param fuelCosts the fuel consumption rate (fuel cost per unit distance)
     * @throws IllegalArgumentException if {@code fuelCosts} is zero
     */
    public Car(double fuelLevel, double fuelCosts) {
        if (fuelLevel < 0) {
            throw new IllegalArgumentException("Fuel level cannot be non positive");
        }

        if (fuelCosts < 1) {
            throw new IllegalArgumentException("Fuel costs cannot be non positive");
        }

        this.remainingFuel = fuelLevel;
        this.fuelCosts = fuelCosts;
        this.position = new PointModifiable();
    }

    /// Retrieves the current position of the car.
    public PointModifiable getPosition() {
        return position;
    }

    /// Retrieves the current fuel level of the car.
    public double getRemainingFuel() {
        return remainingFuel;
    }

    /// Retrieves the fuel consumption rate of the car.
    public double getFuelCosts() {
        return fuelCosts;
    }

    /**
     * Attempts to move the car to the specified destination.
     * The car will only move if it has enough fuel to cover the distance to the destination.
     *
     * @param destination the destination point to which the car should move
     * @return {@code true} if the destination was reached, {@code false} otherwise
     */
    public boolean moveTo(PointModifiable destination) {
        double distance = Math.sqrt(Math.pow(this.position.getX() - destination.getX(), 2)
                + Math.pow(this.position.getY() - destination.getY(), 2));
        double requiredFuel = distance / this.fuelCosts;
        boolean reachable = requiredFuel <= this.remainingFuel;
        this.remainingFuel = reachable ? this.remainingFuel - requiredFuel : 0;
        return reachable;
    }
}