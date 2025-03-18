package lab2.creational_patterns.factory_method.interfaces;

public interface ShipmentService {
    Shipment createShipment(String senderName, String targetAddress);
}
