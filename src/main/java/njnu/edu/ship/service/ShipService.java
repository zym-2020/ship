package njnu.edu.ship.service;

import njnu.edu.ship.pojo.Ship;

import java.util.List;
import java.util.Map;

public interface ShipService {

    void addAllShip ();

    Map<String,Object> QueryLenWidByMsi(Integer mmsi);

    void addShipColumn(List<Map<String, Object>> listYangZte,Integer zoom);
}
