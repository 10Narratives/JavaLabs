package lab2.creational_patterns.factory_method;

import lab2.creational_patterns.factory_method.interfaces.Shipment;
import lab2.creational_patterns.factory_method.interfaces.ShipmentService;
import lab2.creational_patterns.factory_method.road_shipments.RoadShipmentService;

public class Main {
    public static void main(String[] args) {
        ShipmentService service = new RoadShipmentService();
        Shipment shipment = service.createShipment("John", "Moscow");
        shipment.deliver();
    }
}
