package lab2.car;

import lab2.point.PointModifiable;

/// Represents a car that can move to specified destinations based on its fuel level and fuel consumption rate.
public class Car {
    public static final double INITIAL_X = 0.0;
    public static final double INITIAL_Y = 0.0;

    private final PointModifiable position;
    private double fuelLevel;
    private final double movementCost;

    public Car(double fuelLevel, double movementCost) {
        this.position = new PointModifiable(INITIAL_X, INITIAL_Y);
        if (fuelLevel < 0)
            throw new IllegalArgumentException("fuel level cannot be less than zero");
        if (movementCost <= 0)
            throw new IllegalArgumentException("fuel level cannot be less or equal to zero");
        this.fuelLevel = fuelLevel;
        this.movementCost = movementCost;
    }

    public PointModifiable getPosition() {
        return position;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public double getMovementCost() {
        return movementCost;
    }
    
    public boolean moveTo(PointModifiable destination) {
        double deltaX = destination.getX() - this.position.getX();
        double deltaY = destination.getY() - this.position.getY();
        double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        double requiredFuel = distance / movementCost;
        boolean reachable = requiredFuel <= this.fuelLevel;
        this.fuelLevel = reachable ? this.fuelLevel - requiredFuel : 0;
        this.position.translate(deltaX, deltaY);
        return reachable;
    }
}