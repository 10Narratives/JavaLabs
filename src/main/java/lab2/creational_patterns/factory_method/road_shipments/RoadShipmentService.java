package lab2.creational_patterns.factory_method.road_shipments;

import lab2.creational_patterns.factory_method.interfaces.Shipment;
import lab2.creational_patterns.factory_method.interfaces.ShipmentService;

public class RoadShipmentService implements ShipmentService {
    @Override
    public Shipment createShipment(String senderName, String targetAddress) {
        return new RoadShipment(senderName, targetAddress);
    }
}
