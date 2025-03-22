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
        if (position.getX() == destination.getX() && position.getY() == destination.getY())
            return true;

        double deltaX = destination.getX() - this.position.getX();
        double deltaY = destination.getY() - this.position.getY();

        double requiredDist = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        double allowedDist = fuelLevel * movementCost;

        if (allowedDist >= requiredDist) {
            double requiredFuel = requiredDist / movementCost;
            fuelLevel -= requiredFuel;
            position.translate(deltaX, deltaY);
            return true;
        }

        fuelLevel = 0.0;

        if (position.getX() != destination.getX() && position.getY() != destination.getY()) {
            double coefficient = destination.getX() / destination.getY();
            deltaY = allowedDist / Math.sqrt(coefficient*coefficient + 1);
            deltaX = coefficient * deltaY;
            position.translate(deltaX, deltaY);
        } else if (position.getX() == destination.getX()) {
            position.translate(allowedDist, 0);
        } else if (position.getY() == destination.getY()) {
            position.translate(0, allowedDist);
        }

        return false;
    }
}