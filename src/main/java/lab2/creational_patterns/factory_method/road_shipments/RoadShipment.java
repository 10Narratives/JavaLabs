package lab2.creational_patterns.factory_method.road_shipments;

import lab2.creational_patterns.factory_method.interfaces.Shipment;

public class RoadShipment implements Shipment {
    private final String senderName;
    private final String targetAddress;

    public RoadShipment(String senderName, String targetAddress) {
        this.senderName = senderName;
        this.targetAddress = targetAddress;
    }

    @Override
    public void deliver() {
        System.out.println("road shipment "+ this.senderName + " " + this.targetAddress);
    }
}
